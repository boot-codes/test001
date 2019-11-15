package com.aosica.common.util;

import com.aosica.common.exception.AosicaException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @program: ai-planting->ImageCheckUtils
 * @description: 是否是图片工具类
 * @author: dwj
 * @create: 2019-08-29 10:20
 **/
public class ImageCheckUtils {

    public static boolean isImage(File file) throws AosicaException {
        boolean flag = false;
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(file);
            if(bufferedImage == null) {
                flag = false;
            } else {
                flag = true;
            }
        } catch (Exception e) {
            throw new AosicaException("检查文件是否是图片出现异常：" + e.getMessage(),e);
        }
        return flag;
    }

    public static void main(String[] args) throws AosicaException {
        File file = new File("E:\\2");
        File file2 = new File("E:\\2.png");
        File file1 = new File("E:\\恒信国通OA需求.docx");
        boolean flag = ImageCheckUtils.isImage(file);
        boolean flag1 = ImageCheckUtils.isImage(file1);
        boolean flag2 = ImageCheckUtils.isImage(file2);
        System.out.println(flag);
        System.out.println(flag1);
        System.out.println(flag2);
    }
}
