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

    //entity -> dto
    public static ProductDTO entityToDto(Product product) {
        ProductDTO dto = ProductDTO.builder()
                .pId(product.getPId())
                .pName(product.getPName())
                .pImageFiles(product.getPImageFiles())
                .build();

        return dto;
    }

}
