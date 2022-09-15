package com.example.boardproject.dto;

import com.example.shopping.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardDTO {
        private Long bId;
        private String bTitle;
        private String bWriter;
        private LocalDateTime bDate;
        private String bContent;
        private String bImage;
        private String bPw;
        private Product product;
}
