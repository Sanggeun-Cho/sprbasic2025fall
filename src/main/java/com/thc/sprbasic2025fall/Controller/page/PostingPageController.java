package com.thc.sprbasic2025fall.Controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posting")

public class PostingPageController {
    @GetMapping("/{page}")
    public String Page(@PathVariable String page) {
        return "posting/" + page;
    }

    @GetMapping("/{page}/{id}")
    public String Page2(@PathVariable String page, @PathVariable Long id) {
        return "posting/" + page;
    }
}
