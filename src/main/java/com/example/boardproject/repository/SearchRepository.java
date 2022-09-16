package com.example.boardproject.repository;

import com.example.boardproject.entity.Board;
import com.example.boardproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SearchRepository extends JpaRepository<Board, Integer> {
//    @Query("select b from Board b where b.pId = :pId order by b.bId desc")

    @Query("select b from Board b where b.pId.pId = :pId")
    List<Board> searchList(@Param("pId") int pId);

//    List<Board> findById(int pId);

    @Query("select p from Product p ")
    List<Product> productList();
}
