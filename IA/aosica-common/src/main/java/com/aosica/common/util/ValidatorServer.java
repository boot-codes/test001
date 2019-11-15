package com.aosica.common.util;

import org.apache.commons.lang3.StringUtils;

final public class ValidatorServer {


    // "@",
    private  final  static  String[] specialCharacter ={"~","!","#","$","%","^","&","*","<",">","?",":",";","\\(",")","{","}","[","]","|","/",".","-","+","=","\\\\","\\\"","'"} ;

    /**
     *  一次校验输入的单个内容。
     * 检查输入的内容，是否包含特殊字符。
     * @param value
     * @return
     */
    public static boolean isContainSpecialCharacter(final String value)
    {
        if(StringUtils.isNotBlank(value)) {
            for (int n=0 ;n<specialCharacter.length ;n++) {
                if(value.indexOf(specialCharacter[n]) >-1) {
                    return true;
                }
            }
        }
        return  false ;
    }


    /**‘
     *  批量校验。
     * 检查输入的内容，是否包含特殊字符。
     * @param value
     * @return
     */
    public static boolean isContainSpecialCharacter(final String... value) {
        if(value !=null && value.length >0) {
            for (int x = 0; x < value.length; x++)
            {
                for (int n = 0; n < specialCharacter.length; n++) {
                    if (value[x].indexOf(specialCharacter[n]) > -1) {
                        return true;
                    }
                }
            }
        }
        return  false ;
    }


}
