package com.example.boardproject.mybatis;

import com.example.boardproject.dto.BoardDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MybatisTest {

    @Autowired
    IBoardDao iBoardDao;

    @Test
    public void test(){
        List<BoardDTO> list = iBoardDao.list();

        for(BoardDTO boardDTO : list){
            System.out.println(boardDTO);
        }
    }

}
