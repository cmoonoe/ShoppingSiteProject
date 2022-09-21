package com.example.boardproject.dto;

import com.example.boardproject.domain.UploadFile;
import com.example.boardproject.entity.Product;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private int pId;
    private String pName;
    private List<UploadFile> pImageFiles;

}
