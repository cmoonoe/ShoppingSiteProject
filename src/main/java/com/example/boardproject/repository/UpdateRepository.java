package com.example.boardproject.repository;

import com.example.boardproject.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UpdateRepository extends JpaRepository<Board, Integer> {

    @Transactional
    @Modifying
    @Query("delete from Comment c where c.board.bId =:bId")
    int deleteByCommentId(@Param("bId") int bId);
}
