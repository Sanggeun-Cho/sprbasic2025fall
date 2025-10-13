package com.thc.sprbasic2025fall.service;

import com.thc.sprbasic2025fall.dto.defaultDto;
import com.thc.sprbasic2025fall.dto.BoardDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface BoardService {
    // create
    defaultDto.CreateResDto create(BoardDto.CreateReqDto param);

    // update
    void update(BoardDto.UpdateReqDto param);

    // delete
    void delete(BoardDto.UpdateReqDto id);

    // detail
    BoardDto.DetailResDto detail(defaultDto.DetailReqDto param);

    // list
    List<BoardDto.DetailResDto> list(BoardDto.ListReqDto param);
}
