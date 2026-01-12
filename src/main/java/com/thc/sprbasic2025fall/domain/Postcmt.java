package com.thc.sprbasic2025fall.domain;

import com.thc.sprbasic2025fall.dto.PostcmtDto;
import com.thc.sprbasic2025fall.dto.defaultDto;
import com.thc.sprbasic2025fall.dto.postingDto;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Postcmt extends AuditingFields {
    @Setter
    Long postingId;
    @Setter
    Long userId;
    @Setter
    String content;

    protected Postcmt() {}
    private Postcmt(Long postingId, Long userId, String content) {
        this.postingId = postingId;
        this.userId = userId;
        this.content = content;
    }

    // 접근 가능 메서드
    public static Postcmt of(Long postingId, Long userId, String content) {
        return new Postcmt(postingId, userId, content);
    }

    public defaultDto.CreateResDto toCreateResDto(){
        return defaultDto.CreateResDto.builder()
                .id(getId())
                .build();
    }

    public void update(PostcmtDto.UpdateReqDto param) {
        if(param.getDeleted() != null) {
            setDeleted(param.getDeleted());
        }
        if(param.getContent() != null) {
            setContent(param.getContent());
        }
    }
}
