package com.cxy.wms.service;
import com.cxy.wms.entity.WmsWareHouseEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WmsWareHouseServiceI extends CommonService{
	
 	public void delete(WmsWareHouseEntity entity) throws Exception;
 	
 	public Serializable save(WmsWareHouseEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WmsWareHouseEntity entity) throws Exception;
 	
}
