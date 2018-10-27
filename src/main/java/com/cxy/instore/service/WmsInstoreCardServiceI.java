package com.cxy.instore.service;
import com.cxy.instore.entity.WmsInstoreCardEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WmsInstoreCardServiceI extends CommonService{
	
 	public void delete(WmsInstoreCardEntity entity) throws Exception;
 	
 	public Serializable save(WmsInstoreCardEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WmsInstoreCardEntity entity) throws Exception;
 	
}
