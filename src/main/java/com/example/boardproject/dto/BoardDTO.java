package com.example.boardproject.dto;

/**
 * created : OH
 * last update : 2022.09.16
 */

import com.example.boardproject.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardDTO {
        private String bTitle;
        private String bWriter;
        private String bContent;
        private List<MultipartFile> pImageFiles;
        private String bPw;
        private Product pId;
}
