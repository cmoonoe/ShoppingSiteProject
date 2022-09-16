package com.example.boardproject.controller;

import com.example.boardproject.entity.Board;
import com.example.boardproject.entity.Product;
import com.example.boardproject.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class SearchController {

    @Autowired
    SearchRepository searchRepository;

    @GetMapping("/")
    String main(Model model) {
        //model.addAttribute("dto", searchRepository.searchList())
        model.addAttribute("productList", searchRepository.productList());
        return "main";
    }

//    @GetMapping("/product1")
//    String showContents(Model model){
//        model.addAttribute("allContents",searchRepository.searchList(1l));
//        return "allContents";
//    }
//
//    @GetMapping("/product2")
//    String showContents2(Model model) {
//        model.addAttribute("allContents", searchRepository.searchList(2l));
//        return "allContents";
//    }
//
//    @GetMapping("/product3")
//    String showContents3(Model model) {
//        model.addAttribute("allContents", searchRepository.searchList(3l));
//        return "allContents";
//    }

    @GetMapping("/product/{pId}")
    String showContents4(@PathVariable int pId, Model model) {
        //Optional<Board> result = searchRepository.findById(pId);
//        List<Board> result = searchRepository.searchList(pId);
//        System.out.println("result = " + result);
        model.addAttribute("allContents", searchRepository.searchList(pId));

//        model.addAttribute("allContents", searchRepository.findById(pId));
        return "list_tem";

    }


//    @GetMapping("/product")
//    String show(Model model) {
//        model.addAttribute("allContents",)
//    }
}
