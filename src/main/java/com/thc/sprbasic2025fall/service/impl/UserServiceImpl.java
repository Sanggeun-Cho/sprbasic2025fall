package com.thc.sprbasic2025fall.service.impl;

import com.thc.sprbasic2025fall.domain.User;
import com.thc.sprbasic2025fall.dto.UserDto;
import com.thc.sprbasic2025fall.dto.defaultDto;
import com.thc.sprbasic2025fall.repository.UserRepository;
import com.thc.sprbasic2025fall.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor @Service
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;

    @Override
    public defaultDto.CreateResDto login(UserDto.LoginReqDto param) {
        User user = userRepository.findByUsernameAndPassword(param.getUsername(), param.getPassword());
        if(user == null){
            throw new RuntimeException("no matched data");
        }

        return defaultDto.CreateResDto.builder()
                .id(user.getId())
                .build();
    }

    /**/

    @Override
    public defaultDto.CreateResDto create(UserDto.CreateReqDto param) {
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
        User user = userRepository.findById(param.getId())
                .orElseThrow(() -> new RuntimeException("no data"));

        return UserDto.DetailResDto.builder()
                .id(user.getId())
                .deleted(user.getDeleted())
                .createdAt(user.getCreatedAt())
                .modifiedAt(user.getModifiedAt())
                .name(user.getName())
                .phone(user.getPhone())
                .gender(user.getGender())
                .build();
    }

    @Override
    public UserDto.DetailResDto detail(defaultDto.DetailReqDto param) {
        return get(param);
    }

    @Override
    public List<UserDto.DetailResDto> list(UserDto.ListReqDto param) {
        List<UserDto.DetailResDto> list = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for(User user : users){
            if(user.getDeleted() != null){
                if(user.getDeleted() == param.getDeleted()){
                    list.add(get(defaultDto.DetailReqDto.builder()
                            .id(user.getId())
                            .build()));
                }
            }
        }
        return list;
    }
}
