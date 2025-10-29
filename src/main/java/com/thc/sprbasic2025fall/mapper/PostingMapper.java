package com.thc.sprbasic2025fall.mapper;

import com.thc.sprbasic2025fall.dto.postingDto;

import java.util.List;

public interface PostingMapper {
    postingDto.DetailResDto detail(Long id);
    List<postingDto.DetailResDto> list(postingDto.ListReqDto param);
    List<postingDto.DetailResDto> pagedList(postingDto.PagedListReqDto param);
    int listCount(postingDto.PagedListReqDto param);
}
