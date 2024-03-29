package com.aosica.common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * @program: ai-planting->CalculateProportionUtil
 * @description: 计算百分比
 * @author: dwj
 * @create: 2019-09-02 15:13
 **/
public class CalculateProportionUtil {

    /**
     * 计算百分比 整数
     *
     * @param divisor
     * @param dividend
     * @return
     */
    public static String proportionInt(Integer divisor, Integer dividend) {
        if (dividend == null || divisor == null)
            return null;
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);
        if(dividend == 0){
            return "0%";
        }
        String result = numberFormat.format((float) divisor / (float) dividend * 100);
        if (result.indexOf(".") != -1) {
            result = Math.round(Double.parseDouble(result)) + "%";
        }else {
            result = result+"%";
        }
        return result;
    }

    /**
     * 计算百分比 整数
     *
     * @param divisor
     * @param dividend
     * @return
     */
    public static String proportionInt(Float divisor, Float dividend) {
        if (dividend == null || divisor == null)
            return null;
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);
        String result = numberFormat.format(divisor / dividend * 100);
        if (result.indexOf(".") != -1) {
            result = Math.round(Double.parseDouble(result)) + "%";
        }
        return result;
    }

    /**
     * 计算百分比 保留留n位小数
     *
     * @param divisor
     * @param dividend
     * @param bit
     * @return
     */
    public static String proportionDouble(Integer divisor, Integer dividend, Integer bit) {
        if (dividend == null || divisor == null || bit == null)
            return null;
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(bit);
        String result = numberFormat.format((float) divisor / (float) dividend * 100);

        return result + "%";
    }

    /**
     * 计算百分比 保留留n位小数
     *
     * @param divisor
     * @param dividend
     * @param bit
     * @return
     */
    public static String proportionDouble(Float divisor, Float dividend, Integer bit) {
        if (dividend == null || divisor == null || bit == null)
            return null;
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(bit);
        String result = numberFormat.format(divisor / dividend * 100);

        return result + "%";
    }


    /**
     * 保留n为小数
     *
     * @param d
     * @param bit
     * @return
     */
    public static Double doubleBit(Double d, Integer bit) {
        if (d == null || bit == null)
            return null;
        BigDecimal bg = new BigDecimal(d).setScale(bit, RoundingMode.DOWN);
        return bg.doubleValue();
    }


    /**
     * 保留n位小数,小数不足补0
     *
     * @param d
     * @param bit
     * @return
     */
    public static Double doubleBitWhole(Double d, Integer bit) {
        if (d == null || bit == null)
            return null;
        BigDecimal bg = new BigDecimal(d).setScale(bit, RoundingMode.DOWN);
        String dobu = bg.doubleValue() + "";
        if (dobu.indexOf(".") != -1) {
            String small = dobu.split("\\.")[1];
            for (int i = 0; i < bit - small.length(); i++) {
                dobu += "0";
            }

        }
        return Double.parseDouble(dobu);
    }



    public static String proportionDoubleNoSign(Integer divisor, Integer dividend, Integer bit) {
        if (dividend == null || divisor == null || bit == null)
            return null;
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(bit);
        if(dividend == 0){
            return "0";
        }
        String result = numberFormat.format((float) divisor / (float) dividend * 100);

        return result;
    }
}
