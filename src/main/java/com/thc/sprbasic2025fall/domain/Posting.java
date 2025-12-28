package com.thc.sprbasic2025fall.domain;

import com.thc.sprbasic2025fall.dto.defaultDto;
import com.thc.sprbasic2025fall.dto.postingDto;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Posting extends AuditingFields {
    @Setter
    Long userId;
    @Setter
    String title;
    @Setter
    String content;
    @Setter
    String img;

    protected Posting() {}
    private Posting(Long userId, String title, String content, String img) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.img = img;
    }

    // 접근 가능 메서드
    public static Posting of(Long userId, String title, String content, String img) {
        return new Posting(userId, title, content, img);
    }

    public defaultDto.CreateResDto toCreateResDto(){
        return defaultDto.CreateResDto.builder()
                .id(getId())
                .build();
    }

    public void update(postingDto.UpdateReqDto param) {
        if(param.getDeleted() != null) {
            setDeleted(param.getDeleted());
        }
        if(param.getTitle() != null) {
            setTitle(param.getTitle());
        }
        if(param.getContent() != null) {
            setContent(param.getContent());
        }
        if(param.getImg() != null) {
            setImg(param.getImg());
        }
    }
}
