package com.aosica.agriculture.api;

import com.aosica.agriculture.dto.LogDto;
import com.aosica.agriculture.mapper.LogMapper;
import com.aosica.common.exception.AosicaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: ai-planting->LogService
 * @description: 日志实现类
 * @author: dwj
 * @create: 2019-08-30 11:11
 **/
@Service
public class LogService implements LogServiceApi{

    @Autowired
    private LogMapper logMapper;

    @Override
    public void save(LogDto logDto) {
        try{
            logMapper.save(logDto);
        }catch (Exception e){
            throw new AosicaException("新增日志异常"+e.getMessage(),e);
        }
    }
}
