package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.Activity.WalkActivity;
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

    @GetMapping("/profile")
    public String profile() {
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

}
