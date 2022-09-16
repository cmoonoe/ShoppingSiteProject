package com.example.boardproject.repository;

import com.example.boardproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query(value = "select c from Comment c where c.board.bId= :bid")
    List<Comment> showCommentList(@Param("bid") int bid);

    @Modifying
    @Transactional
    @Query(value = "insert into Comment(c_content,c_writer,c_pw,b_id) values(?1,?2,?3,?4)", nativeQuery = true)
    int uploadComment(@Param("cContent") String cContent, @Param("cWriter") String cWriter, @Param("cPw") String cPw, @Param("bId") int bId);
}
