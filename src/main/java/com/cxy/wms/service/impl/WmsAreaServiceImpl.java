package com.cxy.wms.service.impl;
import com.cxy.wms.service.WmsAreaServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.cxy.wms.entity.WmsAreaEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

import org.jeecgframework.minidao.util.FreemarkerParseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.jeecgframework.core.util.ResourceUtil;

@Service("wmsAreaService")
@Transactional
public class WmsAreaServiceImpl extends CommonServiceImpl implements WmsAreaServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(WmsAreaEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(WmsAreaEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WmsAreaEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	/**
	 * 自定义按钮-[修改]业务处理
	 * @param id
	 * @return
	 */
	 public void doUpdateAreaBus(WmsAreaEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
	 }
 	/**
	 * 自定义按钮-[查看]业务处理
	 * @param id
	 * @return
	 */
	 public void doSearchAreaBus(WmsAreaEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
	 }
 	
}