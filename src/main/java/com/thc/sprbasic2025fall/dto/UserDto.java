package com.thc.sprbasic2025fall.dto;

import com.thc.sprbasic2025fall.domain.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

public class UserDto {
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public static class LoginReqDto {
        String username;
        String password;
    }

    /**/

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public static class CreateReqDto {
        String username;
        String password;
        String name;
        String nick;
        String phone;
        String birth;
        String gender;

        public User toEntity(){
            return User.of(getUsername(), getPassword(), getName(), getNick(), getPhone(), getBirth(), getGender());
        }
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class UpdateReqDto extends defaultDto.UpdateReqDto {
        String password;
        String name;
        String nick;
        String phone;
        String birth;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class DetailResDto extends defaultDto.DetailResDto {
        String username;
        String name;
        String nick;
        String phone;
        String birth;
        String gender;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class ListReqDto extends defaultDto.ListReqDto {
        /**
         * 검색 기능 구현을 위한 Request
         */
        String phone;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class PagedListReqDto extends defaultDto.PagedListReqDto {
        String phone;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class ScrollListReqDto extends defaultDto.ScrollListReqDto {
        String phone;
    }
}
