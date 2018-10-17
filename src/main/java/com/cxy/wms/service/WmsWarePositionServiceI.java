package com.cxy.wms.service;
import com.cxy.wms.entity.WmsWarePositionEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WmsWarePositionServiceI extends CommonService{
	
 	public void delete(WmsWarePositionEntity entity) throws Exception;
 	
 	public Serializable save(WmsWarePositionEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WmsWarePositionEntity entity) throws Exception;
 	
}
