package com.example.boardproject.controller;
/**
 * created : OH
 * last update : 2022.09.16
 */

import com.example.boardproject.domain.UploadFile;
import com.example.boardproject.dto.BoardDTO;
import com.example.boardproject.entity.Board;
import com.example.boardproject.repository.WriteRepository;
import com.example.boardproject.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class WriteController {

    private final WriteRepository writeRepository;
    private final FileService fileService;

    @GetMapping("/write")
    public String writeForm() {
        return "write";
    }

    //    @PostMapping("/write")
    public String write(@ModelAttribute Board board) {
        writeRepository.save(board);
        return "redirect:/";
    }

    @PostMapping("/write")
    public String saveBoard(@ModelAttribute BoardDTO boardDTO, RedirectAttributes
            redirectAttributes) throws IOException {

        List<UploadFile> storeImageFiles =
                fileService.storeFiles(boardDTO.getPImageFiles());

        Board board = new Board(boardDTO.getBTitle(),
                boardDTO.getBWriter(),
                boardDTO.getBContent(),
                storeImageFiles,
                boardDTO.getBPw(),
                boardDTO.getPId());

        writeRepository.save(board);
//
//        redirectAttributes.addAttribute("bId", board.getBId());
        redirectAttributes.addFlashAttribute("bId", board.getBId());

        return "redirect:/";
    }
}

