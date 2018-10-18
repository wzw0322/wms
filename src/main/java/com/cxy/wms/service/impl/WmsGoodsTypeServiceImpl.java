package com.cxy.wms.service.impl;
import com.cxy.wms.service.WmsGoodsTypeServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.cxy.wms.entity.WmsGoodsTypeEntity;
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

@Service("wmsGoodsTypeService")
@Transactional
public class WmsGoodsTypeServiceImpl extends CommonServiceImpl implements WmsGoodsTypeServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(WmsGoodsTypeEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(WmsGoodsTypeEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WmsGoodsTypeEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	
}