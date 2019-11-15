package com.aosica.agriculture.mapper;

import com.aosica.agriculture.dto.LogDto;
import org.springframework.stereotype.Repository;

@Repository
public interface LogMapper {

    void save(LogDto logDto);

}
