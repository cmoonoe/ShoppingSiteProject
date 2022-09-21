package com.example.boardproject.service;

import com.example.boardproject.dto.ProductDTO;
import com.example.boardproject.entity.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    default ProductDTO entityToDto(Product product) {

        ProductDTO productDTO = ProductDTO.builder()
                .pId(product.getPId())
                .pName(product.getPName())
                .pImageFiles(product.getPImageFiles())
                .build();

        return productDTO;
    }

}
