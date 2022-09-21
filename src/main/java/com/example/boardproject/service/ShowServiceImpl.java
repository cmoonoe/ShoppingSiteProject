package com.example.boardproject.service;

import com.example.boardproject.dto.BoardDTO;
import com.example.boardproject.dto.ProductDTO;
import com.example.boardproject.entity.Product;
import com.example.boardproject.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowServiceImpl implements ShowService{

    private final ShowRepository showRepository;
    private final BoardService boardService;
    private final ProductService productService;

    @Autowired
    public ShowServiceImpl(ShowRepository showRepository, BoardService boardService, ProductService productService) {
        this.showRepository = showRepository;
        this.boardService = boardService;
        this.productService = productService;
    }

    /* bid로 board 찾기 */
    @Override
    public BoardDTO getByBId(int bId, int pId) {

        BoardDTO boardDTO = boardService.entityToDto(showRepository.findByBId(bId).get());
        ProductDTO productDTO = productService.entityToDto(showRepository.findByPId(pId).get());

        boardDTO = getReviewImage(boardDTO, pId);
        boardDTO = getAsteriskWriter (boardDTO);

        return boardDTO;
    }

    @Override
    public ProductDTO getByPId(int pId) {
        ProductDTO productDTO = productService.entityToDto(showRepository.findByPId(pId).get());

        return productDTO;
    }

    /* 리뷰 사진이 없으면 상품 사진으로 대체 */
    private BoardDTO getReviewImage (BoardDTO boardDTO, int pId) {
        if (boardDTO.getPImageFiles() == null) {
            boardDTO.setPImageFiles(getByPId(pId).getPImageFiles());
            return boardDTO;
        } else {
            return boardDTO;
        }
    }

    /* 상세 리뷰 보기에서 작성자 이름 일부만 표시하기 */
    private BoardDTO getAsteriskWriter (BoardDTO boardDTO) {
        String bWriter = boardDTO.getBWriter();

        String AsteriskWriter = null;

        if (bWriter.length() < 4) {
            AsteriskWriter = bWriter.substring(0, bWriter.length()-1) + "*";
        } else if (bWriter.length() < 10) {
            AsteriskWriter = bWriter.substring(0, bWriter.length()-3) + "***";
        } else {
            AsteriskWriter = bWriter.substring(0, bWriter.length()-5) + "*****";
        }

        boardDTO.setBWriter(AsteriskWriter);

        return boardDTO;
    }
}


