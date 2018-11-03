package com.cxy.pallet.controller;
import com.cxy.pallet.entity.WmsPalletEntity;
import com.cxy.pallet.service.WmsPalletServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.TreeChildCount;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.core.util.ExceptionUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.jwt.util.GsonUtil;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller  
 * @Description: 托盘信息表
 * @author onlineGenerator
 * @date 2018-11-03 15:52:59
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wmsPalletController")
@Api(value="WmsPallet",description="托盘信息表",tags="wmsPalletController")
public class WmsPalletController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(WmsPalletController.class);

	@Autowired
	private WmsPalletServiceI wmsPalletService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	
	


	/**
	 * 托盘信息表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/cxy/pallet/wmsPalletList");
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
	public void datagrid(WmsPalletEntity wmsPallet,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WmsPalletEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wmsPallet, request.getParameterMap());
		try{
			//自定义追加查询条件
			cq.eq("isdel", 0);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wmsPalletService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除托盘信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WmsPalletEntity wmsPallet, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wmsPallet = systemService.getEntity(WmsPalletEntity.class, wmsPallet.getId());
		message = "托盘信息表删除成功";
		if(wmsPallet.getPalletStatus() != 0){
			message = "删除失败，只有空闲状态的托盘可以删除";
		}else{
			try{
				WmsPalletEntity t = wmsPalletService.get(WmsPalletEntity.class, wmsPallet.getId());
				wmsPallet.setIsdel(1);
				MyBeanUtils.copyBeanNotNull2Bean(wmsPallet, t);
				wmsPalletService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}catch(Exception e){
				e.printStackTrace();
				message = "托盘信息表删除失败";
				throw new BusinessException(e.getMessage());
			}
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除托盘信息表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "托盘信息表删除成功";
		try{
			for(String id:ids.split(",")){
				WmsPalletEntity wmsPallet = systemService.getEntity(WmsPalletEntity.class, 
				id
				);
				wmsPalletService.delete(wmsPallet);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "托盘信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加托盘信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WmsPalletEntity wmsPallet, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "托盘信息表添加成功";
		try{
			wmsPallet.setIsdel(0);
			wmsPalletService.save(wmsPallet);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "托盘信息表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新托盘信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WmsPalletEntity wmsPallet, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "托盘信息表更新成功";
		WmsPalletEntity t = wmsPalletService.get(WmsPalletEntity.class, wmsPallet.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wmsPallet, t);
			wmsPalletService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "托盘信息表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 托盘信息表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WmsPalletEntity wmsPallet, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wmsPallet.getId())) {
			wmsPallet = wmsPalletService.getEntity(WmsPalletEntity.class, wmsPallet.getId());
			req.setAttribute("wmsPalletPage", wmsPallet);
		}
		return new ModelAndView("com/cxy/pallet/wmsPallet-add");
	}
	/**
	 * 托盘信息表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WmsPalletEntity wmsPallet, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wmsPallet.getId())) {
			wmsPallet = wmsPalletService.getEntity(WmsPalletEntity.class, wmsPallet.getId());
			req.setAttribute("wmsPalletPage", wmsPallet);
		}
		return new ModelAndView("com/cxy/pallet/wmsPallet-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wmsPalletController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WmsPalletEntity wmsPallet,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WmsPalletEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wmsPallet, request.getParameterMap());
		List<WmsPalletEntity> wmsPallets = this.wmsPalletService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"托盘信息表");
		modelMap.put(NormalExcelConstants.CLASS,WmsPalletEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("托盘信息表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wmsPallets);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WmsPalletEntity wmsPallet,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"托盘信息表");
    	modelMap.put(NormalExcelConstants.CLASS,WmsPalletEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("托盘信息表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<WmsPalletEntity> listWmsPalletEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WmsPalletEntity.class,params);
				for (WmsPalletEntity wmsPallet : listWmsPalletEntitys) {
					wmsPalletService.save(wmsPallet);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(e.getMessage());
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
	@ApiOperation(value="托盘信息表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WmsPalletEntity>> list() {
		List<WmsPalletEntity> listWmsPallets=wmsPalletService.getList(WmsPalletEntity.class);
		return Result.success(listWmsPallets);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取托盘信息表信息",notes="根据ID获取托盘信息表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WmsPalletEntity task = wmsPalletService.get(WmsPalletEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取托盘信息表信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建托盘信息表")
	public ResponseMessage<?> create(@ApiParam(name="托盘信息表对象")@RequestBody WmsPalletEntity wmsPallet, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WmsPalletEntity>> failures = validator.validate(wmsPallet);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wmsPalletService.save(wmsPallet);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("托盘信息表信息保存失败");
		}
		return Result.success(wmsPallet);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新托盘信息表",notes="更新托盘信息表")
	public ResponseMessage<?> update(@ApiParam(name="托盘信息表对象")@RequestBody WmsPalletEntity wmsPallet) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WmsPalletEntity>> failures = validator.validate(wmsPallet);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wmsPalletService.saveOrUpdate(wmsPallet);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新托盘信息表信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新托盘信息表信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除托盘信息表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" , id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wmsPalletService.deleteEntityById(WmsPalletEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("托盘信息表删除失败");
		}

		return Result.success();
	}
}
