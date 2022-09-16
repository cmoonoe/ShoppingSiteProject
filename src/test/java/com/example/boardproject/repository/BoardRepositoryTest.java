package com.example.boardproject.repository;

import com.example.boardproject.entity.Board;
import com.example.boardproject.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.LongStream;


@SpringBootTest
class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private ProductRepository productRepository;


    @Test
    public void insertBoard() {
        LongStream.rangeClosed(101, 200).forEach(i -> {

//            Optional<Product> byId = productRepository.findById(i);
//            Product product = byId.get();
            Product product1 = Product.builder().pId(101l).build();
            Board board = Board.builder()
                    .bContent("bContent " + i)
                    .bPw("bPW " + i)
                    .bTitle("bTitle " + i)
                    .bWriter("bWriter " + i)
                    .pId(product1)
                    .build();

            System.out.println(boardRepository.save(board));

        });
    }
}