package com.cxy.instore.controller;
import com.cxy.instore.dao.InstoreMiniDao;
import com.cxy.instore.entity.InstoreExtraInfo;
import com.cxy.instore.entity.WmsInstoreCardEntity;
import com.cxy.instore.handel.InitInstoreCard;
import com.cxy.instore.service.WmsInstoreCardServiceI;
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
 * @Description: 入库单
 * @author onlineGenerator
 * @date 2018-10-27 10:49:09
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wmsInstoreCardController")
@Api(value="WmsInstoreCard",description="入库单",tags="wmsInstoreCardController")
public class WmsInstoreCardController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(WmsInstoreCardController.class);

	@Autowired
	private WmsInstoreCardServiceI wmsInstoreCardService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private InstoreMiniDao instoreMiniDao;
	
	


	/**
	 * 入库单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/cxy/instore/wmsInstoreCardList");
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
	public void datagrid(WmsInstoreCardEntity wmsInstoreCard,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WmsInstoreCardEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wmsInstoreCard, request.getParameterMap());
		try{
			//自定义追加查询条件
			cq.eq("isdel", 0);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wmsInstoreCardService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除入库单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WmsInstoreCardEntity wmsInstoreCard, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "入库单删除成功";
		wmsInstoreCard = systemService.getEntity(WmsInstoreCardEntity.class, wmsInstoreCard.getId());
		if(wmsInstoreCard.getInstoreStatus() != 1){
			message = "删除失败，只有已提交状态的入库单可以删除";
		}else{
			try{
				WmsInstoreCardEntity t = wmsInstoreCardService.get(WmsInstoreCardEntity.class, wmsInstoreCard.getId());
				wmsInstoreCard.setIsdel(1);
				MyBeanUtils.copyBeanNotNull2Bean(wmsInstoreCard, t);
				wmsInstoreCardService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}catch(Exception e){
				e.printStackTrace();
				message = "入库单删除失败";
				throw new BusinessException(e.getMessage());
			}
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除入库单
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "入库单删除成功";
		try{
			for(String id:ids.split(",")){
				WmsInstoreCardEntity wmsInstoreCard = systemService.getEntity(WmsInstoreCardEntity.class, 
				id
				);
				wmsInstoreCardService.delete(wmsInstoreCard);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "入库单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加入库单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WmsInstoreCardEntity wmsInstoreCard, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "入库单添加成功";
		try{
			InstoreExtraInfo info = instoreMiniDao.getExtraInfoFromOrder(wmsInstoreCard.getOrderCode());
			wmsInstoreCard.setCustomerCode(info.getCustomerCode());
			wmsInstoreCard.setGoodsCode(info.getGoodsCode());
			wmsInstoreCard.setGoodsType(info.getGoodsType());
			wmsInstoreCard.setVolume(info.getVolume());
			wmsInstoreCard.setIsdel(0);
			//入库单状态 1-已提交 2-已质检 3-已收货 4-已上架
			wmsInstoreCard.setInstoreStatus(1);
			wmsInstoreCard.setInstoreCode(InitInstoreCard.getInstoreCard(wmsInstoreCard.getInstoreType()));
			wmsInstoreCardService.save(wmsInstoreCard);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "入库单添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新入库单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WmsInstoreCardEntity wmsInstoreCard, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "入库单更新成功";
		WmsInstoreCardEntity t = wmsInstoreCardService.get(WmsInstoreCardEntity.class, wmsInstoreCard.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wmsInstoreCard, t);
			wmsInstoreCardService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "入库单更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 入库单新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WmsInstoreCardEntity wmsInstoreCard, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wmsInstoreCard.getId())) {
			wmsInstoreCard = wmsInstoreCardService.getEntity(WmsInstoreCardEntity.class, wmsInstoreCard.getId());
			req.setAttribute("wmsInstoreCardPage", wmsInstoreCard);
		}
		return new ModelAndView("com/cxy/instore/wmsInstoreCard-add");
	}
	/**
	 * 入库单编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WmsInstoreCardEntity wmsInstoreCard, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wmsInstoreCard.getId())) {
			wmsInstoreCard = wmsInstoreCardService.getEntity(WmsInstoreCardEntity.class, wmsInstoreCard.getId());
			req.setAttribute("wmsInstoreCardPage", wmsInstoreCard);
		}
		return new ModelAndView("com/cxy/instore/wmsInstoreCard-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wmsInstoreCardController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WmsInstoreCardEntity wmsInstoreCard,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WmsInstoreCardEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wmsInstoreCard, request.getParameterMap());
		List<WmsInstoreCardEntity> wmsInstoreCards = this.wmsInstoreCardService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"入库单");
		modelMap.put(NormalExcelConstants.CLASS,WmsInstoreCardEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("入库单列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wmsInstoreCards);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WmsInstoreCardEntity wmsInstoreCard,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"入库单");
    	modelMap.put(NormalExcelConstants.CLASS,WmsInstoreCardEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("入库单列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<WmsInstoreCardEntity> listWmsInstoreCardEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WmsInstoreCardEntity.class,params);
				for (WmsInstoreCardEntity wmsInstoreCard : listWmsInstoreCardEntitys) {
					wmsInstoreCardService.save(wmsInstoreCard);
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
	@ApiOperation(value="入库单列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WmsInstoreCardEntity>> list() {
		List<WmsInstoreCardEntity> listWmsInstoreCards=wmsInstoreCardService.getList(WmsInstoreCardEntity.class);
		return Result.success(listWmsInstoreCards);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取入库单信息",notes="根据ID获取入库单信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WmsInstoreCardEntity task = wmsInstoreCardService.get(WmsInstoreCardEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取入库单信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建入库单")
	public ResponseMessage<?> create(@ApiParam(name="入库单对象")@RequestBody WmsInstoreCardEntity wmsInstoreCard, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WmsInstoreCardEntity>> failures = validator.validate(wmsInstoreCard);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wmsInstoreCardService.save(wmsInstoreCard);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("入库单信息保存失败");
		}
		return Result.success(wmsInstoreCard);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新入库单",notes="更新入库单")
	public ResponseMessage<?> update(@ApiParam(name="入库单对象")@RequestBody WmsInstoreCardEntity wmsInstoreCard) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WmsInstoreCardEntity>> failures = validator.validate(wmsInstoreCard);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wmsInstoreCardService.saveOrUpdate(wmsInstoreCard);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新入库单信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新入库单信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除入库单")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" , id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wmsInstoreCardService.deleteEntityById(WmsInstoreCardEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("入库单删除失败");
		}

		return Result.success();
	}
}
