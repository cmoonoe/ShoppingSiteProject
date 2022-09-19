package com.example.boardproject.mybatis;

import com.example.boardproject.entity.Board;
import com.example.boardproject.repository.mybatis.IBoardDao;
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
        List<Board> list = iBoardDao.list();

        for(Board boardDTO : list){
            System.out.println(boardDTO);
        }
    }

}
