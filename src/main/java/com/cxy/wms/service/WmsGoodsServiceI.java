package com.cxy.wms.service;
import com.cxy.wms.entity.WmsGoodsEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WmsGoodsServiceI extends CommonService{
	
 	public void delete(WmsGoodsEntity entity) throws Exception;
 	
 	public Serializable save(WmsGoodsEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WmsGoodsEntity entity) throws Exception;
 	
}
