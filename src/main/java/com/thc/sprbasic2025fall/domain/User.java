package com.thc.sprbasic2025fall.domain;

import com.thc.sprbasic2025fall.dto.UserDto;
import com.thc.sprbasic2025fall.dto.defaultDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class User extends AuditingFields {
    @Column(nullable = false, unique = true)
    String username; // 유저 ID로 활용

    // 비밀번호
    String password;

    // 유저 이름
    String name;

    // 유저 연락처
    String phone;

    // 유저 성별
    String gender;

    protected User(){}
    private User(String username, String password, String name, String phone, String gender) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
    }
    public static User of(String username, String password, String name, String phone, String gender) {
        return new User(username, password, name, phone, gender);
    }

    public void update(UserDto.UpdateReqDto param){
        if(param.getDeleted() != null) {
            setDeleted(param.getDeleted());
        }
        if(param.getPassword() != null) {
            setPassword(param.getPassword());
        }
        if(param.getName() != null) {
            setName(param.getName());
        }
        if(param.getPhone() != null) {
            setPhone(param.getPhone());
        }
        if(param.getGender() != null) {
            setGender(param.getGender());
        }
    }

    public defaultDto.CreateResDto toCreateResDto(){
        return defaultDto.CreateResDto.builder()
                .id(getId())
                .build();
    }
}
