package com.thc.sprbasic2025fall.service;

import com.thc.sprbasic2025fall.dto.UserDto;
import com.thc.sprbasic2025fall.dto.defaultDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    defaultDto.CreateResDto login(UserDto.LoginReqDto param);

    defaultDto.CreateResDto create(UserDto.CreateReqDto param);

    void update(UserDto.UpdateReqDto param);

    void delete(UserDto.UpdateReqDto param);

    UserDto.DetailResDto detail(defaultDto.DetailReqDto param);

    List<UserDto.DetailResDto> list(UserDto.ListReqDto param);
}
