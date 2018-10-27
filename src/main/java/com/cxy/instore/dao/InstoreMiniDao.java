package com.cxy.instore.dao;

import com.cxy.instore.entity.InstoreExtraInfo;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.ResultType;

/**
 * 功能描述:入库管理dao <br>
 *
 * @Author: wzw
 * @Date: 2018/10/27 14:05
 */
@MiniDao
public interface InstoreMiniDao {

    @Arguments("order_code")
    @ResultType(InstoreExtraInfo.class)
    InstoreExtraInfo getExtraInfoFromOrder(String order_code);

}
