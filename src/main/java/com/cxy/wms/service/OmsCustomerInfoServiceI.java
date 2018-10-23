package com.cxy.wms.service;
import com.cxy.wms.entity.OmsCustomerInfoEntity;
import com.cxy.wms.page.OmsCustomerInfoPage;
import com.cxy.wms.entity.OmsCustomerReceiverAddressEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface OmsCustomerInfoServiceI extends CommonService{
 	public void delete(OmsCustomerInfoEntity entity) throws Exception;
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(OmsCustomerInfoPage omsCustomerInfoPage) throws Exception;
	        
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(OmsCustomerInfoPage omsCustomerInfoPage) throws Exception;
	
	/**
	 * 删除一对多
	 * 
	 */
	public void delMain (OmsCustomerInfoEntity omsCustomerInfo) throws Exception;
}
