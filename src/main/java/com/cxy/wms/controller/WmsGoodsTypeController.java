package com.cxy.wms.controller;
import com.cxy.wms.entity.WmsGoodsTypeEntity;
import com.cxy.wms.service.WmsGoodsTypeServiceI;

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
 * @Description: 货物类型表
 * @author onlineGenerator
 * @date 2018-10-17 21:45:10
 * @version V1.0   
 *
 */
@Api(value="WmsGoodsType",description="货物类型表",tags="wmsGoodsTypeController")
@Controller
@RequestMapping("/wmsGoodsTypeController")
public class WmsGoodsTypeController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(WmsGoodsTypeController.class);

	@Autowired
	private WmsGoodsTypeServiceI wmsGoodsTypeService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 货物类型表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/cxy/wms/wmsGoodsTypeList");
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
	public void datagrid(WmsGoodsTypeEntity wmsGoodsType,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WmsGoodsTypeEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wmsGoodsType, request.getParameterMap());
		try{
			//自定义追加查询条件
			cq.eq("isdel", 0);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wmsGoodsTypeService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除货物类型表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WmsGoodsTypeEntity wmsGoodsType, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wmsGoodsType = systemService.getEntity(WmsGoodsTypeEntity.class, wmsGoodsType.getId());
		message = "货物类型表删除成功";
		if(wmsGoodsType.getGoodsStatus() != 2){
			message = "删除失败，只有不可用的货物类型才能删除";
		}else{
			try{
				WmsGoodsTypeEntity t = wmsGoodsTypeService.get(WmsGoodsTypeEntity.class, wmsGoodsType.getId());
				wmsGoodsType.setIsdel(1);
				MyBeanUtils.copyBeanNotNull2Bean(wmsGoodsType, t);
				wmsGoodsTypeService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}catch(Exception e){
				e.printStackTrace();
				message = "货物类型表删除失败";
				throw new BusinessException(e.getMessage());
			}
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除货物类型表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "货物类型表删除成功";
		try{
			for(String id:ids.split(",")){
				WmsGoodsTypeEntity wmsGoodsType = systemService.getEntity(WmsGoodsTypeEntity.class, 
				id
				);
				wmsGoodsTypeService.delete(wmsGoodsType);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "货物类型表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加货物类型表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WmsGoodsTypeEntity wmsGoodsType, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "货物类型表添加成功";
		try{
			wmsGoodsType.setIsdel(0);
			wmsGoodsTypeService.save(wmsGoodsType);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "货物类型表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新货物类型表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WmsGoodsTypeEntity wmsGoodsType, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "货物类型表更新成功";
		WmsGoodsTypeEntity t = wmsGoodsTypeService.get(WmsGoodsTypeEntity.class, wmsGoodsType.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wmsGoodsType, t);
			wmsGoodsTypeService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "货物类型表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 货物类型表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WmsGoodsTypeEntity wmsGoodsType, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wmsGoodsType.getId())) {
			wmsGoodsType = wmsGoodsTypeService.getEntity(WmsGoodsTypeEntity.class, wmsGoodsType.getId());
			req.setAttribute("wmsGoodsType", wmsGoodsType);
		}
		return new ModelAndView("com/cxy/wms/wmsGoodsType-add");
	}
	/**
	 * 货物类型表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WmsGoodsTypeEntity wmsGoodsType, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wmsGoodsType.getId())) {
			wmsGoodsType = wmsGoodsTypeService.getEntity(WmsGoodsTypeEntity.class, wmsGoodsType.getId());
			req.setAttribute("wmsGoodsType", wmsGoodsType);
		}
		return new ModelAndView("com/cxy/wms/wmsGoodsType-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wmsGoodsTypeController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WmsGoodsTypeEntity wmsGoodsType,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WmsGoodsTypeEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wmsGoodsType, request.getParameterMap());
		List<WmsGoodsTypeEntity> wmsGoodsTypes = this.wmsGoodsTypeService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"货物类型表");
		modelMap.put(NormalExcelConstants.CLASS,WmsGoodsTypeEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("货物类型表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wmsGoodsTypes);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WmsGoodsTypeEntity wmsGoodsType,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"货物类型表");
    	modelMap.put(NormalExcelConstants.CLASS,WmsGoodsTypeEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("货物类型表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<WmsGoodsTypeEntity> listWmsGoodsTypeEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WmsGoodsTypeEntity.class,params);
				for (WmsGoodsTypeEntity wmsGoodsType : listWmsGoodsTypeEntitys) {
					wmsGoodsTypeService.save(wmsGoodsType);
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
	@ApiOperation(value="货物类型表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WmsGoodsTypeEntity>> list() {
		List<WmsGoodsTypeEntity> listWmsGoodsTypes=wmsGoodsTypeService.getList(WmsGoodsTypeEntity.class);
		return Result.success(listWmsGoodsTypes);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取货物类型表信息",notes="根据ID获取货物类型表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WmsGoodsTypeEntity task = wmsGoodsTypeService.get(WmsGoodsTypeEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取货物类型表信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建货物类型表")
	public ResponseMessage<?> create(@ApiParam(name="货物类型表对象")@RequestBody WmsGoodsTypeEntity wmsGoodsType, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WmsGoodsTypeEntity>> failures = validator.validate(wmsGoodsType);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wmsGoodsTypeService.save(wmsGoodsType);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("货物类型表信息保存失败");
		}
		return Result.success(wmsGoodsType);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新货物类型表",notes="更新货物类型表")
	public ResponseMessage<?> update(@ApiParam(name="货物类型表对象")@RequestBody WmsGoodsTypeEntity wmsGoodsType) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WmsGoodsTypeEntity>> failures = validator.validate(wmsGoodsType);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wmsGoodsTypeService.saveOrUpdate(wmsGoodsType);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新货物类型表信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新货物类型表信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除货物类型表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" , id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wmsGoodsTypeService.deleteEntityById(WmsGoodsTypeEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("货物类型表删除失败");
		}

		return Result.success();
	}
}
