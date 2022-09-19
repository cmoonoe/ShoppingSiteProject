package com.example.boardproject.repository.mybatis;

import com.example.boardproject.entity.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IBoardDao {

    @Select("select bId, bTitle, bWriter, bDate from Board")
    List<Board> list();

}
