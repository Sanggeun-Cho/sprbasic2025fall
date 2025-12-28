package com.thc.sprbasic2025fall.dto;

import com.thc.sprbasic2025fall.domain.Posting;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

public class postingDto {
    @Getter @Setter @AllArgsConstructor @NoArgsConstructor
    public static class CreateReqDto{
        Long userId;
        String title;
        String content;
        String img;

        List<String> imgs;

        public Posting toEntity(){
            return Posting.of(getUserId(), getTitle(), getContent(), getImg());
        }
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
    public static class UpdateReqDto extends defaultDto.UpdateReqDto{
        String title;
        String content;
        String img;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
    public static class DetailResDto extends defaultDto.DetailResDto{
        Long userId;
        String title;
        String content;
        String img;

        String userUsername;
        String userName;
        String userNick;

        List<PostimgDto.DetailResDto> imgs;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
    public static class ListReqDto extends defaultDto.ListReqDto{
        Long userId;
        String title;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
    public static class PagedListReqDto extends defaultDto.PagedListReqDto{
        Long userId;
        String title;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
    public static class ScrollListReqDto extends defaultDto.ScrollListReqDto{
        Long userId;
        String title;
    }
}
