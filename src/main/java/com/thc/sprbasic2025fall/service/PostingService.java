package com.thc.sprbasic2025fall.service;

import com.thc.sprbasic2025fall.domain.Posting;
import com.thc.sprbasic2025fall.dto.defaultDto;
import com.thc.sprbasic2025fall.dto.postingDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service

public interface PostingService {
    // create
    defaultDto.CreateResDto create(postingDto.CreateReqDto param);

    // update
    void update(postingDto.UpdateReqDto param);

    // delete
    void delete(postingDto.UpdateReqDto id);

    // detail
    postingDto.DetailResDto detail(defaultDto.DetailReqDto id);

    // list
    List<postingDto.DetailResDto> list(postingDto.ListReqDto param);
}
