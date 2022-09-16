package com.example.boardproject.service;

import com.example.boardproject.dto.BoardDTO;
import com.example.boardproject.dto.ProductDTO;
import com.example.boardproject.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowServiceImpl implements ShowService{

    private final ShowRepository showRepository;
    private final BoardService boardService;

    @Autowired
    public ShowServiceImpl(ShowRepository showRepository, BoardService boardService) {
        this.showRepository = showRepository;
        this.boardService = boardService;
    }

    @Override
    public BoardDTO getByBId(int bId, int pId) {

        BoardDTO boardDTO = boardService.entityToDto(showRepository.findByBId(bId).get());
        ProductDTO productDTO = ProductDTO.entityToDto(showRepository.findByPId(pId).get());

        /* 리뷰 사진이 없으면 상품 사진으로 대체 */
        if (boardDTO.getBImage() == null) {
            boardDTO.setBImage(productDTO.getPImage());
            return boardDTO;
        } else {
            return boardDTO;
        }
    }

    @Override
    public ProductDTO getByPId(int pid) {
        return ProductDTO.entityToDto(showRepository.findByPId(pid).get());
    }
}


