package org.nwpu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorPageController {

    @GetMapping("/coming-soon")
    public String comingSoon(Model model) {
        model.addAttribute("errorMsg", "该功能模块正在火速开发中...");
        return "error/404"; // 指向 templates/error/404.html
    }
}