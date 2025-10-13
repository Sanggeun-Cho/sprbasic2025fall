package com.thc.sprbasic2025fall.Controller;

import com.thc.sprbasic2025fall.dto.BoardDto;
import com.thc.sprbasic2025fall.dto.defaultDto;
import com.thc.sprbasic2025fall.service.BoardService;
import com.thc.sprbasic2025fall.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardRestController {
    final BoardService boardService;
    private final PostingService postingService;

    @PostMapping("")
    public ResponseEntity<defaultDto.CreateResDto> create(@RequestBody BoardDto.CreateReqDto param) {
        return ResponseEntity.ok(boardService.create(param));
    }

    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody BoardDto.UpdateReqDto param) {
        boardService.update(param);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody BoardDto.UpdateReqDto param) {
        boardService.delete(param);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<BoardDto.DetailResDto> detail(defaultDto.DetailReqDto param) {
        return ResponseEntity.ok(boardService.detail(param));
    }

    @GetMapping("/list")
    public ResponseEntity<List<BoardDto.DetailResDto>> list(BoardDto.ListReqDto param) {
        return ResponseEntity.ok(boardService.list(param));
    }
}
