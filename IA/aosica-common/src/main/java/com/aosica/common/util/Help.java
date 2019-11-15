package com.aosica.common.util;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Help {

    private Help() {
    }

    public static boolean isNull(Object object) {
        if (null == object) {
            return true;
        }
        if (object instanceof String) {
            return ("null".equals(((String) object).trim()) || "".equals(((String) object).trim()));
        } else if (object instanceof Set) {
            return ((Set) object).isEmpty();
        } else if (object instanceof Map) {
            return ((Map) object).isEmpty();
        } else if (object instanceof List) {
            return ((List) object).isEmpty();
        } else if (object.getClass().isArray()){
            Object[] objArray = (Object[])object;
        	if(objArray.length == 0){
        		return true;
        	}
        }
        return false;
    }

    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }


    //获取md5加密字符串
    public static String getMd5(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) { i += 256; }
                if (i < 16) { buf.append("0"); }
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    //获取md5两次加密字符串
    public static String getMd5Twice(String plainText) {
        return getMd5(getMd5(plainText));
    }

    
    /**
     * 判断target是否存在于boss字符串中
     *
     *  
     * @param boss      (.. , .. , ..)
     * @param target    (..)
     * @return
     */
    public static boolean hasContain(String boss, String target) {
        boolean flag = false;
        if (isNull(boss) || isNull(target)) {
            return flag;
        }
        if (("," + boss + ",").indexOf("," + target + ",") >= 0) {
            flag = true;
        }
        
        return flag;
    }
    
    /**
     * 判断target是否存在于boss字符串中
     *
     *  
     * @param boss      (.. , .. , ..)
     * @param target    (..)
     * @param caseSensitive 是否区分大小写
     * @return
     */
    public static boolean hasContain(String boss, String target,boolean caseSensitive) {
        boolean flag = false;
        if (isNull(boss) || isNull(target)) {
            return flag;
        }
        if(caseSensitive){
        	boss = boss.toLowerCase();
        	target = target.toLowerCase();
        }
        if (("," + boss + ",").indexOf("," + target + ",") >= 0) {
            flag = true;
        }
        
        return flag;
    }
    
    /**
     * 字符串增加内容
     *
     *  
     * @param target
     * @param content
     * @param checkExsit   true 排除已经存在的
     * 
     * @return
     */
    public static StringBuffer append(StringBuffer target, String content,
            boolean checkExsit) {
        if (checkExsit) {
            boolean flag = false;
            if (isNotNull(target)) {
                flag = hasContain(target.toString(), content);
            }
            if (!flag) {
                if (isNotNull(target)) {
                    target.append("," + content);
                }
                else {
                    target.append(content);
                }
            }
        }
        else {
            if (isNotNull(target)) {
                target.append("," + content);
            }
            else {
                target.append(content);
            }
        }
        
        return target;
    }
    
    /**
     * 判断对象是否存在， 如果存在返回自己， 如果不存在 返回not
     *
     *  
     * @param target
     * @param not
     * @return
     */
    public static Object exsitOrNot(Object target, Object not) {
        if (isNotNull(target)) {
            return target;
        }
        return not;
    }
    
    public static String arrayJoin(Object[] array , String split){
        return StringUtils.join(array, split);
    }
}
