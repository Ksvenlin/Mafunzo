package com.Mafunzo.Mafunzo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class IndexController {
    @GetMapping("/homePage")
    public String index(){
        return "homePage";
    }
}
