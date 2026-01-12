package com.thc.sprbasic2025fall.domain;

import com.thc.sprbasic2025fall.dto.PostlikeDto;
import com.thc.sprbasic2025fall.dto.defaultDto;
import com.thc.sprbasic2025fall.dto.postingDto;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Postlike extends AuditingFields {
    @Setter
    Long postingId;
    @Setter
    Long userId;

    protected Postlike() {}
    private Postlike(Long userId, Long postingId) {
        this.userId = userId;
        this.postingId = postingId;
    }

    // 접근 가능 메서드
    public static Postlike of(Long userId, Long postingId) {
        return new Postlike(userId, postingId);
    }

    public defaultDto.CreateResDto toCreateResDto(){
        return defaultDto.CreateResDto.builder()
                .id(getId())
                .build();
    }

    public void update(PostlikeDto.UpdateReqDto param) {
        if(param.getDeleted() != null) {
            setDeleted(param.getDeleted());
        }
    }
}
