package com.example.boardproject.repository;

import com.example.boardproject.entity.Board;
import com.example.boardproject.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;


@SpringBootTest
class BoardRepositoryTest {

    private BoardRepository boardRepository;

    @Autowired
    public BoardRepositoryTest(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Test
    public void insertBoard(){
        IntStream.rangeClosed(1,100).forEach(i->{

            Product product = Product.builder()
                    .pId(1)
                    .build();


            Board board = Board.builder()
                    .bTitle("bTitle " + i)
                    .bWriter("bWriter " + i)
                    .bContent("bContent " + i)
                    .bImage("bImage " + i)
                    .bPw("bPW " + i)
                    .pId(product)
                    .build();

            System.out.println(boardRepository.save(board));

        });
    }
}