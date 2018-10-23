package com.cxy.wms.service.impl;
import com.cxy.wms.service.OmsCustomerInfoServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.cxy.wms.entity.OmsCustomerInfoEntity;
import com.cxy.wms.page.OmsCustomerInfoPage;
import com.cxy.wms.entity.OmsCustomerReceiverAddressEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;
import java.util.ArrayList;
import java.util.UUID;
import java.io.Serializable;

import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.minidao.util.FreemarkerParseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.jeecgframework.core.util.ResourceUtil;

@Service("omsCustomerInfoService")
@Transactional
public class OmsCustomerInfoServiceImpl extends CommonServiceImpl implements OmsCustomerInfoServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(OmsCustomerInfoEntity entity) throws Exception{
 		super.delete(entity);
 	}
	
	public void addMain(OmsCustomerInfoPage omsCustomerInfoPage) throws Exception {
		OmsCustomerInfoEntity omsCustomerInfo = new OmsCustomerInfoEntity();
		MyBeanUtils.copyBeanNotNull2Bean(omsCustomerInfoPage, omsCustomerInfo);
		//保存主信息
		this.save(omsCustomerInfo);
		/**保存-客户信息附表-地址信息*/
		List<OmsCustomerReceiverAddressEntity> omsCustomerReceiverAddressList = omsCustomerInfoPage.getOmsCustomerReceiverAddressList();
		for(OmsCustomerReceiverAddressEntity omsCustomerReceiverAddress:omsCustomerReceiverAddressList){
			//外键设置
			omsCustomerReceiverAddress.setFkCustomerId(omsCustomerInfo.getId());
			this.save(omsCustomerReceiverAddress);
		}
	}

	
	public void updateMain(OmsCustomerInfoPage omsCustomerInfoPage) throws Exception{
		OmsCustomerInfoEntity omsCustomerInfo = new OmsCustomerInfoEntity();
		//保存主表信息
		if(StringUtil.isNotEmpty(omsCustomerInfoPage.getId())){
			omsCustomerInfo = findUniqueByProperty(OmsCustomerInfoEntity.class, "id", omsCustomerInfoPage.getId());
			MyBeanUtils.copyBeanNotNull2Bean(omsCustomerInfoPage, omsCustomerInfo);
			this.saveOrUpdate(omsCustomerInfo);
		}else{
			this.saveOrUpdate(omsCustomerInfo);
		}
		//===================================================================================
		//获取参数
		Object id0 = omsCustomerInfo.getId();
		//===================================================================================
		//1.客户信息附表-地址信息数据库的数据
	    String hql0 = "from OmsCustomerReceiverAddressEntity where 1 = 1 AND fkCustomerId = ? ";
	    List<OmsCustomerReceiverAddressEntity> omsCustomerReceiverAddressOldList = this.findHql(hql0,id0);
		//2.客户信息附表-地址信息新的数据
		List<OmsCustomerReceiverAddressEntity> omsCustomerReceiverAddressList = omsCustomerInfoPage.getOmsCustomerReceiverAddressList();
	    //3.筛选更新明细数据-客户信息附表-地址信息
		if(omsCustomerReceiverAddressList!=null &&omsCustomerReceiverAddressList.size()>0){
			for(OmsCustomerReceiverAddressEntity oldE:omsCustomerReceiverAddressOldList){
				boolean isUpdate = false;
				for(OmsCustomerReceiverAddressEntity sendE:omsCustomerReceiverAddressList){
					//需要更新的明细数据-客户信息附表-地址信息
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-客户信息附表-地址信息
		    		super.delete(oldE);
	    		}
	    		
			}
			//4.持久化新增的数据-客户信息附表-地址信息
			for(OmsCustomerReceiverAddressEntity omsCustomerReceiverAddress:omsCustomerReceiverAddressList){
				if(oConvertUtils.isEmpty(omsCustomerReceiverAddress.getId())){
					//外键设置
					omsCustomerReceiverAddress.setFkCustomerId(omsCustomerInfo.getId());
					this.save(omsCustomerReceiverAddress);
				}
			}
		}
	}

	public void delMain(OmsCustomerInfoEntity omsCustomerInfo) throws Exception{
		//删除主表信息
		this.delete(omsCustomerInfo);
		//===================================================================================
		//获取参数
		Object id0 = omsCustomerInfo.getId();
		//===================================================================================
		//删除-客户信息附表-地址信息
	    String hql0 = "from OmsCustomerReceiverAddressEntity where 1 = 1 AND fkCustomerId = ? ";
	    List<OmsCustomerReceiverAddressEntity> omsCustomerReceiverAddressOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(omsCustomerReceiverAddressOldList);
	}
 	
}