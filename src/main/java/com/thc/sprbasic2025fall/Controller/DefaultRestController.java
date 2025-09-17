package com.thc.sprbasic2025fall.Controller;

import com.thc.sprbasic2025fall.dto.MultipleBasket;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController // 페이지 리턴이 아닌 객체 리턴
@RequestMapping("/api") // 모든 메서드 앞에 붙는 매핑

public class DefaultRestController {
    @RequestMapping("/add")
    public Map<String, Object> add(int a, int b){
        int sum = a + b;
        Map<String, Object> map = new HashMap<>();

        map.put("resultCode", 200);
        map.put("sum", sum);

        return map;
    }

    @RequestMapping("/multiple")
    public Map<String, Object> multiple(@RequestParam int a1, int a, int b){ // ReqeustParam이 붙으면 a1이 필요 없더라도 값이 없으면 에러를 냄
        int result = a * b;
        Map<String, Object> map = new HashMap<>();

        map.put("resultCode", 200);
        map.put("result", result);

        return map;
    }

    @RequestMapping("/multiple2")
    public Map<String, Object> multiple2(@RequestParam Map<String, Object> param){
        /**
         * Map<String, Object> map = new HashMap<>();
         *         map.put("a", a);
         *         map.put("b", b);
         *
         *         int a_1 = Integer.parseInt(a + "");
         *         int b_2 = Integer.parseInt(B + "");
         */
        int a = Integer.parseInt(param.get("a") + "");
        int b = Integer.parseInt(param.get("b") + "");

        int result = a * b;

        Map<String, Object> result_map = new HashMap<>();

        result_map.put("resultCode", 200);
        result_map.put("result", result);

        return result_map;
    }

    @RequestMapping("/multiple3")
    public Map<String, Object> multiple3(MultipleBasket param){ // 객체로 받을 때에는 RequestParam 시 에러 가능
        int a = param.getA();
        int b = param.getB();

        int result = a * b;

        Map<String, Object> map = new HashMap<>();

        map.put("resultCode", 200);
        map.put("result", result);

        return map;
    }
}
