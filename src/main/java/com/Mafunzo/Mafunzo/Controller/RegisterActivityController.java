package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.WalkActivity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterActivityController {


    @PostMapping("/registerWalk")
    public String registerWalk(@ModelAttribute WalkActivity walkActivity) {
        //TODO: GÖR INGET JUST NU
        return "homePage";
    }
}
