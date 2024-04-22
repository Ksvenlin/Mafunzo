package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.Activity.BikeActivity;
import com.Mafunzo.Mafunzo.Model.Activity.RunActivity;
import com.Mafunzo.Mafunzo.Model.Activity.SwimActivity;
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

    @PostMapping("/registerRun")
    public String registerRun(@ModelAttribute RunActivity runActivity) {
        User user = new User(new XpSystem(10, 10, 10, 10, 10), "fname","lname", "email", "password", 10);
        user.getActivitiesList().add(runActivity);
        return "homePage";
    }

    @PostMapping("/registerSwim")
    public String registerSwim(@ModelAttribute SwimActivity swimActivity) {
        User user = new User(new XpSystem(10, 10, 10, 10, 10), "fname","lname", "email", "password", 10);
        user.getActivitiesList().add(swimActivity);
        return "homePage";
    }

    @PostMapping("/registerBike")
    public String registerBike(@ModelAttribute BikeActivity bikeActivity) {
        User user = new User(new XpSystem(10, 10, 10, 10, 10), "fname","lname", "email", "password", 10);
        user.getActivitiesList().add(bikeActivity);
        return "homePage";
    }




}
