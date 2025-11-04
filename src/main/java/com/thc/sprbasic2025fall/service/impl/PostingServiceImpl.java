package com.thc.sprbasic2025fall.service.impl;

import com.thc.sprbasic2025fall.domain.Posting;
import com.thc.sprbasic2025fall.dto.defaultDto;
import com.thc.sprbasic2025fall.dto.postingDto;
import com.thc.sprbasic2025fall.mapper.PostingMapper;
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
    final PostingMapper postingMapper;

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
        postingDto.DetailResDto res = postingMapper.detail(param.getId());

        return res;
    }

    @Override
    public postingDto.DetailResDto detail(defaultDto.DetailReqDto param) {
        return get(param);
    }

    public List<postingDto.DetailResDto> addlist(List<postingDto.DetailResDto> list) {
        List<postingDto.DetailResDto> newList = new ArrayList<>();

        for(postingDto.DetailResDto posting : list) {
            newList.add(get(defaultDto.DetailReqDto.builder()
                    .id(posting.getId())
                    .build()));
        }

        return newList;
    }

    @Override
    public List<postingDto.DetailResDto> list(postingDto.ListReqDto param) {
        List<postingDto.DetailResDto> postings = postingMapper.list(param);

        return addlist(postings);
    }

    /*@Override
    public defaultDto.PagedListResDto pagedList(postingDto.PagedListReqDto param) {
        Integer callpage = param.getCallpage();
        if(callpage == null) callpage = 1; // 호출 페이지 없으면 1 고정
        if(callpage < 1) callpage = 1; // 음수를 호출할 경우 1 고정

        Integer perpage = param.getPerpage();
        if(perpage == null) perpage = 10; // 페이지 당 개수 안정해주면 10으로 설정
        if(perpage < 2) perpage = 10; // 2개 미만으로 보여주려 할 경우 10으로 설정

        int listcount = postingMapper.listCount(param);

        *//**
         * 만약 21개의 게시글을 5개씩 보여주고 싶다
         * 21 / 5 = 4 (하나의 게시글이 남음)
         * 21 % 5 > 0 (남은 하나의 게시글을 위한 페이지 생성)
         * total = 5 -> 21개의 게시글을 5개씩 보여주기 위해서는 5개의 페이지 필요
         *//*
        int totalpage = listcount / perpage; // 개수에 맞게 전체 페이지 수 설정
        if(listcount % perpage > 0) totalpage++; // perpage에 부족하지만 개수가 남아 있다면 페이지 생성

        if(totalpage < 1) totalpage = 1; // 전체 페이지가 1보다 작을 경우 1로 고정
        if(callpage > totalpage) callpage = totalpage;

        *//**
         * 실제 호출해야 할 페이지
         * 5개로 나눈 상태에서 4페이지를 보고 싶으면 15번째 글부터 출력 (index 기준)
         *//*
        int offset = (callpage - 1) * perpage;

        param.setOffset(offset);
        param.setPerpage(perpage);

        List<postingDto.DetailResDto> list = new ArrayList<>();
        List<postingDto.DetailResDto> postings = postingMapper.pagedList(param);

        for (postingDto.DetailResDto posting : postings) {
            list.add(get(defaultDto.DetailReqDto.builder()
                    .id(posting.getId())
                    .build()));
        }

        return defaultDto.PagedListResDto.builder()
                .callpage(callpage)
                .totalpage(totalpage)
                .listcount(listcount)
                .list(list)
                .build();
    }*/

    @Override
    public defaultDto.PagedListResDto pagedList(postingDto.PagedListReqDto param) {
        defaultDto.PagedListResDto res = param.init(postingMapper.listCount(param));
        res.setList(addlist(postingMapper.pagedList(param)));

        return res;
    }

    @Override
    public List<postingDto.DetailResDto> scrollList(postingDto.ScrollListReqDto param) {
        return addlist(postingMapper.scrollList(param));
    }
}
