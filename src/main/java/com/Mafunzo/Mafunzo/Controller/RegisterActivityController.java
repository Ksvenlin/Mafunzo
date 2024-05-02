package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.Activity.*;
import com.Mafunzo.Mafunzo.Model.User;
import com.Mafunzo.Mafunzo.Model.UserService;
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
    public String registerYoga(HttpSession session, @RequestParam(required = false) String register, @RequestParam(required = false) String add, YogaActivity yogaActivity, Model model) {

        if (add != null) {
            user = (User) session.getAttribute("loggedUser");
            model.addAttribute("user", user);
            Exercise tempExercise = new Exercise();
            yogaActivity.getExerciseList().add(tempExercise);
            for(int i = 0; i < yogaActivity.getExerciseList().size(); i++ ){
                yogaActivity.getExerciseList().get(i).setExerciseNumber(i+1);
            }
            model.addAttribute("yogaActivity", yogaActivity);
            return "activities/yogaTraining";
        } else if (register != null) {
            user = (User) session.getAttribute("loggedUser");
            user.getActivitiesList().add(yogaActivity);
            userService.updateActivity(user);
            model.addAttribute("user", user);
        }
        return "profilepage";
    }
    @PostMapping("/registerStretching")
    public String registerStretching(HttpSession session, @RequestParam(required = false) String register, @RequestParam(required = false) String add, StretchActivity stretchActivity, Model model) {

        if (add != null) {
            user = (User) session.getAttribute("loggedUser");
            model.addAttribute("user", user);
            Exercise tempExercise = new Exercise();
            stretchActivity.getExerciseList().add(tempExercise);
            for(int i = 0; i < stretchActivity.getExerciseList().size(); i++ ){
                stretchActivity.getExerciseList().get(i).setExerciseNumber(i+1);
            }
            model.addAttribute("stretchTraining", stretchActivity);
            return "activities/stretchTraining";
        } else if (register != null) {
            user = (User) session.getAttribute("loggedUser");
            user.getActivitiesList().add(stretchActivity);
            userService.updateActivity(user);
            model.addAttribute("user", user);
        }
        return "profilepage";
    }

    @PostMapping("/registerOther")
    public String registerSwim(HttpSession session, OtherActivity otherActivity , Model model) {
        user = (User) session.getAttribute("loggedUser");
        user.getActivitiesList().add(otherActivity);
        userService.updateActivity(user);
        model.addAttribute("user", user);
        return "profilepage";
    }

    @PostMapping("/registerStrength")
    public String registerStrength(HttpSession session, @RequestParam(required = false) String register, @RequestParam(required = false) String add, StrengthActivity strengthActivity, Model model) {

        if (add != null) {
            user = (User) session.getAttribute("loggedUser");
            model.addAttribute("user", user);
            Exercise tempExercise = new Exercise();
            strengthActivity.getExerciseList().add(tempExercise);
            for(int i = 0; i < strengthActivity.getExerciseList().size(); i++ ){
                strengthActivity.getExerciseList().get(i).setExerciseNumber(i+1);
            }
            model.addAttribute("strengthTraining", strengthActivity);
            return "activities/strengthTraining";
        } else if (register != null) {
            user = (User) session.getAttribute("loggedUser");
            user.getActivitiesList().add(strengthActivity);
            userService.updateActivity(user);
            model.addAttribute("user", user);
        }
        return "profilepage";
    }
}
