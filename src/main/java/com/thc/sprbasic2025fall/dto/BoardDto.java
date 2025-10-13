package com.thc.sprbasic2025fall.dto;

import com.thc.sprbasic2025fall.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

public class BoardDto {
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public static class CreateReqDto {
        String title;
        String content;
        String author;

        public Board toEntity() {
            return Board.of(getTitle(), getContent(), getAuthor());
        }
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class UpdateReqDto extends defaultDto.UpdateReqDto {
        String title;
        String content;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class DetailResDto extends defaultDto.DetailResDto {
        String title;
        String content;
        String author;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class ListReqDto extends defaultDto.ListReqDto {
        String title;
        String author;
    }
}
