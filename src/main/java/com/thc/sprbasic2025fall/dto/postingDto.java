package com.thc.sprbasic2025fall.dto;

import com.thc.sprbasic2025fall.domain.Posting;
import lombok.*;

public class postingDto {
    @Getter @Setter @AllArgsConstructor @NoArgsConstructor
    public static class CreateReqDto{
        String title;
        String content;

        public Posting toEntity(){
            return Posting.of(getTitle(), getContent());
        }
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
    public static class CreateResDto{
        Long id;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
    public static class UpdateReqDto{
        Long id;
        Boolean deleted;
        String title;
        String content;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
    public static class DetailReqDto{
        Long id;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
    public static class DetailResDto{
        Long id;
        Boolean deleted;
        String title;
        String content;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
    public static class ListReqDto{
        Boolean deleted;
        String title;
    }
}
