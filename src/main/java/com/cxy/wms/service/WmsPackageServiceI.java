package com.cxy.wms.service;
import com.cxy.wms.entity.WmsPackageEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WmsPackageServiceI extends CommonService{
	
 	public void delete(WmsPackageEntity entity) throws Exception;
 	
 	public Serializable save(WmsPackageEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WmsPackageEntity entity) throws Exception;
 	
}
