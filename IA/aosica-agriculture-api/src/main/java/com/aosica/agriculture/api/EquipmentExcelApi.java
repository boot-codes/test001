package com.aosica.agriculture.api;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public interface EquipmentExcelApi {

    void export(HttpServletRequest request, HttpServletResponse response, Integer startIndex, Integer rowNum, String status, String name) throws IOException, Exception;

    void importExcel(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException, Exception;

    void downloadExcel(HttpServletResponse response) throws FileNotFoundException, UnsupportedEncodingException;
}
