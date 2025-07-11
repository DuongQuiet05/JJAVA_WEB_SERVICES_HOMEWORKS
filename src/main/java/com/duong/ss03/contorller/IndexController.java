package com.duong.ss03.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping
    public String goIndex (){
        return "index";
    }

    @GetMapping("/hw01")
    public String hw01 (){
        return "hw01";
    }
}
