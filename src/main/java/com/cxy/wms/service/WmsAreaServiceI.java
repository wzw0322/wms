package com.cxy.wms.service;
import com.cxy.wms.entity.WmsAreaEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WmsAreaServiceI extends CommonService{
	
 	public void delete(WmsAreaEntity entity) throws Exception;
 	
 	public Serializable save(WmsAreaEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WmsAreaEntity entity) throws Exception;
 	
 	/**
	 * 自定义按钮-[修改]业务处理
	 * @param id
	 * @return
	 */
	 public void doUpdateAreaBus(WmsAreaEntity t) throws Exception;
 	/**
	 * 自定义按钮-[查看]业务处理
	 * @param id
	 * @return
	 */
	 public void doSearchAreaBus(WmsAreaEntity t) throws Exception;
}
