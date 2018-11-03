package com.cxy.instore.service;
import com.cxy.instore.entity.WmsReceiveCardEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WmsReceiveCardServiceI extends CommonService{
	
 	public void delete(WmsReceiveCardEntity entity) throws Exception;
 	
 	public Serializable save(WmsReceiveCardEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WmsReceiveCardEntity entity) throws Exception;

 	public boolean syncToStock(WmsReceiveCardEntity entity, String areaId) throws Exception;
 	
}
