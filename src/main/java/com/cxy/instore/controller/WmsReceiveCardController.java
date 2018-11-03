package com.cxy.instore.controller;
import com.cxy.dao.InstoreMiniDao;
import com.cxy.instore.entity.WmsCheckCardEntity;
import com.cxy.instore.entity.WmsReceiveCardEntity;
import com.cxy.instore.handel.InitShCard;
import com.cxy.instore.service.WmsReceiveCardServiceI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxy.wms.entity.WmsWareHouseEntity;
import org.jeecgframework.web.system.pojo.base.TSUser;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;

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
 * @Description: 收货单
 * @author onlineGenerator
 * @date 2018-10-29 21:24:03
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wmsReceiveCardController")
@Api(value="WmsReceiveCard",description="收货单",tags="wmsReceiveCardController")
public class WmsReceiveCardController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(WmsReceiveCardController.class);

	@Autowired
	private WmsReceiveCardServiceI wmsReceiveCardService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private InstoreMiniDao instoreMiniDao;



	/**
	 * 收货单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/cxy/instore/wmsReceiveCardList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(WmsReceiveCardEntity wmsReceiveCard,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WmsReceiveCardEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wmsReceiveCard, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wmsReceiveCardService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除收货单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WmsReceiveCardEntity wmsReceiveCard, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wmsReceiveCard = systemService.getEntity(WmsReceiveCardEntity.class, wmsReceiveCard.getId());
		message = "收货单删除成功";
		try{
			wmsReceiveCardService.delete(wmsReceiveCard);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "收货单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除收货单
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "收货单删除成功";
		try{
			for(String id:ids.split(",")){
				WmsReceiveCardEntity wmsReceiveCard = systemService.getEntity(WmsReceiveCardEntity.class, 
				id
				);
				wmsReceiveCardService.delete(wmsReceiveCard);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "收货单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加收货单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WmsReceiveCardEntity wmsReceiveCard, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "收货单添加成功";
		try{
			//收货单初始化状态为已提交
			WmsCheckCardEntity checkCardEntity = instoreMiniDao.getCheckModelByCheckCode(wmsReceiveCard.getQcCode());
			wmsReceiveCard.setWareId(checkCardEntity.getWareId());
			wmsReceiveCard.setGoodsCode(checkCardEntity.getGoodsCode());
			wmsReceiveCard.setGoodsType(checkCardEntity.getGoodsType());
			wmsReceiveCard.setShStatus(1);
			wmsReceiveCard.setShCode(InitShCard.execute());
			wmsReceiveCardService.save(wmsReceiveCard);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "收货单添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新收货单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WmsReceiveCardEntity wmsReceiveCard, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "收货单更新成功";
		WmsReceiveCardEntity t = wmsReceiveCardService.get(WmsReceiveCardEntity.class, wmsReceiveCard.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wmsReceiveCard, t);
			wmsReceiveCardService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "收货单更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	@RequestMapping(params = "doOnShelf")
	@ResponseBody
	public AjaxJson doOnShelf(WmsReceiveCardEntity wmsReceiveCard, HttpServletRequest request){
		TSUser user = ResourceUtil.getSessionUser();
		String realname = user.getRealName();
		String message = null;
		AjaxJson j = new AjaxJson();
		WmsReceiveCardEntity receiveCardEntity = wmsReceiveCardService.get(WmsReceiveCardEntity.class, wmsReceiveCard.getId());
		try {
			if(receiveCardEntity.getShStatus() == 3){
				message = "无需重复上架";
			}else{
				//收货单上架
				receiveCardEntity.setPositionId(wmsReceiveCard.getPositionId());
				receiveCardEntity.setOnShelfMan(realname);
				receiveCardEntity.setOnShelfTime(new Date(System.currentTimeMillis()));
				receiveCardEntity.setShStatus(3);
				wmsReceiveCardService.saveOrUpdate(receiveCardEntity);
				//int receiveId = instoreMiniDao.onShelfReceiveCard(receiveCardEntity.getId(), 3, wmsReceiveCard.getPositionId(), realname);
				//修改入库单状态
				WmsCheckCardEntity checkCardEntity = instoreMiniDao.getCheckModelByCheckCode(receiveCardEntity.getQcCode());
				int instoreId = instoreMiniDao.updateInstoreCardStatus(checkCardEntity.getInstoreCode(), 4);
				if(instoreId>0){
					//获取仓库所在的区域
					WmsWareHouseEntity wmsWareHouse = systemService.getEntity(WmsWareHouseEntity.class, receiveCardEntity.getWareId());
					//入库存
					receiveCardEntity.setPositionId(wmsReceiveCard.getPositionId());
					wmsReceiveCardService.syncToStock(receiveCardEntity, wmsWareHouse.getAreaId());
				}
				message = "上架成功";
			}
		}catch (Exception e){
			e.printStackTrace();
			message = "上架失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	@RequestMapping(params = "doSure")
	@ResponseBody
	public Map<String, Integer> doSure(HttpServletRequest request){
		String id = request.getParameter("id");
		int result = 0;
		try {
			WmsReceiveCardEntity receiveCardEntity = wmsReceiveCardService.get(WmsReceiveCardEntity.class, id);
			if(receiveCardEntity.getShStatus() == 2){
				result = 2;
			}else{
				//修改收货单状态为确认
				int receiveId = instoreMiniDao.updateReceiveCardStatus(id, 2);
				//修改入库单状态
				WmsCheckCardEntity checkCardEntity = instoreMiniDao.getCheckModelByCheckCode(receiveCardEntity.getQcCode());
				int instoreId = instoreMiniDao.updateInstoreCardStatus(checkCardEntity.getInstoreCode(), 3);
				if(receiveId>0 && instoreId>0){
					result = 1;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			result = 0;
			throw new BusinessException(e.getMessage());
		}
		Map<String, Integer> map = new HashMap<>(1);
		map.put("result", result);
		return map;
	}

	/**
	 * 收货单新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WmsReceiveCardEntity wmsReceiveCard, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wmsReceiveCard.getId())) {
			wmsReceiveCard = wmsReceiveCardService.getEntity(WmsReceiveCardEntity.class, wmsReceiveCard.getId());
			req.setAttribute("wmsReceiveCardPage", wmsReceiveCard);
		}
		return new ModelAndView("com/cxy/instore/wmsReceiveCard-add");
	}
	/**
	 * 收货单编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WmsReceiveCardEntity wmsReceiveCard, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wmsReceiveCard.getId())) {
			wmsReceiveCard = wmsReceiveCardService.getEntity(WmsReceiveCardEntity.class, wmsReceiveCard.getId());
			req.setAttribute("wmsReceiveCardPage", wmsReceiveCard);
		}
		return new ModelAndView("com/cxy/instore/wmsReceiveCard-update");
	}

	@RequestMapping(params = "goOnShelf")
	public ModelAndView goOnShelf(WmsReceiveCardEntity wmsReceiveCard, HttpServletRequest req){
		if(StringUtil.isNotEmpty(wmsReceiveCard.getId())){
			wmsReceiveCard = wmsReceiveCardService.getEntity(WmsReceiveCardEntity.class, wmsReceiveCard.getId());
			req.setAttribute("wmsReceiveCardPage", wmsReceiveCard);
		}
		return new ModelAndView("com/cxy/instore/wmsReceiveCard-onshelf");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wmsReceiveCardController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WmsReceiveCardEntity wmsReceiveCard,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WmsReceiveCardEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wmsReceiveCard, request.getParameterMap());
		List<WmsReceiveCardEntity> wmsReceiveCards = this.wmsReceiveCardService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"收货单");
		modelMap.put(NormalExcelConstants.CLASS,WmsReceiveCardEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("收货单列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wmsReceiveCards);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WmsReceiveCardEntity wmsReceiveCard,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"收货单");
    	modelMap.put(NormalExcelConstants.CLASS,WmsReceiveCardEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("收货单列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<WmsReceiveCardEntity> listWmsReceiveCardEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WmsReceiveCardEntity.class,params);
				for (WmsReceiveCardEntity wmsReceiveCard : listWmsReceiveCardEntitys) {
					wmsReceiveCardService.save(wmsReceiveCard);
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
	@ApiOperation(value="收货单列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WmsReceiveCardEntity>> list() {
		List<WmsReceiveCardEntity> listWmsReceiveCards=wmsReceiveCardService.getList(WmsReceiveCardEntity.class);
		return Result.success(listWmsReceiveCards);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取收货单信息",notes="根据ID获取收货单信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WmsReceiveCardEntity task = wmsReceiveCardService.get(WmsReceiveCardEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取收货单信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建收货单")
	public ResponseMessage<?> create(@ApiParam(name="收货单对象")@RequestBody WmsReceiveCardEntity wmsReceiveCard, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WmsReceiveCardEntity>> failures = validator.validate(wmsReceiveCard);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wmsReceiveCardService.save(wmsReceiveCard);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("收货单信息保存失败");
		}
		return Result.success(wmsReceiveCard);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新收货单",notes="更新收货单")
	public ResponseMessage<?> update(@ApiParam(name="收货单对象")@RequestBody WmsReceiveCardEntity wmsReceiveCard) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WmsReceiveCardEntity>> failures = validator.validate(wmsReceiveCard);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wmsReceiveCardService.saveOrUpdate(wmsReceiveCard);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新收货单信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新收货单信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除收货单")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" , id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wmsReceiveCardService.deleteEntityById(WmsReceiveCardEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("收货单删除失败");
		}

		return Result.success();
	}
}
