package com.thc.sprbasic2025fall.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController // 페이지 리턴이 아닌 객체 리턴

public class DefaultRestController {
    @RequestMapping("/api/add")
    public Map<String, Object> add(int a, int b){
        int sum = a + b;
        Map<String, Object> map = new HashMap<>();

        map.put("resultCode", 200);
        map.put("sum", sum);

        return map;
    }

    @RequestMapping("/api/multiple")
    public Map<String, Object>
}
