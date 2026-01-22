package org.nwpu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test")
    public String testPage(Model model) {
        // 1. 创建一个简单的 Map 来模拟对象
        java.util.Map<String, String> testCase = new java.util.HashMap<>();
        testCase.put("name", "快速排序算法实验");
        testCase.put("type", "基础算法");
        testCase.put("content", "这是一个演示实验...");
        testCase.put("code", "public static void main...");

        // 2. 这里的 key 必须叫 "case"，因为你的 HTML 里用的是 ${case.xxx}
        model.addAttribute("case", testCase);

        return "detail";
    }
}