package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.Activity.*;
import com.Mafunzo.Mafunzo.Model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageController {

    //Mapping for login page

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    //Mapping for the pages accessible from the navigation bar

    @GetMapping("/home")
    public String login() {
        return "homePage";
    }

    @GetMapping("/profilepage")
    public String profile(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/index";
        }
        model.addAttribute("user", user);
        return "profilepage";
    }

    @GetMapping("/registerActivity")
    public String registerActivity() {
        return "registerActivity";
    }

    //Mappings for rerouting the user to the correct page when clicking on the different activities

    @GetMapping("/strengthTraining")
    public String strengthTraining() {
        return "activities/strengthTraining";
    }

    @GetMapping("/walkTraining")
    public String walkTraining(Model model) {
        model.addAttribute("walkActivity", new WalkActivity());
        return "activities/walkTraining";
    }
    @GetMapping("/swimTraining")
    public String swimTraining(Model model) {
        model.addAttribute("swimActivity", new SwimActivity());
        return "activities/swimTraining";
    }
    @GetMapping("/bikeTraining")
    public String bikeTraining(Model model) {
        model.addAttribute("bikeActivity", new BikeActivity());
        return "activities/bikeTraining";
    }
    @GetMapping("/runTraining")
    public String runTraining(Model model) {
        model.addAttribute("runActivity", new RunActivity());
        return "activities/runTraining";
    }
    @GetMapping("/golfTraining")
    public String golfTraining(Model model) {
        model.addAttribute("golfActivity", new GolfActivity());
        return "activities/golfTraining";
    }

    @GetMapping("/yogaTraining")
    public String yogaTraining(Model model) {
        model.addAttribute("yogaActivity", new YogaActivity());
        return "activities/yogaTraining";
    }


}
