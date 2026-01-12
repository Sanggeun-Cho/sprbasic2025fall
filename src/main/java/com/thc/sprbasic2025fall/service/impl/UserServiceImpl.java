package com.thc.sprbasic2025fall.service.impl;

import com.thc.sprbasic2025fall.domain.User;
import com.thc.sprbasic2025fall.dto.UserDto;
import com.thc.sprbasic2025fall.dto.defaultDto;
import com.thc.sprbasic2025fall.mapper.UserMapper;
import com.thc.sprbasic2025fall.repository.UserRepository;
import com.thc.sprbasic2025fall.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor @Service
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;
    final UserMapper userMapper;

    @Override
    public defaultDto.CreateResDto login(UserDto.LoginReqDto param) {
        User user = userRepository.findByUsernameAndPassword(param.getUsername(), param.getPassword());
        if(user == null){
            throw new RuntimeException("no data");
        }

        return defaultDto.CreateResDto.builder()
                .id(user.getId())
                .build();
    }

    /**/

    @Override
    public defaultDto.CreateResDto create(UserDto.CreateReqDto param) {
        User user = userRepository.findByUsername(param.getUsername());
        if(user != null){
            throw new RuntimeException("already exist");
        }
        user = userRepository.findByNick(param.getNick());
        if(user != null){
            throw new RuntimeException("already exist");
        }

        return userRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(UserDto.UpdateReqDto param) {
        User user = userRepository.findById(param.getId())
                .orElseThrow(() -> new RuntimeException("no data"));

        user.update(param);
        userRepository.save(user);
    }

    @Override
    public void delete(UserDto.UpdateReqDto param) {
        update(UserDto.UpdateReqDto.builder()
                .id(param.getId())
                .deleted(true)
                .build());
    }

    public UserDto.DetailResDto get(defaultDto.DetailReqDto param) {
        UserDto.DetailResDto res = userMapper.detail(param.getId());

        return res;
    }

    @Override
    public UserDto.DetailResDto detail(defaultDto.DetailReqDto param) {
        return get(param);
    }

    public List<UserDto.DetailResDto> addlist(List<UserDto.DetailResDto> list){
        List<UserDto.DetailResDto> newList = new ArrayList<>();
        for(UserDto.DetailResDto user : list){
            newList.add(get(defaultDto.DetailReqDto.builder()
                    .id(user.getId())
                    .build()));
        }

        return newList;
    }

    @Override
    public List<UserDto.DetailResDto> list(UserDto.ListReqDto param) {
        List<UserDto.DetailResDto> list = new ArrayList<>();
        List<UserDto.DetailResDto> users = userMapper.list(param);

        return addlist(users);
    }

    @Override
    public defaultDto.PagedListResDto pagedList(UserDto.PagedListReqDto param) {
        defaultDto.PagedListResDto res = param.init(userMapper.listCount(param));
        res.setList(addlist(userMapper.pagedList(param)));

        return res;
    }

    @Override
    public List<UserDto.DetailResDto> scrollList(UserDto.ScrollListReqDto param) {
        return addlist(userMapper.scrollList(param));
    }
}
