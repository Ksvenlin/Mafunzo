package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.Activity.*;
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
        userService.updateActivity(user);
        model.addAttribute("user", user);
        /*
        Oklart vad detta gör, isak och kasper tror inte detta behövs för framtiden
        model.addAttribute("walkActivity", walkActivity);
         */
        return "profilepage";
    }

    @PostMapping("/registerRun")
    public String registerRun(HttpSession session, RunActivity runActivity, Model model) {
        user = (User) session.getAttribute("loggedUser");
        user.getActivitiesList().add(runActivity);
        userService.updateActivity(user);
        model.addAttribute("user", user);
        return "profilepage";
    }

    @PostMapping("/registerSwim")
    public String registerSwim(HttpSession session, SwimActivity swimActivity , Model model) {
        user = (User) session.getAttribute("loggedUser");
        user.getActivitiesList().add(swimActivity);
        userService.updateActivity(user);
        model.addAttribute("user", user);
        return "profilepage";
    }

    @PostMapping("/registerBike")
    public String registerBike(HttpSession session, BikeActivity bikeActivity, Model model) {
        user = (User) session.getAttribute("loggedUser");
        user.getActivitiesList().add(bikeActivity);
        userService.updateActivity(user);
        model.addAttribute("user", user);
        return "profilepage";
    }
    @PostMapping("/registerGolf")
    public String registerGolf(HttpSession session, GolfActivity golfActivity, Model model) {
        user = (User) session.getAttribute("loggedUser");
        user.getActivitiesList().add(golfActivity);
        userService.updateActivity(user);
        model.addAttribute("user", user);
        return "profilepage";
    }

    @PostMapping("/registerYoga")
    public String registerYoga(HttpSession session, YogaActivity yogaActivity, Model model) {
        user = (User) session.getAttribute("loggedUser");
        user.getActivitiesList().add(yogaActivity);
        userService.updateActivity(user);
        model.addAttribute("user", user);
        return "profilepage";
    }




}
