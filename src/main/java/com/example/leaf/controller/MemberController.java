package com.example.leaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Random;

@Controller // Spring, SpringBoot Scan. + Controller (DispatcherServlet)
// @~Mapping - 주소, 호출
public class MemberController {
    @GetMapping("/example")
    public String example(Model model) {
        Random random = new Random();
        List<String> members = List.of("김자바", "이SQL", "박DB");
        // 반반의 확률로 찬 리스트, 빈 리스트.
        model.addAttribute("memberList", random.nextBoolean() ? members : List.of());
        // 반반~ 매니저 모드, 일반 모드
        model.addAttribute("isManager", random.nextBoolean());
        model.addAttribute("totalCount", members.size());
        return "example"; // jsp -> WEB~~~~
        // thymeleaf -> resources/templates/... .html
    }
}
