package com.thc.sprbasic2025fall.service;

import com.thc.sprbasic2025fall.dto.PostimgDto;
import com.thc.sprbasic2025fall.dto.defaultDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostimgService {
    defaultDto.CreateResDto create(PostimgDto.CreateReqDto param);
    void update(PostimgDto.UpdateReqDto param);
    void delete(PostimgDto.UpdateReqDto param);
    PostimgDto.DetailResDto detail(defaultDto.DetailReqDto param);
    List<PostimgDto.DetailResDto> list(PostimgDto.ListReqDto param);
    defaultDto.PagedListResDto pagedList(PostimgDto.PagedListReqDto param);
    List<PostimgDto.DetailResDto> scrollList(PostimgDto.ScrollListReqDto param);
}
