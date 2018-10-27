package com.cxy.instore.handel;

import com.cxy.utils.StringUtils;
import org.jeecgframework.web.cgform.enhance.IFillRuleHandler;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 功能描述:初始化出库单号 <br>
 *
 * @Author: wzw
 * @Date: 2018/10/21 19:31
 */
public class InitCkCard{

    public static String execute() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(System.currentTimeMillis()));
        String currentDate = sdf.format(c.getTime());
        String randomStr = StringUtils.getNumStr(5);

        return "QC"+currentDate+randomStr;
    }
}
