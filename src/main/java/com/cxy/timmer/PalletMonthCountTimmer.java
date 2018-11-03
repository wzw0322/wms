package com.cxy.timmer;

import com.cxy.dao.PalletMiniDao;
import com.cxy.pallet.entity.PalletDateCountInfo;
import com.cxy.pallet.entity.WmsPalletMonthEntity;
import com.cxy.pallet.service.WmsPalletMonthServiceI;
import com.cxy.utils.DateUtils;
import org.apache.commons.collections.CollectionUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 功能描述:托盘月度使用情况汇总 <br>
 *
 * @Author: wzw
 * @Date: 2018/11/3 20:02
 */
public class PalletMonthCountTimmer implements Job {

    private static final Logger logger = LoggerFactory.getLogger(PalletMonthCountTimmer.class);

    @Autowired
    private PalletMiniDao palletMiniDao;
    @Autowired
    private WmsPalletMonthServiceI wmsPalletMonthServiceI;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("开始托盘月用报表统计...");
        Date currenTime = new Date(System.currentTimeMillis());
        //获取本月本月第一天
        String startDate = DateUtils.getFirstDayOfMonth(currenTime, DateUtils.PATTERN_DATE);
        String startDay = startDate+" 00:00:00";
        //获取本月最后一天
        String endDate = DateUtils.getLastDayOfMonth(currenTime, DateUtils.PATTERN_DATE);
        String endDay = endDate+" 23:59:59";

        Date countDay = DateUtils.stringToDate(endDate, DateUtils.PATTERN_DATE);

        logger.info("开始时间："+startDay);
        logger.info("结束时间："+endDay);

        List<PalletDateCountInfo> palletDateCountInfos = palletMiniDao.countPalletDate(startDay, endDay);
        if(CollectionUtils.isNotEmpty(palletDateCountInfos)){
            int size = palletDateCountInfos.size();
            for (int i = 0; i<size; i++) {
                PalletDateCountInfo dateCountInfo = palletDateCountInfos.get(i);
                WmsPalletMonthEntity entity = new WmsPalletMonthEntity();
                entity.setPalletMaterial(dateCountInfo.getPalletMaterial());
                entity.setPalletModel(dateCountInfo.getPalletModel());
                entity.setPalletType(dateCountInfo.getPalletType());
                entity.setFreeNum(dateCountInfo.getFreeNum());
                entity.setUseNum(dateCountInfo.getUseNum());
                entity.setMaintainNum(dateCountInfo.getMaintainNum());
                entity.setLostNum(dateCountInfo.getLostNum());
                entity.setCountNum(dateCountInfo.getFreeNum()+dateCountInfo.getUseNum()+dateCountInfo.getMaintainNum()+dateCountInfo.getLostNum());
                entity.setCountDate(countDay);
                entity.setCreateDate(new Date(System.currentTimeMillis()));
                entity.setUpdateDate(entity.getCreateDate());
                try {
                    wmsPalletMonthServiceI.save(entity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        logger.info("结束托盘月用报表统计...");
    }
}
