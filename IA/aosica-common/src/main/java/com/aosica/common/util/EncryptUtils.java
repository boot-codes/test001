package com.aosica.common.util;

import org.apache.shiro.crypto.hash.Sha256Hash;

import java.util.UUID;

/**
 *  消息摘要生成工具
 *
 * @author yuzp
 */
final public class EncryptUtils {

    //公盐
    public final static String PUBLIC_SALT = "8d78869f470951332959580424d4bf4f";

    /**
     * 使用sha-256+salt的方式对密码进行加密后转换为base64
     *
     * @param source 密码原文
     * @return 通过算法加密后的base64
     */
//    public static String getDigest(String source) {
//        return new Sha256Hash(source, SALT).toBase64();
//    }


    public static String getDigest(String source,String salt) {
        return new Sha256Hash(source, salt,2).toBase64();
    }


    /**
     * 使用sha-256+salt的方式对密码进行加密后转换为base64
     *
     * @param key 登录key
     * @return 加密后的字符串
     */
    public static String getDigest(String key) {
        return  new Sha256Hash(key, PUBLIC_SALT,2).toBase64();
    }


    /**
     * 生成 私盐
     * @return
     */
    public static String getSalt() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//        Md5Hash md5 = new Md5Hash(uuid);
//        return md5.toBase64() ;
        return uuid ;
    }

//    public static void test01() {
//        //原始密码：
//        String source = "123456";
//        String username = "admin";
//        //盐
//        String salt = username+"8d78869f470951332959580424d4bf4f";
//        int hashIterations =2;
//        /**
//         * 第一个参数：明文，原始密码；
//         * 第二个参数：盐，通过使用随机数；
//         * 第三个参数：散列的次数，比如散列两次，相当于md5(md5(''))
//         *
//         */
//        Md5Hash md5Hash = new Md5Hash(source, salt, hashIterations);
//
//        String password_md5 = md5Hash.toString();
//        //System.out.println(password_md5);
//        //String algorithmName = "md5";//散列算法,md5,
//        String algorithmName = "SHA-256";
//        SimpleHash simpleHash = new SimpleHash(algorithmName, source, salt, hashIterations);
//        System.out.println(simpleHash.toString());
//    }

    public static void main(String[] args) {

        //String digest = EncryptUtils.getDigest("666666","admin"+"1516778118669352");
        //System.out.println(digest);

        String digest = EncryptUtils.getDigest("123456", getSalt());
        System.out.println(digest);

        //System.out.println(getSalt());

        //String digest1 = getDigest("jsb");
        //System.out.println(digest1);

    }



}
