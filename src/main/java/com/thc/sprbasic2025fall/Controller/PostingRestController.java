package com.thc.sprbasic2025fall.Controller;

import com.thc.sprbasic2025fall.domain.Posting;
import com.thc.sprbasic2025fall.dto.defaultDto;
import com.thc.sprbasic2025fall.dto.postingDto;
import com.thc.sprbasic2025fall.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/posting")
@RequiredArgsConstructor

public class PostingRestController {
    final PostingService postingService;

    @PostMapping("")
    public ResponseEntity<defaultDto.CreateResDto> create(@RequestBody postingDto.CreateReqDto param) {
//        return postingService.create(param);
//        return ResponseEntity.status(HttpStatus.CREATED).body(postingService.create(param));
        return ResponseEntity.ok(postingService.create(param));
    }

    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody postingDto.UpdateReqDto param) {
        postingService.update(param);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody postingDto.UpdateReqDto param) {
        postingService.delete(param);
        return  ResponseEntity.ok().build();
    }
    // Body에 담아서 보낼 때에는 RequestBody, 그냥 Parameter로 보내면 RequestParam

    @GetMapping("")
    public ResponseEntity<postingDto.DetailResDto> detail(defaultDto.DetailReqDto param) {
        return ResponseEntity.ok(postingService.detail(param));
    }

    @GetMapping("/list")
    public ResponseEntity<List<postingDto.DetailResDto>> list(postingDto.ListReqDto param) {
        return ResponseEntity.ok(postingService.list(param));
    }

    @GetMapping("/pagedList")
    public ResponseEntity<defaultDto.PagedListResDto> pagedList(postingDto.PagedListReqDto param) {
        return ResponseEntity.ok(postingService.pagedList(param));
    }

    @GetMapping("/scrollList")
    public ResponseEntity<List<postingDto.DetailResDto>> scrollList(postingDto.ScrollListReqDto param) {
        return ResponseEntity.ok(postingService.scrollList(param));
    }
}
