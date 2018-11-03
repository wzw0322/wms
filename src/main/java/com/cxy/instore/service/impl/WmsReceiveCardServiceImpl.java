package com.cxy.instore.service.impl;
import com.cxy.instore.service.WmsReceiveCardServiceI;
import com.cxy.stock.entity.WmsStockEntity;
import com.cxy.stock.service.WmsStockServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.cxy.instore.entity.WmsReceiveCardEntity;
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

@Service("wmsReceiveCardService")
@Transactional
public class WmsReceiveCardServiceImpl extends CommonServiceImpl implements WmsReceiveCardServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	private WmsStockServiceI wmsStockServiceI;
	
 	public void delete(WmsReceiveCardEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(WmsReceiveCardEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WmsReceiveCardEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}

	@Override
	public boolean syncToStock(WmsReceiveCardEntity receiveCardEntity, String areaId) throws Exception {
		WmsStockEntity stockEntity = new WmsStockEntity();
		stockEntity.setCsCode(receiveCardEntity.getCsCode());
		stockEntity.setCsName(receiveCardEntity.getCsName());
		stockEntity.setGoodsCode(receiveCardEntity.getGoodsCode());
		stockEntity.setGoodsName(receiveCardEntity.getGoodsName());
		stockEntity.setGoodsType(receiveCardEntity.getGoodsType());
		stockEntity.setAreaId(areaId);
		stockEntity.setWareId(receiveCardEntity.getPositionId());
		stockEntity.setPositionId(receiveCardEntity.getPositionId());
		stockEntity.setUnit(receiveCardEntity.getUnit());
		stockEntity.setStockQuantity(receiveCardEntity.getCurrentShNum());
		stockEntity.setStockWeight(receiveCardEntity.getNetWeight());
		stockEntity.setStockVolume(Double.valueOf(receiveCardEntity.getVolume()));
		return wmsStockServiceI.addStock(stockEntity);
	}
}