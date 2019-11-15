package com.aosica.openapi.api.exception;

/**
 * @PackgeName com.aosica.common.exception
 * @ClassName AosicaServiceSaveException.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/20 17:33
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/20$ 17:33$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public class AosicaServiceDeleteException extends AosicaException {

    public AosicaServiceDeleteException(){
        super();
    }

    public AosicaServiceDeleteException(String message){
        super(message);
    }

    public AosicaServiceDeleteException(String message, Throwable cause){
        super(message,cause);
    }

}
