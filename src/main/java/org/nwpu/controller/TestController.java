package org.nwpu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @GetMapping("/test")
    public String testPage(Model model) {
        // 模拟从数据库或配置中读取的菜单列表
        List<Map<String, String>> menuList = new ArrayList<>();

        Map<String, String> m1 = new HashMap<>();
        m1.put("name", "案例列表");
        m1.put("url", "/cases/list");

        Map<String, String> m2 = new HashMap<>();
        m2.put("name", "新增案例");
        m2.put("url", "/cases/add");

        menuList.add(m1);
        menuList.add(m2);

        model.addAttribute("menus", menuList); // 传给前端

        java.util.Map<String, String> testCase = new java.util.HashMap<>();
        testCase.put("name", "快速排序算法实验");
        testCase.put("type", "基础算法");
        testCase.put("content", "这是一个演示实验...");
        testCase.put("code", "public static void main...");

        model.addAttribute("case", testCase);

        return "detail";
    }
}