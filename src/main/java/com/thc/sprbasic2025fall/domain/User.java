package com.thc.sprbasic2025fall.domain;

import com.thc.sprbasic2025fall.dto.UserDto;
import com.thc.sprbasic2025fall.dto.defaultDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter
public class User extends AuditingFields {
    @Setter
    @Column(nullable = false, unique = true)
    String username;

    @Setter
    @Column(nullable = false)
    String password;

    @Setter
    String name;

    @Setter
    @Column(nullable = false, unique = true)
    String nick;

    @Setter
    String phone;

    @Setter
    String birth;

    @Setter
    String gender;

    protected User(){}
    private User(String username, String password, String name, String nick, String phone, String birth, String gender) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.nick = nick;
        this.phone = phone;
        this.birth = birth;
        this.gender = gender;
    }
    public static User of(String username, String password, String name, String nick, String phone, String birth, String gender) {
        return new User(username, password, name, nick, phone, birth, gender);
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
        if(param.getNick() != null) {
            setNick(param.getNick());
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
