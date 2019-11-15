package com.aoscia.base.service.impl;

import com.aoscia.base.api.FileServiceApi;
import com.aoscia.base.dto.FileDto;
import com.aoscia.base.entity.FileEntity;
import com.aoscia.base.mapper.FileMapper;
import com.aoscia.base.service.FileService;
import com.aosica.common.bean.RequestResult;
import com.aosica.common.exception.AosicaException;
import com.aosica.common.util.UploadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @program: aosica-base->fileServiceImpl
 * @description: 文件服务实现类
 * @author: dwj
 * @create: 2019-09-16 14:55
 **/
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    /**
     * @param fileDto
     * @description 上传文件
     */
    @Override
    public RequestResult uploadFiles(FileDto fileDto) {
        try {
            //获取已有的文件
            List<String> paths = fileMapper.selectPathByBillId(fileDto.getBillId());
            //调用上传文件工具类进行上传文件
            List<Map<String, Object>> list = UploadFileUtil.uploadFile(paths, fileDto.getFiles(), fileDto.getSaveDbPath());
            //新增到文件表中
            this.save(list, fileDto.getBillId());
        }catch (Exception e){
            throw new AosicaException("新增文件信息异常" + e.getMessage(), e);
        }
        return RequestResult.buildOK();
    }

    /**
     * @param billId
     * @param type
     * @return
     * @description 下载文件
     */
    @Override
    public RequestResult downloadFiles(long billId, int type) {
        List<byte[]> bytes = new ArrayList<byte[]>();
        try{
            List<Map<String, String>> list = new ArrayList<Map<String, String>>();
            List<FileEntity> fileEntities = fileMapper.listFileByBillId(billId);
            if (CollectionUtils.isEmpty(fileEntities)) {
                throw new AosicaException("通过业务ID：" + billId + ",没有查询到文件信息");
            }
            for (FileEntity fileEntity : fileEntities) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("name", fileEntity.getName());
                map.put("path", fileEntity.getPath());
                list.add(map);
            }
            //下载文件
            bytes = UploadFileUtil.download(list, type);
        }catch (Exception e){
            throw new AosicaException("下载文件异常"+e.getMessage());
        }
        return RequestResult.buildOkData(bytes);
    }


    /**
     * @param list
     * @param biiiId
     * @description 文件信息新增
     */
    private void save(List<Map<String, Object>> list, long biiiId) {
        List<FileEntity> fileEntityList = new ArrayList<FileEntity>();
            for (Map<String, Object> map : list) {
                FileEntity dto = new FileEntity();
                dto.setId((long) map.get("id"));
                dto.setName((String) map.get("name"));
                dto.setPath((String) map.get("path"));
                dto.setBillId(biiiId);
                dto.setType((String) map.get("type"));
                dto.setSize((String) map.get("size"));
                dto.setCreateTime(new Date());
                fileEntityList.add(dto);
            }
            //批量添加到文件表
            fileMapper.batchSave(fileEntityList);
    }

}
