package com.cxy.timmer;

import com.cxy.dao.PalletMiniDao;
import com.cxy.pallet.entity.PalletDateCountInfo;
import com.cxy.pallet.entity.WmsPalletDayEntity;
import com.cxy.pallet.service.WmsPalletDayServiceI;
import org.apache.commons.collections.CollectionUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 功能描述:托盘日用报表统计 <br>
 *
 * @Author: wzw
 * @Date: 2018/11/3 16:48
 */
@Service
public class PalletDayCountTimmer implements Job {

    private static final Logger logger = LoggerFactory.getLogger(PalletDayCountTimmer.class);

    @Autowired
    private PalletMiniDao palletMiniDao;
    @Autowired
    private WmsPalletDayServiceI wmsPalletDayService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("开始托盘日用报表统计...");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(System.currentTimeMillis()));
        String timeStr = sdf.format(c.getTime());
        Date timeDay = null;
        try {
            timeDay = sdf.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String startDay = timeStr+" 00:00:00";
        String endDay = timeStr+" 23:59:59";
        List<PalletDateCountInfo> palletDateCountInfos = palletMiniDao.countPalletDate(startDay, endDay);

        //添加到日报表中
        if(CollectionUtils.isNotEmpty(palletDateCountInfos)){
            int size = palletDateCountInfos.size();
            for (int i=0; i<size; i++) {
                PalletDateCountInfo dateCountInfo = palletDateCountInfos.get(i);
                WmsPalletDayEntity entity = new WmsPalletDayEntity();
                entity.setPalletMaterial(dateCountInfo.getPalletMaterial());
                entity.setPalletModel(dateCountInfo.getPalletModel());
                entity.setPalletType(dateCountInfo.getPalletType());
                entity.setFreeNum(dateCountInfo.getFreeNum());
                entity.setUseNum(dateCountInfo.getUseNum());
                entity.setMaintainNum(dateCountInfo.getMaintainNum());
                entity.setLostNum(dateCountInfo.getLostNum());
                entity.setCountNum(dateCountInfo.getFreeNum()+dateCountInfo.getUseNum()+dateCountInfo.getMaintainNum()+dateCountInfo.getLostNum());
                entity.setCountDate(timeDay);
                entity.setCreateDate(new Date(System.currentTimeMillis()));
                entity.setUpdateDate(entity.getCreateDate());
                try {
                    wmsPalletDayService.save(entity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        logger.info("结束托盘日用报表统计...");
    }
}
