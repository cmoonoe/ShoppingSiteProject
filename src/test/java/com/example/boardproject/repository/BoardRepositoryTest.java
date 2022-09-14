package com.example.boardproject.repository;

import com.example.boardproject.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertBoard(){
        IntStream.rangeClosed(1,2).forEach(i->{
            Board board = Board.builder().bTitle("boardTest..." + i).bContent("boardContent... " + i).bWriter("boardTester " + i).bPw("test"+i).build();
            System.out.println(boardRepository.save(board));
        });
    }

}