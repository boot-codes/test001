package com.aosica.common.util;

import com.aosica.common.config.IdWorker;
import com.aosica.common.exception.AosicaException;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: ai-planting->UploadFileUtil
 * @description: 文件上传
 * @author: dwj
 * @create: 2019-08-29 10:01
 **/
public class UploadFileUtil {

     private static Logger logger = LoggerFactory.getLogger(UploadFileUtil.class);

     @Value("${file.upload_path}")
     private static String FILE_PATH;
    /** 文件路径分隔符 **/
    private static final String FILE_SEPARATOR = "/";


    /**
     * @description 删除已有文件
     * @param paths
     */
    private static void deleteFile(List<String> paths) {
        for(String path : paths){
            String thumbPath = getThumbPath(path);
            String abstractPath = FILE_PATH + FILE_SEPARATOR + path;
            String abstractThumbPath = FILE_PATH + FILE_SEPARATOR + thumbPath;
            File file = new File(abstractPath);
            File tfile = new File(abstractThumbPath);
            if (file.exists()) {
                file.delete();
                tfile.delete();
            }
        }
    }

    /**
     * @description 得到缩略图相对路劲
     * @param path
     * @return
     */
    private static String getThumbPath(String path) {
        // 文件后缀名
        String suffix = path.substring(path.lastIndexOf("."));
        // 文件路径，不包含后缀名
        String filePath = path.substring(0, path.lastIndexOf("."));
        // 缩微图路径
        return filePath + "_100x100" + suffix;
    }
    /**
     * @description 多文件上传
     * @param multipartFiles
     * @param multipartFiles
     * @param saveDbPath
     * @return List<Map<String,Object>>
     */
    public static List<Map<String,Object>> uploadFile(List<String> paths, MultipartFile[] multipartFiles, String saveDbPath) throws AosicaException {
        if (!CollectionUtils.isEmpty(paths)) {
            deleteFile(paths);
        }
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        // 文件存储的绝对路径
        String filePath = FILE_PATH + saveDbPath;
        logger.info("文件存储的绝对路径：{}", filePath);

        if (multipartFiles.length <= 0) {
            logger.info("上传的文件为空");
            return list;
        }
        try {
            for(MultipartFile multipartFile : multipartFiles){
                Map<String,Object> map = new HashMap<String, Object>();
                String originalFilename = multipartFile.getOriginalFilename();
                String fileSize = (float) multipartFile.getSize() / 1024 + "kb";
                String suffix = "";
                if (originalFilename.lastIndexOf(".") != -1) {
                    suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
                }
                File file = new File(filePath);
                if (!file.exists() && !file.isDirectory()) {
                    file.mkdirs();
                }
                // 对上传的文件进行重新命名
                String uuid = String.valueOf(IdWorker.generateId());
                String fileName = uuid + suffix;
                String srcfilePath = filePath + FILE_SEPARATOR + fileName;
                logger.info("文件路径及名称：{}", srcfilePath);
                file = new File(srcfilePath);
                multipartFile.transferTo(file);
                // 如果是图片，则压缩图片，否则不执行压缩操作
                if (ImageCheckUtils.isImage(file)) {
                    // 图片压缩后的文件名称
                    String compress_fileName = uuid + "_100x100" + suffix;
                    String compress_filePath = filePath + FILE_SEPARATOR + compress_fileName;
                    logger.info("压缩后的图片路径及名称：{}", compress_filePath);
                    ImageCompressUtils.reduceImg(srcfilePath, compress_filePath, 1100, 900, null);
                }
                logger.info("文件名：{}", originalFilename);
                map.put("id", IdWorker.generateId());
                map.put("name",originalFilename);// 文件名
                map.put("size",fileSize);// 文件大小
                map.put("path",saveDbPath + FILE_SEPARATOR + fileName); // 文件在数据库的保存路径
                map.put("type",suffix);// 文件类型
                list.add(map);
            }
        } catch (Exception e) {
            logger.error("上传文件出现异常", e);
            throw new AosicaException("上传文件出现异常");
        }
        return list;
    }


    /**
     * @description 文件下载
     * @param list
     * @param type
     * @return
     */
    public static List<byte[]> download(List<Map<String,String>> list,Integer type) throws AosicaException {
        List<byte[]> bytes = new ArrayList<byte[]>();
        try {
            for(Map<String,String> map : list){
                byte[] readBytes = null;
                String name = map.get("name");
                String filePath = map.get("path");
                String fileName = new String(name.getBytes("UTF-8"), "iso8859-1");
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                httpHeaders.setContentDispositionFormData("attachment", "filename=" + fileName);
                if (type == 2) {
                    // 缩微图路径
                    filePath = getThumbPath(filePath);
                }
                filePath = FILE_PATH + filePath;
                logger.info("文件绝对路径:{}", filePath);
                File file = new File(filePath);
                readBytes = FileCopyUtils.copyToByteArray(file);
                bytes.add(readBytes);
            }
        } catch (IOException e) {
            throw new AosicaException("下载文件出现异常：" + e.getMessage(), e);
        }
        return bytes;
    }
}
