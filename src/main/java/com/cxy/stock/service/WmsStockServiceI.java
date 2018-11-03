package com.cxy.stock.service;
import com.cxy.stock.entity.WmsStockEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WmsStockServiceI extends CommonService{
	
 	public void delete(WmsStockEntity entity) throws Exception;
 	
 	public Serializable save(WmsStockEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WmsStockEntity entity) throws Exception;

 	public boolean addStock(WmsStockEntity entity) throws Exception;
 	
}
