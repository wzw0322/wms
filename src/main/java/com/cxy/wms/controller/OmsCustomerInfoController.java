package com.cxy.wms.controller;
import com.cxy.wms.entity.OmsCustomerInfoEntity;
import com.cxy.wms.service.OmsCustomerInfoServiceI;
import com.cxy.wms.page.OmsCustomerInfoPage;
import com.cxy.wms.entity.OmsCustomerReceiverAddressEntity;

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
import org.jeecgframework.core.util.oConvertUtils;
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
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller
 * @Description: oms_customer_info
 * @author onlineGenerator
 * @date 2018-10-21 18:02:23
 * @version V1.0   
 *
 */
@Api(value="OmsCustomerInfo",description="oms_customer_info",tags="omsCustomerInfoController")
@Controller
@RequestMapping("/omsCustomerInfoController")
public class OmsCustomerInfoController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(OmsCustomerInfoController.class);

	@Autowired
	private OmsCustomerInfoServiceI omsCustomerInfoService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * oms_customer_info列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/cxy/wms/omsCustomerInfoList");
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
	public void datagrid(OmsCustomerInfoEntity omsCustomerInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(OmsCustomerInfoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, omsCustomerInfo,request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.omsCustomerInfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除oms_customer_info
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(OmsCustomerInfoEntity omsCustomerInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		omsCustomerInfo = systemService.getEntity(OmsCustomerInfoEntity.class, omsCustomerInfo.getId());
		String message = "oms_customer_info删除成功";
		try{
			omsCustomerInfoService.delMain(omsCustomerInfo);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "oms_customer_info删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除oms_customer_info
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "oms_customer_info删除成功";
		try{
			for(String id:ids.split(",")){
				OmsCustomerInfoEntity omsCustomerInfo = systemService.getEntity(OmsCustomerInfoEntity.class,
				id
				);
				omsCustomerInfoService.delMain(omsCustomerInfo);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "oms_customer_info删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加oms_customer_info
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HttpServletRequest request,OmsCustomerInfoPage omsCustomerInfoPage) {
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try {
			omsCustomerInfoService.addMain(omsCustomerInfoPage);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "oms_customer_info添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新oms_customer_info
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HttpServletRequest request,OmsCustomerInfoPage omsCustomerInfoPage) {
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			omsCustomerInfoService.updateMain(omsCustomerInfoPage);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新oms_customer_info失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * oms_customer_info新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HttpServletRequest req) {
		return new ModelAndView("com/cxy/wms/omsCustomerInfo-add");
	}
	
	/**
	 * oms_customer_info编辑页面跳转
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HttpServletRequest req) {
		String id = req.getParameter("id");
		OmsCustomerInfoPage omsCustomerInfoPage = new OmsCustomerInfoPage();
		if (StringUtil.isNotEmpty(id)) {
			OmsCustomerInfoEntity omsCustomerInfo = omsCustomerInfoService.getEntity(OmsCustomerInfoEntity.class,id);
			try {
				MyBeanUtils.copyBeanNotNull2Bean(omsCustomerInfo,omsCustomerInfoPage);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//===================================================================================
			//获取参数
			Object id0 = omsCustomerInfo.getId();
			//===================================================================================
		    //查询-客户信息附表-地址信息
		    String hql0 = "from OmsCustomerReceiverAddressEntity where 1 = 1 AND fkCustomerId = ? ";
		    List<OmsCustomerReceiverAddressEntity> omsCustomerReceiverAddressEntityList = systemService.findHql(hql0,id0);
		    if(omsCustomerReceiverAddressEntityList==null || omsCustomerReceiverAddressEntityList.size()<=0){
		    	omsCustomerReceiverAddressEntityList = new ArrayList<OmsCustomerReceiverAddressEntity>();
		    	omsCustomerReceiverAddressEntityList.add(new OmsCustomerReceiverAddressEntity());
		    }
		    omsCustomerInfoPage.setOmsCustomerReceiverAddressList(omsCustomerReceiverAddressEntityList);
		}
		req.setAttribute("omsCustomerInfoPage", omsCustomerInfoPage);
		return new ModelAndView("com/cxy/wms/omsCustomerInfo-update");
	}
	
    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(OmsCustomerInfoEntity omsCustomerInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(OmsCustomerInfoEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, omsCustomerInfo);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<OmsCustomerInfoEntity> list=this.omsCustomerInfoService.getListByCriteriaQuery(cq, false);
    	List<OmsCustomerInfoPage> pageList=new ArrayList<OmsCustomerInfoPage>();
        if(list!=null&&list.size()>0){
        	for(OmsCustomerInfoEntity entity:list){
        		try{
        			OmsCustomerInfoPage page=new OmsCustomerInfoPage();
        			MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            		Object id0 = entity.getId();
					String hql0 = "from OmsCustomerReceiverAddressEntity where 1 = 1 AND fkCustomerId = ? ";
					List<OmsCustomerReceiverAddressEntity> omsCustomerReceiverAddressEntityList = systemService.findHql(hql0,id0);
					page.setOmsCustomerReceiverAddressList(omsCustomerReceiverAddressEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"oms_customer_info");
        map.put(NormalExcelConstants.CLASS,OmsCustomerInfoPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("oms_customer_info列表", "导出人:Jeecg", "导出信息"));
        map.put(NormalExcelConstants.DATA_LIST,pageList);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

    /**
	 * 通过excel导入数据
	 * @param request
	 * @param
	 * @return
	 */
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
			params.setHeadRows(2);
			params.setNeedSave(true);
			try {
				List<OmsCustomerInfoPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), OmsCustomerInfoPage.class, params);
				for (OmsCustomerInfoPage page : list) {
		            omsCustomerInfoService.addMain(page);
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
	/**
	* 导出excel 使模板
	*/
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ModelMap map) {
		map.put(NormalExcelConstants.FILE_NAME,"oms_customer_info");
		map.put(NormalExcelConstants.CLASS,OmsCustomerInfoPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("oms_customer_info列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
		"导出信息"));
		map.put(NormalExcelConstants.DATA_LIST,new ArrayList());
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	* 导入功能跳转
	*
	* @return
	*/
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name", "omsCustomerInfoController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="oms_customer_info列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<OmsCustomerInfoPage>> list() {
		List<OmsCustomerInfoEntity> list= omsCustomerInfoService.getList(OmsCustomerInfoEntity.class);
    	List<OmsCustomerInfoPage> pageList=new ArrayList<OmsCustomerInfoPage>();
        if(list!=null&&list.size()>0){
        	for(OmsCustomerInfoEntity entity:list){
        		try{
        			OmsCustomerInfoPage page=new OmsCustomerInfoPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				    String hql0 = "from OmsCustomerReceiverAddressEntity where 1 = 1 AND fkCustomerId = ? ";
	    			List<OmsCustomerReceiverAddressEntity> omsCustomerReceiverAddressOldList = this.omsCustomerInfoService.findHql(hql0,id0);
				    page.setOmsCustomerReceiverAddressList(omsCustomerReceiverAddressOldList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
		return Result.success(pageList);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取oms_customer_info信息",notes="根据ID获取oms_customer_info信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		OmsCustomerInfoEntity task = omsCustomerInfoService.get(OmsCustomerInfoEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取oms_customer_info信息为空");
		}
		OmsCustomerInfoPage page = new OmsCustomerInfoPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from OmsCustomerReceiverAddressEntity where 1 = 1 AND fkCustomerId = ? ";
			List<OmsCustomerReceiverAddressEntity> omsCustomerReceiverAddressOldList = this.omsCustomerInfoService.findHql(hql0,id0);
		    page.setOmsCustomerReceiverAddressList(omsCustomerReceiverAddressOldList);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建oms_customer_info")
	public ResponseMessage<?> create(@ApiParam(name="oms_customer_info对象")@RequestBody OmsCustomerInfoPage omsCustomerInfoPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<OmsCustomerInfoPage>> failures = validator.validate(omsCustomerInfoPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}
		try{
			omsCustomerInfoService.addMain(omsCustomerInfoPage);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存oms_customer_info失败");
        }
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新oms_customer_info",notes="更新oms_customer_info")
	public ResponseMessage<?> update(@RequestBody OmsCustomerInfoPage omsCustomerInfoPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<OmsCustomerInfoPage>> failures = validator.validate(omsCustomerInfoPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}
		try {
			omsCustomerInfoService.updateMain(omsCustomerInfoPage);
		} catch (Exception e) {
			logger.info(e.getMessage());
	        return Result.error("更新oms_customer_info失败");
		}
		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除oms_customer_info")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			OmsCustomerInfoEntity omsCustomerInfo = omsCustomerInfoService.get(OmsCustomerInfoEntity.class, id);
			omsCustomerInfoService.delMain(omsCustomerInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("oms_customer_info删除失败");
		}

		return Result.success();
	}
	
}
