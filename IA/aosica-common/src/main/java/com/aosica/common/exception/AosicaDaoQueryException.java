package com.aosica.common.exception;



/**
 *  自定义异常 ：查询数据异常
 * @PackgeName com.aosica.common.exception
 * @ClassName AosicaSaveException.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/11 16:06
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/11$ 16:06$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public class AosicaDaoQueryException extends AosicaException{


    public AosicaDaoQueryException() {
        super();
    }


    public AosicaDaoQueryException(String message) {
        super(message);
    }


    public AosicaDaoQueryException(String message, Throwable cause) {
        super(message, cause);
    }
}
