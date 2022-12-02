package com.example.boardproject.controller;

import com.example.boardproject.dto.MemberDTO;
import com.example.boardproject.entity.Member;
import com.example.boardproject.service.MemberService;
import com.example.boardproject.validate.CheckLoginValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;
    private final CheckLoginValidator checkLoginValidator;

    @InitBinder
    public void validatorBinder(WebDataBinder binder) {
        binder.addValidators(checkLoginValidator);
    }

    @GetMapping("/new")
    public String signForm(@ModelAttribute("memberDTO") MemberDTO memberDTO) {
        return "signup";
    }

    @PostMapping("/new")
    public String signup(@Valid @ModelAttribute(name = "memberDTO") MemberDTO memberDTO, Errors errors, Model model) {

        if (memberService.validateDuplicateLoginId(memberDTO)) {
            model.addAttribute("checkLoginId",memberService.validateDuplicateLoginId(memberDTO));
            return "alert";
        }

        Member member = new Member(memberDTO.getLoginId(), memberDTO.getPassword());
        memberService.register(member);

        return "redirect:/";
    }

}
