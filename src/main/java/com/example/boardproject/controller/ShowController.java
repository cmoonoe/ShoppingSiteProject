package com.example.boardproject.controller;

import com.example.boardproject.dto.BoardDTO;
import com.example.boardproject.dto.ProductDTO;
import com.example.boardproject.service.ShowService;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
public class ShowController {

    private final ShowService service;
    @Autowired
    ShowController(ShowService service){this.service = service;}

    /* 제품 상세 리뷰 보기 */
    @GetMapping("/showboard")
    public String showBoard(@RequestParam("bid") int bId,@RequestParam("pid") int pId, Model model){

        BoardDTO board = service.getByBId(bId, pId);
        ProductDTO product = service.getByPId(pId);

        model.addAttribute("board", board);
        model.addAttribute("product", product);

        log.info("------------------- show --------------------");
        return "showBoard";
    }

}
