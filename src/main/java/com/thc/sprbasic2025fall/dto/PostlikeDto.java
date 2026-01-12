package com.thc.sprbasic2025fall.dto;

import com.thc.sprbasic2025fall.domain.Postlike;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

public class PostlikeDto {
    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
    public static class LikedReqDto {
        Long postingId;
        Long userId;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
    public static class LikedResDto {
        Boolean liked;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
    public static class ToggleResDto {
        Boolean liked;
        Integer countlike;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
    public static class CreateReqDto{
        Long postingId;
        Long userId;

        public Postlike toEntity(){
            return Postlike.of(getPostingId(),getUserId());
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
