package com.aosica.openapi.test;


import com.aosica.openapi.dto.OpenUser;
import com.aosica.openapi.service.OpenUserService;
import com.aosica.openapi.util.JwtUtil;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.Key;

/**
 * @PackgeName com.aosica.openapi.test
 * @ClassName TestApi.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/10/23 19:32
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/10/23$ 19:32$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApi {


    @Autowired
    private OpenUserService openUserService ;


    /**
     * 对称加密
     */
    public void test(String userId,long createTime )
    {

//        OpenUser openUser = openUserService.createOpenUser();
//        System.out.println(openUser);
//        AesCipherService aesCipherService = new AesCipherService();
//        aesCipherService.setKeySize(128); //设置key长度
//        //生成key
//        Key key = aesCipherService.generateNewKey();
//        StringBuffer stringBuffer = new StringBuffer() ;
//        stringBuffer.append(userId+"&").append(createTime) ;
//
//        System.out.println("加密之前的内容："+stringBuffer.toString());
//
//        //加密
//        String encrptText = aesCipherService.encrypt(stringBuffer.toString().getBytes(), key.getEncoded()).toHex();
//        System.out.println("加密之后的内容："+encrptText);
//        String s = Base64.encodeToString(encrptText.getBytes());
//        System.out.println("base 64 编码之后："+s);
//
//        //解密
//        String text2 = new String(aesCipherService.decrypt(Hex.decode(encrptText), key.getEncoded()).getBytes());
//        System.out.println("解密：" +text2);
//
//        String sign = JwtUtil.sign("Hzs9dY7akxrJHpefELSIeA&1571909071225", "12334");
//        System.out.println(sign);
//
//        String username = JwtUtil.getUsername(sign);
//        System.out.println(username);
    }



    /**
     * 生成 id  和  Secret
     */
    @Test
    public  void testGeneratorUserId() {


//        OpenUser openUser = openUserService.createOpenUser();
//        System.out.println(openUser);

//        String userId = this.openUserService.getUserId();
//        System.out.println(userId);
//
//        test(userId,System.currentTimeMillis());

        //System.out.println(replaceSpecStr("1234<>"));

        // 加密添加盐值 增大解密难度 2迭代两次
        //Md5Hash md55 = new Md5Hash(uuid,"aaa",2);
//        Md5Hash md55 = new Md5Hash(uuid,"aaa1111****)(@$%$^^",2);
//        System.out.println(md55.toBase64());

//        String password = DigestUtils.md5DigestAsHex(uuid.getBytes());
//
//        System.out.println(password);


//        String salt = DigestUtils.sha1Hex(UUID.randomUUID().toString()).substring(0, 4);
//        String saltString = DigestUtils.sha1Hex(password + salt) + salt;


//        String encryPassword = Base64.encodeBase64String(uuid.getBytes());
//        System.out.println(encryPassword);


//        ObjectIdGenerators objectIdGenerators = new ObjectIdGenerators() ;
//        ObjectIdGenerators.UUIDGenerator uuidGenerator = new ObjectIdGenerators.UUIDGenerator() ;
//
//        System.out.println(uuidGenerator.generateId(null));
//
//        //ObjectIdGenerators objectIdGenerators = new ObjectIdGenerators() ;
//        ObjectIdGenerators.IntSequenceGenerator intSequenceGenerator = new ObjectIdGenerators.IntSequenceGenerator() ;
//
//        System.out.println(intSequenceGenerator.generateId(null));


        // 对单个信息加密
//        Md5Hash md5 = new Md5Hash("123456");
//        System.out.println(md5.toString());
//
//        // 加密添加盐值 增大解密难度
//        md5 = new Md5Hash("123456","aaa");
//        System.out.println(md5.toString());
//
//        // 加密添加盐值 增大解密难度 2迭代两次
//        md5 = new Md5Hash("123456","aaa",2);
//        System.out.println(md5);

//        String md5Code = DigestUtils.md5DigestAsHex(String.valueOf("yuzp").getBytes());
//        System.out.println(md5Code);
        // 1jyxvCyX3YYMznqloHiOqg==
        // dHK2zNMNEy4/3+H3pM35gA==
        // Urz0Do6B23/KSPHqt2FX+Q==
//        String key = new Md5Hash("212334344gfdwrwerwerwerwerwerwe111111111**^&&*&**").toBase64();
//        System.out.println(key);



//        AesCipherService aesCipherService = new AesCipherService();
//        aesCipherService.setKeySize(128); //设置key长度
//
//        Key key = aesCipherService.generateNewKey();
//        String text = "123456&qwertyuqqq"+"&"+System.currentTimeMillis();
//        //加密
//        String encrptText = aesCipherService.encrypt(text.getBytes(), key.getEncoded()).toHex();
//
//        System.out.println(encrptText);
//
//        String encrptText22 = new Md5Hash(encrptText).toBase64();
//        System.out.println(encrptText22);
//
//        // 解密
//        String text2 = new String(aesCipherService.decrypt(Hex.decode(encrptText), key.getEncoded()).getBytes());
//
//        System.out.println(text2);

        //Assert.assertEquals(text, text2);

        //在服务器端生成客户端参数消息摘要
        //String serverDigest = EncryptUtils.getStatelessDigest(key, uri);
        //return serverDigest;







    }


}
