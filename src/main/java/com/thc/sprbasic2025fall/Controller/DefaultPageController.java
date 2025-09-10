package com.thc.sprbasic2025fall.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 스프링부트에게 컨트롤러임을 알리기 위한 어노테이션 -> 알아서 에러 등도 잡아줌
@Controller

public class DefaultPageController {
    // 페이지 컨트롤러 예시
    @RequestMapping("/index") // 이건 URL 매핑이라 리턴하는 값과는 관련이 없음
    public String index(){
        System.out.println("DefaultPageController.index()"); // 제대로 전송이 된건지 확인하는 로그 느낌
        return "index"; // PATH : src/resources/templates/index.html
    }

    @RequestMapping("/add")
    public String add(int a, int b, Model model){ // MVC의 형태, View에 맞추어 Model을 돌려주는 것
        // 파라미터 받는 방법
        // ~~~?key1=value1&key2=value2
        // 없는 파라미터를 선언하면 알아서 무시
        System.out.println("DefaultPageController.add()");
        System.out.println("a : " + a);
        System.out.println("b : " + b);

        int sum = a + b;
        System.out.println("sum : " + sum);

        model.addAttribute("sum", sum);

        return "add";
    }

    @RequestMapping("/addstring")
    public String addstring(String a, String b, Model model){
        // 두 개의 글자를 입력 받아서 결합
        String sum = a + b;

        model.addAttribute("sum", sum);

        return "addstring";
    }
}
