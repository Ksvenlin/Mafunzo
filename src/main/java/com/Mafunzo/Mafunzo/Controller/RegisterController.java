package com.Mafunzo.Mafunzo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class RegisterController {
    @GetMapping("/login")
    public String RegisterForm(){
        return "LoginPage";
    }
}
