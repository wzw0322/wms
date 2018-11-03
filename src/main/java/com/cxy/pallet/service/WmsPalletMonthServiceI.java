package com.cxy.pallet.service;
import com.cxy.pallet.entity.WmsPalletMonthEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WmsPalletMonthServiceI extends CommonService{
	
 	public void delete(WmsPalletMonthEntity entity) throws Exception;
 	
 	public Serializable save(WmsPalletMonthEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WmsPalletMonthEntity entity) throws Exception;
 	
}
