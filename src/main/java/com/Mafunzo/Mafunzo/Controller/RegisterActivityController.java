package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.User;
import com.Mafunzo.Mafunzo.Model.WalkActivity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterActivityController {
    @GetMapping("/registerActivity")
    public String registerActivity(){
        return "registerActivity";
    }

    @GetMapping("/strengthTraining")
    public String strengthTraining(){
        return "strengthTraining";
    }
    @GetMapping("/walkTraining")
    public String walkTraining(Model model){
        model.addAttribute("walkActivity", new WalkActivity());
        return "walkTraining";
    }

    @PostMapping("/registerWalk")
    public String registerWalk(@ModelAttribute WalkActivity walkActivity) {
        User kevin = new User();
        kevin.getActivitiesList().add(walkActivity);
        return "index";
    }
}
