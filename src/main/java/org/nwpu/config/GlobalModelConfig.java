package org.nwpu.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.*;

@ControllerAdvice // 这个注解表示这是一个全局控制器通知
public class GlobalModelConfig {

    /**
     * 使用 @ModelAttribute 注解的方法会在所有 @RequestMapping 方法执行前运行
     * 并将返回值自动放入 Model 中。
     */
    @ModelAttribute("menus")
    public List<Map<String, String>> addGlobalMenus() {
        List<Map<String, String>> menuList = new ArrayList<>();

        Map<String, String> m1 = new HashMap<>();
        m1.put("name", "案例列表");
        m1.put("url", "/cases/list");

        Map<String, String> m2 = new HashMap<>();
        m2.put("name", "新增案例");
        m2.put("url", "/cases/add");

        menuList.add(m1);
        menuList.add(m2);

        // 返回的对象会被自动添加为 model.addAttribute("menus", menuList)
        return menuList;
    }
}