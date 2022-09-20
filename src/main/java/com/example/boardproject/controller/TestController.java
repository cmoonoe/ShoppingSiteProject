package com.example.boardproject.controller;

import com.example.boardproject.domain.UploadFile;
import com.example.boardproject.dto.BoardWriteDTO;
import com.example.boardproject.dto.TestDTO;
import com.example.boardproject.entity.Board;
import com.example.boardproject.entity.Product;
import com.example.boardproject.repository.ProductRepository;
import com.example.boardproject.repository.WriteRepository;
import com.example.boardproject.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@Log4j2
@RequiredArgsConstructor
public class TestController {

    private final ProductRepository productRepository;

//    private final WriteRepository writeRepository;

    private final FileService fileService;

    @RequestMapping("/main")
    public void test(){
        log.info("mainPage");
    }


    //product 테이블에 이미지 넣는 로직
    @PostMapping("/test")
    public String saveBoard(@ModelAttribute TestDTO testDTO,
                            RedirectAttributes redirectAttributes) throws IOException {


        List<UploadFile> storeImageFiles =
                fileService.storeFiles(testDTO.getPImageFiles());

        Product product = new Product(
                testDTO.getPName(),
                storeImageFiles
        );


        productRepository.save(product);


        return "redirect:/";
    }

    //이미지 넣기 위한 폼으로 넘어가기 위한 url 설정
    @GetMapping("/testup")
    String ss() {
        return "test";
    }

}
