package com.example.boardproject.controller;

import com.example.boardproject.domain.UploadFile;
import com.example.boardproject.mybatis.BoardDAO;
import com.example.boardproject.repository.UpdateRepository;
import com.example.boardproject.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/board")
public class UpdateController {

    @Autowired
    BoardDAO boardDAO;
    @Autowired
    FileService fileService;
    @Autowired
    UpdateRepository updateRepository;

    @RequestMapping("/update/{id}") //수정 화면
    public String boardUpdateForm(@PathVariable("id") int bId, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        System.out.println("==============================");
        System.out.println(session.getAttribute("loginID"));
        System.out.println(bId);
        System.out.println(boardDAO.checkWriter(bId));
        if(session.getAttribute("loginID").equals(boardDAO.checkWriter(bId))){
            model.addAttribute("idid", boardDAO.updateSelect(bId));
            model.addAttribute("imageName",boardDAO.selectImage(bId));
            return "updateBoard";
        }
        model.addAttribute("bId", bId);
        return "notSameAlert";
    }

    @PostMapping("/boardUpdate/{id}") //수정 DB 반영
    public String boardUpdate(@Param("title") String title, @Param("content") String content, @RequestParam("pImageFiles") MultipartFile image, @PathVariable("id") int bId) throws IOException {
        if(!image.isEmpty()){
            UploadFile uploadFile = fileService.storeFile(image);
            boardDAO.deleteImage(bId);
            boardDAO.update(title, content, bId);
            boardDAO.insertImage(bId,uploadFile.getStoreFileName(),uploadFile.getUploadFileName());
        }else{
            boardDAO.update(title, content, bId);
        }

        return "redirect:/";
    }

    @RequestMapping("/boardDelete/{id}") // 삭제 DB 반영
    public String boardDelete(@PathVariable("id") int bId, HttpServletRequest request, Model model) {
        HttpSession session= request.getSession();

        if(session.getAttribute("loginID").equals(boardDAO.checkWriter(bId))){
            updateRepository.deleteByCommentId(bId);
            updateRepository.deleteById(bId);
            return "redirect:/";
        }
        model.addAttribute("bId", bId);
        return "notSameAlert";
    }
}
