package com.cxy.dao;

import com.cxy.stock.entity.WmsStockEntity;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;

/**
 * 功能描述:库存相关dao <br>
 *
 * @Author: wzw
 * @Date: 2018/10/30 22:52
 */
@MiniDao
public interface StockMiniDao {

    @Arguments({"cs_code","goods_code","ware_id","position_id"})
    @ResultType(WmsStockEntity.class)
    @Sql("select * from wms_stock where cs_code=:cs_code and goods_code=:goods_code and ware_id=:ware_id and position_id=:position_id")
    WmsStockEntity getExistStock(String cs_code, String goods_code, String ware_id, String position_id);

}
