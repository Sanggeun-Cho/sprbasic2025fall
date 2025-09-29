package com.thc.sprbasic2025fall.service.impl;

import com.thc.sprbasic2025fall.domain.Writing;
import com.thc.sprbasic2025fall.repository.WritingRepository;
import com.thc.sprbasic2025fall.service.WritingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class WritingServiceImpl implements WritingService {
    final WritingRepository writingRepository;

    @Override
    public Map<String, Object> create(Map<String, Object> params) {
        String title = (String) params.get("title");
        String content = (String) params.get("content");

        Writing writing = new Writing();
        writing.setTitle(title);
        writing.setContent(content);

        writingRepository.save(writing);

        Map<String, Object> map_return = new HashMap<>();

        map_return.put("resultCode", 200);
        map_return.put("id", writing.getId());

        return map_return;
    }

    @Override
    public void update(Map<String, Object> params) {
        long id = Long.parseLong(params.get("id") + "");
        String title = (String) params.get("title");
        String content = (String) params.get("content");

        Writing writing = writingRepository.findById(id).orElse(null);
        if (writing != null) {
            writing.setTitle(title);
            writing.setContent(content);

            writingRepository.save(writing);
        }

        // return 은 optional, null일 때 어떡할거냐고 물어보는 것
    }

    @Override
    public void delete(Map<String, Object> params) {
        long id = Long.parseLong(params.get("id") + "");

        writingRepository.deleteById(id);
    }

    @Override
    public Map<String, Object> list() {
        List<Writing> writings = writingRepository.findAll();

        Map<String, Object> map_return = new HashMap<>();
        map_return.put("resultCode", 200);
        map_return.put("data", writings);

        return map_return;
    }

    @Override
    public Map<String, Object> detail(long id) {
        Writing writing = writingRepository.findById(id).orElse(null);

        Map<String, Object> map_return = new HashMap<>();
        map_return.put("resultCode", 200);
        map_return.put("data", writing);

        return map_return;
    }
}
