package com.aosica.lot.util;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Date;

/**
 * TODO 十六进制二进制数据格式转换工具类
 */
public class HexBinUtil {

    private final static  Logger LOGGER = LoggerFactory.getLogger(HexBinUtil.class) ;
 
	/**
	 * 16 进制字符串 转为 byte数组
	 * @param hexString
	 * @return
	 */
	public static byte[] hexStringToBytes(String hexString) {   
        if (StringUtils.isBlank(hexString)) {
            return null;   
        }   
        String hexStr = hexString.toUpperCase();
        int length = hexStr.length() / 2;
        char[] hexChars = hexStr.toCharArray();
        byte[] d = new byte[length];   
        for (int i = 0; i < length; i++) {   
            int pos = i * 2;   
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));   
        }   
        return d;   
    }

    public static byte[] hexStr2Byte(String hex) {
	    ByteBuffer bf = ByteBuffer.allocate(hex.length() / 2);
	    for (int i = 0; i < hex.length(); i++) {
	        String hexStr = hex.charAt(i) + ""; i++; hexStr += hex.charAt(i);
	        byte b = (byte) Integer.parseInt(hexStr, 16); bf.put(b);
	    }
	    return bf.array();
	}




    public static BigInteger hexStringToDecimal(String hexString) {
        BigInteger bigInteger = new BigInteger(hexString,16);
        return  bigInteger ;
    }

//    public static String hexStringToDecimal(String hexString) {
//        String s = new BigInteger(hexString, 16).toString();
//        return  s ;
//    }


    /**
     * 十六进制字符串 转为 十进制字符串
     * @param hexString
     * @return
     */
    public static String hexStrToIntegerStr(String hexString) {
        String s = new BigInteger(hexString, 16).toString();
        return  s ;
    }
    
    private static byte charToByte(char c) {   
        return (byte) "0123456789ABCDEF".indexOf(c);   
    } 
	
    /**
     * 二进制 byte 转为16进制字符串 。
     * @param src
     * @return
     */
    public static String bytesToHexString(byte[] src) throws Exception{

        if (src == null || src.length <= 0) {   
            return null;   
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < src.length; i++) {   
            int v = src[i] & 0xFF;   
            String hv = Integer.toHexString(v);   
            if (hv.length() < 2) {   
                stringBuilder.append(0);   
            }   
            stringBuilder.append(hv);   
        }   
        return stringBuilder.toString().toUpperCase();
    }


    /**
     * 数据采集时间 ---> 调换高低位。
     * 数据采集时间2018-03-28 11：03：29  高位在后，低位在前
     *  9255224266497907000  637028593430000000
     *  8071296F 212ED708  -->
     *  08D72E21 6F297180
     * @return
     */
    public static  String dataAcquisitionStringInversion(String dataString) {

        if(StringUtils.isBlank(dataString)) {
            LOGGER.error("要转换的日期不能为空.......");
            return  null ;
        }

        StringBuilder stringBuilder  = new StringBuilder() ;

        stringBuilder.append(dataString.substring(14,16)) ;
        stringBuilder.append(dataString.substring(12,14)) ;
        stringBuilder.append(dataString.substring(10,12)) ;
        stringBuilder.append(dataString.substring(8,10)) ;
        stringBuilder.append(dataString.substring(6,8)) ;
        stringBuilder.append(dataString.substring(4,6)) ;
        stringBuilder.append(dataString.substring(2,4)) ;
        stringBuilder.append(dataString.substring(0,2)) ;

        return  stringBuilder.toString() ;
    }


    public static String dataAcquisition(String hexString) {
        double tt1 = Double.parseDouble(hexStrToIntegerStr(hexString));
        double tt2 = Double.parseDouble("621355968000000000");
        Double v = ((tt1 - tt2) / 10000 ) -28800000;
        Date date3 = new Date(v.longValue());
        return  date3.toLocaleString() ;
    }


    public static void main(String[] args) {


        String s = HexBinUtil.dataAcquisitionStringInversion("8071296F212ED708");
        System.out.println(s);

    }




}
