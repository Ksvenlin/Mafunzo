package com.Mafunzo.Mafunzo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
    @GetMapping("/profilepage")
    public String registerActivity(){
        return "profilepage";
    }
}