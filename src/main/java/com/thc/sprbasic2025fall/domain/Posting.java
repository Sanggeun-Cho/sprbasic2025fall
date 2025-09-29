package com.thc.sprbasic2025fall.domain;

import com.thc.sprbasic2025fall.dto.postingDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Entity
public class Posting {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @Setter
    Boolean deleted;
    @Setter @CreatedDate
    LocalDateTime createdAt;
    @Setter @LastModifiedDate
    LocalDateTime modifiedAt;

    @Setter
    String title;
    @Setter
    String content;

    protected Posting() {}
    private Posting(Boolean deleted, String title, String content) {
        this.deleted = deleted;
        this.title = title;
        this.content = content;
    }

    // 접근 가능 메서드
    public static Posting of(String title, String content) {
        return new Posting(false, title, content);
    }

    public postingDto.CreateResDto toCreateResDto(){
        return postingDto.CreateResDto.builder()
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
    }
}
