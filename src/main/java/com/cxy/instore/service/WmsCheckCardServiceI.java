package com.cxy.instore.service;
import com.cxy.instore.entity.WmsCheckCardEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WmsCheckCardServiceI extends CommonService{
	
 	public void delete(WmsCheckCardEntity entity) throws Exception;
 	
 	public Serializable save(WmsCheckCardEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WmsCheckCardEntity entity) throws Exception;
 	
}
