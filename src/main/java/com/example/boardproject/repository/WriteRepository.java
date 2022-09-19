package com.example.boardproject.repository;

import com.example.boardproject.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface WriteRepository extends JpaRepository<Board, Integer> {
}
