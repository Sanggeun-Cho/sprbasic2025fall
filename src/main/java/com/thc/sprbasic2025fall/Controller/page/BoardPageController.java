package com.thc.sprbasic2025fall.Controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller

public class BoardPageController {
    @RequestMapping("/index")
    public String index(){
        return "board/index";
    }

    @RequestMapping("/{page}") // 경로에 오는 애를 변수처럼 쓰겠다
    public String page(@PathVariable String page){
        return "board/" + page;
    }
}
