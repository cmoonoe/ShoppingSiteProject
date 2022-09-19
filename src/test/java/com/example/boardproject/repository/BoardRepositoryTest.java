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
@RequiredArgsConstructor
class BoardRepositoryTest {
    
    private final BoardRepository boardRepository;

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