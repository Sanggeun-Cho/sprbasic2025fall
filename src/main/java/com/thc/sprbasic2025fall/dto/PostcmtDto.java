package com.thc.sprbasic2025fall.dto;

import com.thc.sprbasic2025fall.domain.Postcmt;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

public class PostcmtDto {
    @Getter @Setter @AllArgsConstructor @NoArgsConstructor
    public static class CreateReqDto{
        Long PostingId;
        Long userId;
        String content;

        public Postcmt toEntity(){
            return Postcmt.of(getPostingId(), getUserId(), getContent());
        }
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
    public static class UpdateReqDto extends defaultDto.UpdateReqDto{
        String content;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
    public static class DetailResDto extends defaultDto.DetailResDto{
        Long postingId;
        Long userId;
        String content;

        String userUsername;
        String userName;
        String userNick;
    }
    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
    public static class ListReqDto extends defaultDto.ListReqDto{
        Long postingId;
        Long userId;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
    public static class PagedListReqDto extends defaultDto.PagedListReqDto{
        Long postingId;
        Long userId;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
    public static class ScrollListReqDto extends defaultDto.ScrollListReqDto{
        Long postingId;
        Long userId;
    }
}
