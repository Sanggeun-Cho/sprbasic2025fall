package com.thc.sprbasic2025fall.Controller;

import com.thc.sprbasic2025fall.service.WritingService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/writing")
@RestController

public class WritingRestController {
    WritingService writingService;
    // 생성자 방식
    WritingRestController(WritingService writingService) {
        this.writingService = writingService;
    }

    @PostMapping("")
    public Map<String, Object> create(@RequestBody Map<String, Object> params) {
        return writingService.create(params);
    }

    @GetMapping("/list")
    public Map<String, Object> list() {
        return writingService.list();
    }

    @GetMapping("")
    public Map<String, Object> detail(int id){
        return writingService.detail(id);
    }

    @PutMapping("")
    public void update(@RequestBody Map<String, Object> params) {
        writingService.update(params);
    }

    @DeleteMapping("")
    public void delete(@RequestBody Map<String, Object> params) {
        writingService.delete(params);
    }
}

