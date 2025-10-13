package com.thc.sprbasic2025fall.dto;

import com.thc.sprbasic2025fall.domain.Posting;
import lombok.*;
import lombok.experimental.SuperBuilder;

public class postingDto {
    @Getter @Setter @AllArgsConstructor @NoArgsConstructor
    public static class CreateReqDto{
        String title;
        String content;

        public Posting toEntity(){
            return Posting.of(getTitle(), getContent());
        }
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
    public static class UpdateReqDto extends defaultDto.UpdateReqDto{
        String title;
        String content;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
    public static class DetailResDto extends defaultDto.DetailResDto{
        String title;
        String content;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
    public static class ListReqDto extends defaultDto.ListReqDto{
        String title;
    }
}
