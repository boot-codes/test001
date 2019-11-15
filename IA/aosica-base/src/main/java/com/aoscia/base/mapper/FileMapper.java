package com.aoscia.base.mapper;

import com.aoscia.base.entity.FileEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: aosica-base->FileMapper
 * @description: 文杰服务接口
 * @author: dwj
 * @create: 2019-09-26 15:18
 **/
@Repository
public interface FileMapper {

    /**
     * @description 新增文件
     * @param fileEntities
     */
    void batchSave(List<FileEntity> fileEntities);

    /**
     * @description 获取当前业务Id所有文件路径
     * @param billId
     * @return  List<String>
     */
    List<String> selectPathByBillId(long  billId);

    /**
     * @description 获取当前业务Id所有文件信息
     * @param billId
     * @return List<FileEntity>
     */
    List<FileEntity> listFileByBillId(long billId);
}
