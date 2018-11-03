package com.cxy.dao;

import com.cxy.pallet.entity.PalletDateCountInfo;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.ResultType;

import java.util.List;

/**
 * 功能描述:托盘管理模块dao <br>
 *
 * @Author: wzw
 * @Date: 2018/11/3 16:53
 */
@MiniDao
public interface PalletMiniDao {

    @Arguments({"startDay","endDay"})
    @ResultType(PalletDateCountInfo.class)
    List<PalletDateCountInfo> countPalletDate(String startDay, String endDay);

}
