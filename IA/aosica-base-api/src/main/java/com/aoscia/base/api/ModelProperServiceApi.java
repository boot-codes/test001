package com.aoscia.base.api;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;


@RequestMapping("/ModelProper")
public interface ModelProperServiceApi {
    void increase(Map<String, Object> map) throws Exception;

    void update(Map<String, Object> map) throws Exception;

    List<Map<String, Object>> selectById(Long id);

    void deleteById(Long id);
}
