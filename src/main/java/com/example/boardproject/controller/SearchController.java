package com.example.boardproject.controller;


import com.example.boardproject.repository.SearchRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class SearchController {
    private final SearchRepository searchRepository;
    @GetMapping("/")
    String main(Model model) {
        model.addAttribute("productList", searchRepository.productList());
        return "main";
    }


    @GetMapping("/product/{pId}")
    String showContents4(@PathVariable Long pId, Model model) {
        model.addAttribute("lists", searchRepository.searchList(pId));
        model.addAttribute("pId", pId);
        return "list";
    }
 

}
