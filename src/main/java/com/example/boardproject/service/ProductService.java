package com.example.boardproject.service;

import com.example.boardproject.dto.ProductDTO;
import com.example.boardproject.entity.Product;

public interface ProductService {
    //entity -> dto
    default ProductDTO entityToDto(Product product) {
        ProductDTO dto = ProductDTO.builder()
                .pId(product.getPId())
                .pName(product.getPName())
                .pImageFiles(product.getPImageFiles())
                .build();

        return dto;
    }
}
