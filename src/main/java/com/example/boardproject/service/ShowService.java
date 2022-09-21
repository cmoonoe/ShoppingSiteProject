package com.example.boardproject.service;

import com.example.boardproject.dto.BoardDTO;
import com.example.boardproject.dto.ProductDTO;

import java.util.Optional;

public interface ShowService {
    public BoardDTO getByBId(int bId, int pId);
    public ProductDTO getByPId(int pId);
}
