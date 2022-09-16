package com.example.boardproject.controller;


import com.example.boardproject.mybatis.IBoardDao;
import com.example.boardproject.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class ListController {

    @Autowired
    IBoardDao iBoardDao;

    private BoardService boardService;

    @Autowired
    public ListController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list2")
    public String list(Model model){
        log.info("------------------- list --------------------");
        model.addAttribute("lists", iBoardDao.list());

        return "list";
    }

}
