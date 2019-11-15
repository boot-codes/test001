package com.aosica.message.sms.mapper;

import com.aosica.message.sms.entity.MessageEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageMapper {

    /**
     * @desc 新增消息记录
     * @param messageEntity
     */
    void save(MessageEntity messageEntity);
}
