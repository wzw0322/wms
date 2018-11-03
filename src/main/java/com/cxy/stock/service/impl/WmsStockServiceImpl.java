package com.cxy.stock.service.impl;
import com.cxy.dao.StockMiniDao;
import com.cxy.stock.service.WmsStockServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.cxy.stock.entity.WmsStockEntity;
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

@Service("wmsStockService")
@Transactional
public class WmsStockServiceImpl extends CommonServiceImpl implements WmsStockServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	private StockMiniDao stockMiniDao;
	
 	public void delete(WmsStockEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(WmsStockEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WmsStockEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}

	@Override
	public boolean addStock(WmsStockEntity entity) throws Exception {
		//先判断是否需要合并到库存
		WmsStockEntity stock = stockMiniDao.getExistStock(entity.getCsCode(),entity.getGoodsCode(),entity.getWareId(),entity.getPositionId());
		if(stock != null){
			stock.setStockVolume(stock.getStockVolume()+entity.getStockVolume());
			stock.setStockWeight(stock.getStockWeight()+entity.getStockWeight());
			stock.setStockQuantity(stock.getStockQuantity()+entity.getStockQuantity());
			saveOrUpdate(stock);
		}else{
			save(entity);
		}
		return true;
	}
}