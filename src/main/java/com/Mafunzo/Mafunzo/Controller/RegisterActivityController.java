package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.Activity.WalkActivity;
import com.Mafunzo.Mafunzo.Model.User;
import com.Mafunzo.Mafunzo.Model.XpSystem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterActivityController {


    @PostMapping("/registerWalk")
    public String registerWalk(@ModelAttribute WalkActivity walkActivity) {
        User user = new User(new XpSystem(10, 10, 10, 10, 10), "fname","lname", "email", "password", 10);
        user.getActivitiesList().add(walkActivity);
        return "homePage";
    }
}
