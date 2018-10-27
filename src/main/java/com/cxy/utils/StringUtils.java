package com.cxy.utils;

import java.util.Random;

/**
 * 功能描述:字符串工具类 <br>
 *
 * @Author: wzw
 * @Date: 2018/10/27 14:57
 */
public class StringUtils {

    /**
     * 功能描述: 获取位数的自然数字符串<br>
     * @Author: wzw
     * @Date: 2018/10/27 15:00
     * @Param nums 需要的位数
     */
    public static String getNumStr(int nums){
        StringBuilder sb = new StringBuilder(nums);
        for (int i=0; i<nums; i++){
            sb.append(new Random().nextInt(10));
        }
        return sb.toString();
    }

}
