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

        java.util.Map<String, String> testCase = new java.util.HashMap<>();
        testCase.put("name", "快速排序算法实验");
        testCase.put("type", "基础算法");
        testCase.put("content", "这是一个演示实验...");
        testCase.put("code", "public static void main...");

        model.addAttribute("case", testCase);

        return "detail";
    }
}