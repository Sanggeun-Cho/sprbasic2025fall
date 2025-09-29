package com.thc.sprbasic2025fall.Controller;

import com.thc.sprbasic2025fall.domain.Posting;
import com.thc.sprbasic2025fall.dto.postingDto;
import com.thc.sprbasic2025fall.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/posting")
@RequiredArgsConstructor

public class PostingRestController {
    final PostingService postingService;

    @PostMapping("")
    public postingDto.CreateResDto create(@RequestBody postingDto.CreateReqDto param) {
        return postingService.create(param);
    }

    @PutMapping("")
    public void update(@RequestBody postingDto.UpdateReqDto param) {
        postingService.update(param);
    }

    @DeleteMapping("")
    public void delete(@RequestBody postingDto.UpdateReqDto param) {
        postingService.delete(param);
    }
    // Body에 담아서 보낼 때에는 RequestBody, 그냥 Parameter로 보내면 RequestParam

    @GetMapping("")
    public postingDto.DetailResDto detail(postingDto.DetailReqDto param) {
        return postingService.detail(param);
    }

    @GetMapping("/list")
    public List<postingDto.DetailResDto> list(postingDto.ListReqDto param) {
        return postingService.list(param);
    }
}
