package com.thc.sprbasic2025fall.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class DefaultController {

    @ResponseBody // 지금은 무시해도 됨
    @RequestMapping("/test")
    public List<String> test(){
        int a = 0;
        double double_a = 0.0; // float는 안 쓸 것
        boolean boolean_a = false;
        String string_a = ""; // 한 글자여도 String 사용

        for(int i = 0; i < 10; i++){
            System.out.println(i);
        }

        String[] array_a = {"1", "2"};
        for(int i = 0; i < array_a.length; i++){
            String each = array_a[i];
            System.out.println(each);
        }

        // 하지만 앞으로는 for Each 문 사용
        for(String each : array_a){
            System.out.println(each);
        }

        if(a > 0){

        } else {

        }

        //
        Map<String, Object> a_map = new HashMap<String, Object>();
        a_map.put("key_a", "value_a");
        a_map.get("key_ab"); // 선언되지 않은 경우 Null 값 리턴

        String a_value = (String) a_map.get("key_a");

        List<String> a_list = new ArrayList<String>();
        a_list.add("value_a");
        a_list.add("value_b");

        String string_0 = a_list.get(0); // 없는 인덱스는 에러

        return a_list;
    }

    @ResponseBody
    @RequestMapping("/gugudan/{num}") // URL 내 변수를 받아 유저가 원하는 숫자에 대한 구구단을 출력
    public String gugudan(@PathVariable int num){
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        StringBuilder sb = new StringBuilder(1 >> 20);
        for(int i : nums){
            sb.append(num).append(" X ").append(i).append(" = ").append(num * i).append("<br>"); // HTML 로 출력하기 때문에 "\n" 아닌 <br> 로 줄바꿈
        }

        return sb.toString();
    }

    // 교수님의 풀이
    // Mapping URL은 항상 유니크
    @ResponseBody
    /**
     * 그냥 컨트롤러는 무조건 페이지 컨트롤러임
     * 객체로 돌려주기 위해서는 ResponseBody 어노테이션 추가
     */
    @RequestMapping("/multiples")
    public String[] multiples(){
        for(int i = 1; i < 10; i++){
            for(int j = 1; j < 10; j++){
                System.out.println(i + " * " + j + " = " + (i * j));
            }
        }

        String[] result = {"1", "2"};

        return result;
    }
}
