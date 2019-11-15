package com.aosica.openapi.api.exception;



/**
 *  自定义异常类
 * @program: AosicaException
 * @description: 异常类
 * @author: dwj
 * @create: 2019-08-22 14:05
 **/
public class AosicaException extends Exception{

    private static final long serialVersionUID = 1L;

    public AosicaException(){
        super();
    }

    public AosicaException(String message){
        super(message);
    }

    public AosicaException(String message, Throwable cause){
        super(message,cause);
    }

}
