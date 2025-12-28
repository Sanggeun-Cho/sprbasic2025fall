package com.thc.sprbasic2025fall.dto;

import com.thc.sprbasic2025fall.domain.Postimg;
import lombok.*;
import lombok.experimental.SuperBuilder;

public class PostimgDto {

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class CreateReqDto{
        Long postingId;
        String img;

        public Postimg toEntity(){
            return Postimg.of(getPostingId(), getImg());
        }
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class UpdateReqDto extends defaultDto.UpdateReqDto{
        String img;
    }
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class DetailResDto extends defaultDto.DetailResDto {
        Long postingId;
        String img;
    }
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class ListReqDto extends defaultDto.ListReqDto {
        Long postingId;
    }
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class PagedListReqDto extends defaultDto.PagedListReqDto {
        Long postingId;
    }
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class ScrollListReqDto extends defaultDto.ScrollListReqDto {
        Long postingId;
    }
}