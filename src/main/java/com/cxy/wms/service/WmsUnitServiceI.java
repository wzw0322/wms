package com.cxy.wms.service;
import com.cxy.wms.entity.WmsUnitEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WmsUnitServiceI extends CommonService{
	
 	public void delete(WmsUnitEntity entity) throws Exception;
 	
 	public Serializable save(WmsUnitEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WmsUnitEntity entity) throws Exception;
 	
}
