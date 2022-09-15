package com.example.boardproject.repository;

import com.example.shopping.entity.Product;
import com.example.shopping.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
class ProductRepositoryTest {

    private ProductRepository productRepository;

    @Autowired
    public ProductRepositoryTest(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Test
    public void insertProduct(){
        IntStream.rangeClosed(1,100).forEach(i->{

            Product product = Product.builder()
                    .pName("pName " + i)
                    .pImage("pImage " + i)
                    .build();

            System.out.println(productRepository.save(product));
        });
    }
}