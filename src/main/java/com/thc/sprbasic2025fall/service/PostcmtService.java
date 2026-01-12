package com.thc.sprbasic2025fall.service;

import com.thc.sprbasic2025fall.dto.defaultDto;
import com.thc.sprbasic2025fall.dto.PostcmtDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostcmtService {
    defaultDto.CreateResDto create(PostcmtDto.CreateReqDto param);
    void update(PostcmtDto.UpdateReqDto param);
    void delete(PostcmtDto.UpdateReqDto param);
    PostcmtDto.DetailResDto detail(defaultDto.DetailReqDto param);
    List<PostcmtDto.DetailResDto> list(PostcmtDto.ListReqDto param);
    defaultDto.PagedListResDto pagedList(PostcmtDto.PagedListReqDto param);
    List<PostcmtDto.DetailResDto> scrollList(PostcmtDto.ScrollListReqDto param);
}