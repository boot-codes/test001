package com.aosica.openapi.api.exception;



/**
 *  自定义异常类
 * @program: AosicaException
 * @description: 异常类
 * @author: dwj
 * @create: 2019-08-22 14:05
 **/
public class AosicaGeneralException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public AosicaGeneralException(){
        super();
    }

    public AosicaGeneralException(String message){
        super(message);
    }

    public AosicaGeneralException(String message, Throwable cause){
        super(message,cause);
    }

}
