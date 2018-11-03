package com.cxy.pallet.service;
import com.cxy.pallet.entity.WmsPalletEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WmsPalletServiceI extends CommonService{
	
 	public void delete(WmsPalletEntity entity) throws Exception;
 	
 	public Serializable save(WmsPalletEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WmsPalletEntity entity) throws Exception;
 	
}
