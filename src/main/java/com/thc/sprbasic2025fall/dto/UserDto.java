package com.thc.sprbasic2025fall.dto;

import com.thc.sprbasic2025fall.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
        String phone;
        String gender;

        public User toEntity(){
            return User.of(getUsername(), getPassword(), getName(), getPhone(), getGender());
        }
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class UpdateReqDto extends defaultDto.UpdateReqDto {
        String password;
        String name;
        String phone;
        String gender;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class DetailResDto extends defaultDto.DetailResDto {
        String username;
        String name;
        String phone;
        String gender;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class ListReqDto extends defaultDto.ListReqDto {
        /**
         * 검색 기능 구현을 위한 Request
         */
        String name;
        String phone;
    }
}
