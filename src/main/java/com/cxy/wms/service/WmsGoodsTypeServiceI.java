package com.cxy.wms.service;
import com.cxy.wms.entity.WmsGoodsTypeEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WmsGoodsTypeServiceI extends CommonService{
	
 	public void delete(WmsGoodsTypeEntity entity) throws Exception;
 	
 	public Serializable save(WmsGoodsTypeEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WmsGoodsTypeEntity entity) throws Exception;
 	
}
