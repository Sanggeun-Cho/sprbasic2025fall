package com.thc.sprbasic2025fall.service;

import com.thc.sprbasic2025fall.dto.defaultDto;
import com.thc.sprbasic2025fall.dto.PostlikeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostlikeService {
    PostlikeDto.LikedResDto liked(PostlikeDto.LikedReqDto param);
    PostlikeDto.ToggleResDto toggle(PostlikeDto.CreateReqDto param);
    /**/
    defaultDto.CreateResDto create(PostlikeDto.CreateReqDto param);
    void update(PostlikeDto.UpdateReqDto param);
    void delete(PostlikeDto.UpdateReqDto param);
    PostlikeDto.DetailResDto detail(defaultDto.DetailReqDto param);
    List<PostlikeDto.DetailResDto> list(PostlikeDto.ListReqDto param);
    defaultDto.PagedListResDto pagedList(PostlikeDto.PagedListReqDto param);
    List<PostlikeDto.DetailResDto> scrollList(PostlikeDto.ScrollListReqDto param);
}