package com.example.leaf.controller;

import com.example.leaf.model.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller // Spring, SpringBoot Scan. + Controller (DispatcherServlet)
// @~Mapping - 주소, 호출
@RequestMapping("/members")
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

    private static final List<Member> memberRepository = new CopyOnWriteArrayList<>();

    static {
//        memberRepository.add(new Member("u1", "김자바"));
//        memberRepository.add(new Member("u2", "박자바"));
    }

    @GetMapping // /members
    public String list(Model model) {
        model.addAttribute("members", memberRepository);
        return "member/list";
    }

    @GetMapping("/add") // /members/add
    public String addForm(Model model) {
        // 빈 멤버 객체를 하나 넣는다
        model.addAttribute("member", new Member());
        return "member/addForm";
    }

    @PostMapping("/add") // /members/add
    public String addForm(@ModelAttribute Member member) {
        memberRepository.add(member);
        return "redirect:/members"; // PRG
    }
}
