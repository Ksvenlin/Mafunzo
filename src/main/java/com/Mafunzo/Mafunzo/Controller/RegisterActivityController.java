package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.Activity.BikeActivity;
import com.Mafunzo.Mafunzo.Model.Activity.RunActivity;
import com.Mafunzo.Mafunzo.Model.Activity.SwimActivity;
import com.Mafunzo.Mafunzo.Model.Activity.WalkActivity;
import com.Mafunzo.Mafunzo.Model.User;
import com.Mafunzo.Mafunzo.Model.UserService;
import com.Mafunzo.Mafunzo.Model.XpSystem;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterActivityController {
    @Autowired
    private UserService userService;
    private User user;

    @PostMapping("/registerWalk")
    public String registerWalk(HttpSession session, WalkActivity walkActivity, Model model) {
        user = (User) session.getAttribute("loggedUser");
        user.getActivitiesList().add(walkActivity);
        System.out.println(walkActivity.getDistance());
        System.out.println(walkActivity.getDuration());
        userService.updateActivity(user);
        model.addAttribute("walkActivity", walkActivity);
        model.addAttribute("user", user);
        return "profilepage";
    }

    @PostMapping("/registerRun")
    public String registerRun(@ModelAttribute RunActivity runActivity) {
        user.getActivitiesList().add(runActivity);
        return "homePage";
    }

    @PostMapping("/registerSwim")
    public String registerSwim(@ModelAttribute SwimActivity swimActivity) {
        user.getActivitiesList().add(swimActivity);
        return "homePage";
    }

    @PostMapping("/registerBike")
    public String registerBike(@ModelAttribute BikeActivity bikeActivity) {
        user.getActivitiesList().add(bikeActivity);
        return "homePage";
    }


}
