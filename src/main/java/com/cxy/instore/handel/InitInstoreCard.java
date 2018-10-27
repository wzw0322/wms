package com.cxy.instore.handel;

import com.cxy.utils.StringUtils;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * 功能描述:获取入库单号 <br>
 *
 * @Author: wzw
 * @Date: 2018/10/27 14:35
 */
public class InitInstoreCard {

        public static String getInstoreCard(int instoreType){
        String result = getInstoreType(instoreType)+"RK"+getInstoreDate()+ StringUtils.getNumStr(6);
        return result;
    }

    /**
     * 功能描述: 根据入库单类型ID获取起首字母<br>
     * @Author: wzw
     * @Date: 2018/10/27 14:54
     * @Param instoreType 入库单类型ID
     */
    public static String getInstoreType(int instoreType){
        String result = "";
        switch (instoreType){
            case 1:
                //托运单
                result = "TY";
                break;
            case 2:
                //退库单
                result = "TK";
                break;
            default:
                //其他
                result = "QT";
                break;
        }
        return result;
    }

    /**
     * 功能描述: 获取年后两位+月日字符串(如：181027)<br>
     * @Author: wzw
     * @Date: 2018/10/27 14:55
     */
    public static String getInstoreDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(System.currentTimeMillis()));
        String currentDate = sdf.format(c.getTime());
        String result = currentDate.substring(2, currentDate.length());
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getInstoreCard(1));
    }

}
