package com.aoscia.base.mapper;

import com.aoscia.base.dto.LogDto;
import org.springframework.stereotype.Repository;

@Repository
public interface LogMapper {

    void save(LogDto logDto);
}
