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

    /* bid, pid로 board 찾기 */
    @Override
    public BoardDTO getByBId(int bId, int pId) {

        BoardDTO boardDTO = boardService.entityToDto(showRepository.findByBId(bId).get());
        ProductDTO productDTO = ProductDTO.entityToDto(showRepository.findByPId(pId).get());

        boardDTO = getReviewImage(boardDTO, productDTO);
        boardDTO = getAsteriskWriter (boardDTO);

        return boardDTO;
    }

    /* pid로 product 찾기 */
    @Override
    public ProductDTO getByPId(int pId) {
        return ProductDTO.entityToDto(showRepository.findByPId(pId).get());
    }

    /* 리뷰 사진이 없으면 상품 사진으로 대체 */
    private BoardDTO getReviewImage (BoardDTO boardDTO, ProductDTO productDTO) {

        if (boardDTO.getPImageFiles() == null) {
            //boardDTO.setPImageFiles(productDTO.getPImage());
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
            AsteriskWriter = bWriter.replace(bWriter.substring(bWriter.length()-1), "*");
        } else {
            AsteriskWriter = bWriter.replace(bWriter.substring(bWriter.length()-3), "***");
        }

        boardDTO.setBWriter(AsteriskWriter);

        return boardDTO;
    }
}


