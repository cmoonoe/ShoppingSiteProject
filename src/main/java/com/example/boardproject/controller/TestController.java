package com.example.boardproject.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class TestController {

//    @RequestMapping("/main")
//    public void test(){
//        log.info("mainPage");
//    }

@GetMapping("/reply")
    public String test1(){
    log.info("dd");
    return "main";
}

}
