package com.example.boardproject.service;

import com.example.boardproject.dto.BoardDTO;
import com.example.boardproject.dto.BoardWriteDTO;
import com.example.boardproject.dto.PageRequestDTO;
import com.example.boardproject.dto.PageResultDTO;
import com.example.boardproject.entity.Board;
import com.example.boardproject.repository.BoardRepository;
import com.example.boardproject.repository.SearchRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Log4j2
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final SearchRepository searchRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository, SearchRepository searchRepository) {
        this.boardRepository = boardRepository;
        this.searchRepository = searchRepository;
    }

    public PageResultDTO<BoardDTO, Board> getList(Long pId, PageRequestDTO pageRequestDTO) {
        PageRequest pageRequest = pageRequestDTO.getPageable(Sort.by("bId").descending());

        Page<Board> result = searchRepository.findByPId(pId,pageRequest);

        Function<Board, BoardDTO> fn = (entity -> entityToDto(entity));

        return new PageResultDTO<>(result,fn);
    }
}
