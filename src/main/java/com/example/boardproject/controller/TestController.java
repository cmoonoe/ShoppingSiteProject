package com.example.boardproject.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class TestController {

    @RequestMapping("/main")
    public void test(){
        log.info("mainPage");
    }

    @RequestMapping("/reply")
    public String reply(){
        return "/commentPage";
    }
}
