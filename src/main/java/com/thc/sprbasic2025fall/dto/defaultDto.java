package com.thc.sprbasic2025fall.dto;

import com.thc.sprbasic2025fall.domain.Posting;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

public class defaultDto {

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
    public static class CreateResDto{
        Long id;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
    public static class UpdateReqDto{
        Long id;
        Boolean deleted;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
    public static class DetailReqDto{
        Long id;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
    public static class DetailResDto{
        Long id;
        Boolean deleted;
        LocalDateTime createdAt;
        LocalDateTime modifiedAt;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
    public static class ListReqDto{
        Boolean deleted;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
    public static class PagedListReqDto{
        Integer callpage; // 사용자가 요청한 페이지
        Integer perpage; // 사용자가 요청한 페이지 당 개수
        Integer offset; // 실제 호출할 페이지

        Boolean deleted;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
    public static class PagedListResDto{
        Integer callpage; // 사용자가 요청한 페이지
        Integer totalpage; // 전체 페이지 (callpage / 4 ( + 1 ))
        Integer listcount; // 전체 포스팅 개수

        Object list;
    }
}
