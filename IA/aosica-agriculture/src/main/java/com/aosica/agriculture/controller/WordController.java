package com.aosica.agriculture.controller;

import com.aosica.agriculture.api.WordServiceApi;
import com.aosica.agriculture.vo.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: ai-planting->WordController
 * @description: 获取文档控制器
 * @author: dwj
 * @create: 2019-09-10 20:27
 **/
//@Controller
public class WordController {

    @Autowired
    private WordServiceApi tableServiceApi;

    @RequestMapping("/getWord")
    public String toWord(Model model) {
        List<Table> tables = tableServiceApi.tableList();
        model.addAttribute("tables", tables);
        return "word";
    }
}
