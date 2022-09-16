package com.example.boardproject.mybatis;

import com.example.boardproject.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IBoardDao {

    @Select("select bId, bTitle, bWriter, bDate from board")
    List<BoardDTO> list();

}
