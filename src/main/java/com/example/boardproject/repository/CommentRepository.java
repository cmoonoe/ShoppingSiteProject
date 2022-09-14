package com.example.boardproject.repository;

import com.example.boardproject.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
