package com.cxy.wms.controller;
import com.cxy.wms.entity.WmsWarePositionEntity;
import com.cxy.wms.service.WmsWarePositionServiceI;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller  
 * @Description: 仓位信息表
 * @author onlineGenerator
 * @date 2018-10-15 16:27:40
 * @version V1.0   
 *
 */
@Api(value="WmsWarePosition",description="仓位信息表",tags="wmsWarePositionController")
@Controller
@RequestMapping("/wmsWarePositionController")
public class WmsWarePositionController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(WmsWarePositionController.class);

	@Autowired
	private WmsWarePositionServiceI wmsWarePositionService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 仓位信息表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/cxy/wms/wmsWarePositionList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(WmsWarePositionEntity wmsWarePosition,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WmsWarePositionEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wmsWarePosition, request.getParameterMap());
		try{
			//自定义追加查询条件
			cq.eq("isdel", 0);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wmsWarePositionService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除仓位信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WmsWarePositionEntity wmsWarePosition, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "仓位信息表删除成功";
		wmsWarePosition = systemService.getEntity(WmsWarePositionEntity.class, wmsWarePosition.getId());
		if(wmsWarePosition.getPositionStatus() != 0){
			message = "删除失败，只有未使用的仓位才能删除";
		}else{
			try{
				WmsWarePositionEntity t = wmsWarePositionService.get(WmsWarePositionEntity.class, wmsWarePosition.getId());
				wmsWarePosition.setIsdel(1);
				MyBeanUtils.copyBeanNotNull2Bean(wmsWarePosition, t);
				wmsWarePositionService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}catch(Exception e){
				e.printStackTrace();
				message = "仓位信息表删除失败";
				throw new BusinessException(e.getMessage());
			}
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除仓位信息表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "仓位信息表删除成功";
		try{
			for(String id:ids.split(",")){
				WmsWarePositionEntity wmsWarePosition = systemService.getEntity(WmsWarePositionEntity.class, 
				id
				);
				wmsWarePositionService.delete(wmsWarePosition);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "仓位信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加仓位信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WmsWarePositionEntity wmsWarePosition, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "仓位信息表添加成功";
		try{
			wmsWarePosition.setIsdel(0);
			wmsWarePositionService.save(wmsWarePosition);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "仓位信息表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新仓位信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WmsWarePositionEntity wmsWarePosition, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "仓位信息表更新成功";
		WmsWarePositionEntity t = wmsWarePositionService.get(WmsWarePositionEntity.class, wmsWarePosition.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wmsWarePosition, t);
			wmsWarePositionService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "仓位信息表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 仓位信息表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WmsWarePositionEntity wmsWarePosition, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wmsWarePosition.getId())) {
			wmsWarePosition = wmsWarePositionService.getEntity(WmsWarePositionEntity.class, wmsWarePosition.getId());
			req.setAttribute("wmsWarePosition", wmsWarePosition);
		}
		return new ModelAndView("com/cxy/wms/wmsWarePosition-add");
	}
	/**
	 * 仓位信息表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WmsWarePositionEntity wmsWarePosition, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wmsWarePosition.getId())) {
			wmsWarePosition = wmsWarePositionService.getEntity(WmsWarePositionEntity.class, wmsWarePosition.getId());
			req.setAttribute("wmsWarePosition", wmsWarePosition);
		}
		return new ModelAndView("com/cxy/wms/wmsWarePosition-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wmsWarePositionController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WmsWarePositionEntity wmsWarePosition,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WmsWarePositionEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wmsWarePosition, request.getParameterMap());
		List<WmsWarePositionEntity> wmsWarePositions = this.wmsWarePositionService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"仓位信息表");
		modelMap.put(NormalExcelConstants.CLASS,WmsWarePositionEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("仓位信息表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wmsWarePositions);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WmsWarePositionEntity wmsWarePosition,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"仓位信息表");
    	modelMap.put(NormalExcelConstants.CLASS,WmsWarePositionEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("仓位信息表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<WmsWarePositionEntity> listWmsWarePositionEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WmsWarePositionEntity.class,params);
				for (WmsWarePositionEntity wmsWarePosition : listWmsWarePositionEntitys) {
					wmsWarePositionService.save(wmsWarePosition);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="仓位信息表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WmsWarePositionEntity>> list() {
		List<WmsWarePositionEntity> listWmsWarePositions=wmsWarePositionService.getList(WmsWarePositionEntity.class);
		return Result.success(listWmsWarePositions);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取仓位信息表信息",notes="根据ID获取仓位信息表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WmsWarePositionEntity task = wmsWarePositionService.get(WmsWarePositionEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取仓位信息表信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建仓位信息表")
	public ResponseMessage<?> create(@ApiParam(name="仓位信息表对象")@RequestBody WmsWarePositionEntity wmsWarePosition, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WmsWarePositionEntity>> failures = validator.validate(wmsWarePosition);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wmsWarePositionService.save(wmsWarePosition);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("仓位信息表信息保存失败");
		}
		return Result.success(wmsWarePosition);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新仓位信息表",notes="更新仓位信息表")
	public ResponseMessage<?> update(@ApiParam(name="仓位信息表对象")@RequestBody WmsWarePositionEntity wmsWarePosition) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WmsWarePositionEntity>> failures = validator.validate(wmsWarePosition);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wmsWarePositionService.saveOrUpdate(wmsWarePosition);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新仓位信息表信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新仓位信息表信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除仓位信息表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" , id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wmsWarePositionService.deleteEntityById(WmsWarePositionEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("仓位信息表删除失败");
		}

		return Result.success();
	}
}
