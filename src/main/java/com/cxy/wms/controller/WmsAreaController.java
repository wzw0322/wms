package com.cxy.wms.controller;
import com.cxy.wms.dao.WareBaseInfoDao;
import com.cxy.wms.entity.WmsAreaEntity;
import com.cxy.wms.service.WmsAreaServiceI;

import java.util.ArrayList;
import java.util.HashMap;
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

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
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
 * @Description: 仓库区域信息表
 * @author onlineGenerator
 * @date 2018-10-15 12:06:59
 * @version V1.0   
 *
 */
@Api(value="WmsArea",description="仓库区域信息表",tags="wmsAreaController")
@Controller
@RequestMapping("/wmsAreaController")
public class WmsAreaController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(WmsAreaController.class);

	@Autowired
	private WmsAreaServiceI wmsAreaService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private WareBaseInfoDao wareBaseInfoDao;
	


	/**
	 * 仓库区域信息表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/cxy/wms/wmsAreaList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(WmsAreaEntity wmsArea,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WmsAreaEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wmsArea, request.getParameterMap());
		try{
		//自定义追加查询条件

		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wmsAreaService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除仓库区域信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WmsAreaEntity wmsArea, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "仓库区域信息表删除成功";
		int counts = wareBaseInfoDao.countAvailableWareHouse(wmsArea.getId());
		if(counts>0){
			message = "该仓库区域正在使用，无法删除";
		}else{
			try{
				wmsArea = systemService.getEntity(WmsAreaEntity.class, wmsArea.getId());
				wmsAreaService.delete(wmsArea);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}catch(Exception e){
				e.printStackTrace();
				message = "仓库区域信息表删除失败";
				throw new BusinessException(e.getMessage());
			}
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除仓库区域信息表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "仓库区域信息表删除成功";
		try{
			for(String id:ids.split(",")){
				WmsAreaEntity wmsArea = systemService.getEntity(WmsAreaEntity.class, 
				id
				);
				wmsAreaService.delete(wmsArea);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "仓库区域信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加仓库区域信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WmsAreaEntity wmsArea, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "仓库区域信息表添加成功";
		try{
			wmsAreaService.save(wmsArea);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "仓库区域信息表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	@RequestMapping(params = "doIsUpdate", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Integer> doIsUpdate(HttpServletRequest request){
		String id = request.getParameter("id");
		int counts = wareBaseInfoDao.countAvailableWareHouse(id);
		//返回1表示可以修改，0表示不可以修改
		int result = 0;
		if (counts == 0) {
			result = 1;
		}
		Map<String, Integer> map = new HashMap(1);
		map.put("result", result);
		return map;
	}
	
	/**
	 * 更新仓库区域信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WmsAreaEntity wmsArea, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "仓库区域信息表更新成功";
		WmsAreaEntity t = wmsAreaService.get(WmsAreaEntity.class, wmsArea.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wmsArea, t);
			wmsAreaService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "仓库区域信息表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
 	/**
	 * 自定义按钮-[修改]业务
	 * @return
	 */
	@RequestMapping(params = "doUpdateArea")
	@ResponseBody
	public AjaxJson doUpdateArea(WmsAreaEntity wmsArea, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "修改成功";
		WmsAreaEntity t = wmsAreaService.get(WmsAreaEntity.class, wmsArea.getId());
		try{
			wmsAreaService.doUpdateAreaBus(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "修改失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-[查看]业务
	 * @return
	 */
	@RequestMapping(params = "doSearchArea")
	@ResponseBody
	public AjaxJson doSearchArea(WmsAreaEntity wmsArea, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "查看成功";
		WmsAreaEntity t = wmsAreaService.get(WmsAreaEntity.class, wmsArea.getId());
		try{
			wmsAreaService.doSearchAreaBus(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "查看失败";
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 仓库区域信息表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WmsAreaEntity wmsArea, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wmsArea.getId())) {
			wmsArea = wmsAreaService.getEntity(WmsAreaEntity.class, wmsArea.getId());
			req.setAttribute("wmsArea", wmsArea);
		}
		return new ModelAndView("com/cxy/wms/wmsArea-add");
	}
	/**
	 * 仓库区域信息表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WmsAreaEntity wmsArea, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wmsArea.getId())) {
			wmsArea = wmsAreaService.getEntity(WmsAreaEntity.class, wmsArea.getId());
			req.setAttribute("wmsArea", wmsArea);
		}
		return new ModelAndView("com/cxy/wms/wmsArea-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wmsAreaController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WmsAreaEntity wmsArea,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WmsAreaEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wmsArea, request.getParameterMap());
		List<WmsAreaEntity> wmsAreas = this.wmsAreaService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"仓库区域信息表");
		modelMap.put(NormalExcelConstants.CLASS,WmsAreaEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("仓库区域信息表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wmsAreas);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WmsAreaEntity wmsArea,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"仓库区域信息表");
    	modelMap.put(NormalExcelConstants.CLASS,WmsAreaEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("仓库区域信息表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<WmsAreaEntity> listWmsAreaEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WmsAreaEntity.class,params);
				for (WmsAreaEntity wmsArea : listWmsAreaEntitys) {
					wmsAreaService.save(wmsArea);
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
	@ApiOperation(value="仓库区域信息表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WmsAreaEntity>> list() {
		List<WmsAreaEntity> listWmsAreas=wmsAreaService.getList(WmsAreaEntity.class);
		return Result.success(listWmsAreas);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取仓库区域信息表信息",notes="根据ID获取仓库区域信息表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WmsAreaEntity task = wmsAreaService.get(WmsAreaEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取仓库区域信息表信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建仓库区域信息表")
	public ResponseMessage<?> create(@ApiParam(name="仓库区域信息表对象")@RequestBody WmsAreaEntity wmsArea, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WmsAreaEntity>> failures = validator.validate(wmsArea);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wmsAreaService.save(wmsArea);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("仓库区域信息表信息保存失败");
		}
		return Result.success(wmsArea);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新仓库区域信息表",notes="更新仓库区域信息表")
	public ResponseMessage<?> update(@ApiParam(name="仓库区域信息表对象")@RequestBody WmsAreaEntity wmsArea) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WmsAreaEntity>> failures = validator.validate(wmsArea);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wmsAreaService.saveOrUpdate(wmsArea);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新仓库区域信息表信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新仓库区域信息表信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除仓库区域信息表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" , id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wmsAreaService.deleteEntityById(WmsAreaEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("仓库区域信息表删除失败");
		}

		return Result.success();
	}
}
