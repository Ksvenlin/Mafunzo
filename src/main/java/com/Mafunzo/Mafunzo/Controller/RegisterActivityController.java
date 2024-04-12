package com.Mafunzo.Mafunzo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class RegisterActivityController {
    @GetMapping("/registerActivity")
    public String registerActivity(){
        return "registerActivity";
    }
}
