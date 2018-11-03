package com.cxy.pallet.service;
import com.cxy.pallet.entity.WmsPalletDayEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WmsPalletDayServiceI extends CommonService{
	
 	public void delete(WmsPalletDayEntity entity) throws Exception;
 	
 	public Serializable save(WmsPalletDayEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WmsPalletDayEntity entity) throws Exception;
 	
}
