package com.cxy.wms.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

/**
 * 功能描述:仓库基本信息维护sql接口 <br>
 *
 * @Author: wzw
 * @Date: 2018/10/10 16:45
 */
@MiniDao
public interface WareBaseInfoDao {

    @Arguments("areaId")
    @Sql("select count(*) from wms_ware_house where area_id=:areaId and isdel=0")
    Integer countAvailableWareHouse(String areaId);

}
