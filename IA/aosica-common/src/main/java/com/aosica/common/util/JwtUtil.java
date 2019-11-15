package com.aosica.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * @author yuzp
 * @create 2017-05-12 14:23
 * @desc JWT工具类
 **/
public final class JwtUtil {


    private final static String DEFAULT_SECRET = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=" ;

    //过期时间为24小时。
    private final static long DEFAULT_EXPIRE_TIME = System.currentTimeMillis()+1000*60*60*24*7;
    //private final static int EXPIRE_TIME = 1000*60;

    private final static String USER_NAME = "userName" ;




    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String username, String secret) {
        try {
            //根据密码生成JWT效验器
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim(USER_NAME, username)
                    .build();
            //效验TOKEN
            verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }


    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @return 是否正确
     */
    public static boolean verify(String token, String username) {
       return verify(token, username, DEFAULT_SECRET) ;
    }


    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(USER_NAME).asString();
        }
        catch (Exception e) {
            //throw  new AosicaGeneralException(" 从token 获取用户名失败",e) ;
            return null ;
        }
    }



    /**
     * 生成签名,5min后过期
     *
     * @param userName 用户名
     * @param secret   用户的密码
     * @return 加密的token
     */
    public static String generateToken(String userName, String secret,long expireTime) throws Exception {

        Date date = null ;
        // 如果expireTime 等于 -1 表示不过期
        if( expireTime != -1L) {
            date = new Date(expireTime);
        }

        Algorithm algorithm = null;
        try {
            algorithm = Algorithm.HMAC256(secret);
            // 附带username信息
            return JWT.create()
                    .withClaim(USER_NAME, userName)
                    .withExpiresAt(date)
                    .sign(algorithm);
        }
        catch (Exception e) {
            //throw new AosicaCreateTokenException("创建token 失败",e) ;
            return  null ;
        }

 
    }

    /**
     * 生成签名,5min后过期
     *
     * @param userName 用户名
     * @return 加密的token
     */
    public static String generateToken(String userName ) throws Exception {
        return  generateToken(userName, DEFAULT_SECRET,DEFAULT_EXPIRE_TIME) ;
    }


    /**
     *  设置过期时间
     * @param userName
     * @param expireTime
     * @return
     */
    public static String generateToken(String userName,long expireTime ) throws Exception {
        return  generateToken(userName, DEFAULT_SECRET,expireTime) ;
    }




    public static void main(String[] args) throws Exception {

//        String  token = sign("zdst111111");
//        System.out.println(token);
//
//        System.out.println(getUsername(token));


    }
}
