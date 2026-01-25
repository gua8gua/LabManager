package org.nwpu.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cases")
public class CasesController {

    // 模拟数据库数据
    private static List<Map<String, Object>> mockCases = new ArrayList<>();

    static {
        Map<String, Object> case1 = new HashMap<>();
        case1.put("id", 101);
        case1.put("name", "卷积神经网络图像识别");
        case1.put("type", "深度学习");
        case1.put("date", "2026-01-20");

        Map<String, Object> case2 = new HashMap<>();
        case2.put("id", 102);
        case2.put("name", "基于 Spring Boot 的权限管理");
        case2.put("type", "Web开发");
        case2.put("date", "2026-01-22");

        mockCases.add(case1);
        mockCases.add(case2);
    }

    // 1. 列表页面
    @GetMapping("/list")
    public String listCases(Model model) {
        model.addAttribute("caseList", mockCases);
        return "cases/case-list"; // 对应 templates/cases/case-list.html
    }

    // 2. 新增页面
    @GetMapping("/add")
    public String addCasePage() {
        return "cases/case-add"; // 对应 templates/cases/case-add.html
    }

    @GetMapping("/detail/{id}")
    public String caseDetail(@PathVariable("id") Integer id, Model model) {
        // 在实际开发中，这里应该是 caseService.findById(id)
        // 现在我们先模拟根据 ID 找数据的逻辑
        Map<String, Object> targetCase = null;
        for (Map<String, Object> c : mockCases) {
            if (c.get("id").equals(id)) {
                targetCase = c;
                break;
            }
        }

        if (targetCase == null) {
            return "redirect:/coming-soon"; // 如果没找到，跳转到你之前的提示页
        }

        model.addAttribute("case", targetCase);
        return "cases/case-detail"; // 指向 templates/cases/case-detail.html
    }
}