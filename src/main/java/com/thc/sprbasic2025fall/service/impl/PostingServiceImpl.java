package com.thc.sprbasic2025fall.service.impl;

import com.thc.sprbasic2025fall.domain.Posting;
import com.thc.sprbasic2025fall.dto.defaultDto;
import com.thc.sprbasic2025fall.dto.postingDto;
import com.thc.sprbasic2025fall.repository.PostingRepository;
import com.thc.sprbasic2025fall.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor

public class PostingServiceImpl implements PostingService {
    final PostingRepository postingRepository;

    @Override
    public defaultDto.CreateResDto create(postingDto.CreateReqDto param) {
        return postingRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(postingDto.UpdateReqDto param) {
        Posting posting = postingRepository.findById(param.getId())
                .orElseThrow(() -> new RuntimeException("no data"));
        posting.update(param);
        postingRepository.save(posting);
    }

    @Override
    public void delete(postingDto.UpdateReqDto param) {
        update(postingDto.UpdateReqDto.builder()
                .id(param.getId())
                .deleted(true)
                .build());
    }

    public postingDto.DetailResDto get(defaultDto.DetailReqDto param) {
        Posting posting = postingRepository.findById(param.getId())
                .orElseThrow(() -> new RuntimeException("no data"));

        return postingDto.DetailResDto.builder()
                .id(posting.getId())
                .deleted(posting.getDeleted())
                .title(posting.getTitle())
                .content(posting.getContent())
                .build();
    }

    @Override
    public postingDto.DetailResDto detail(defaultDto.DetailReqDto param) {
        return get(param);
    }

    @Override
    public List<postingDto.DetailResDto> list(postingDto.ListReqDto param) {
        List<postingDto.DetailResDto> list = new ArrayList<>();
        List<Posting> postings = postingRepository.findAll();

        for(Posting posting : postings){
            if(param.getDeleted() != null){
                if(posting.getDeleted() == param.getDeleted()){
                    list.add(get(defaultDto.DetailReqDto.builder()
                            .id(posting.getId())
                            .build()));
                }
            }
        }
        return list;
    }
}
