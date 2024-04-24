package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.Activity.BikeActivity;
import com.Mafunzo.Mafunzo.Model.Activity.RunActivity;
import com.Mafunzo.Mafunzo.Model.Activity.SwimActivity;
import com.Mafunzo.Mafunzo.Model.Activity.WalkActivity;
import com.Mafunzo.Mafunzo.Model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.boot.Banner;
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
    public String login(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/index";
        }
        model.addAttribute("user", user);
        return "homePage";
    }

    @GetMapping("/logOut")
    public String logOut(HttpSession session) {
        session.removeAttribute("loggedUser");
        return "redirect:/index";
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
    public String registerActivity(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/index";
        }
        model.addAttribute("user", user);
        return "registerActivity";
    }

    //Mappings for rerouting the user to the correct page when clicking on the different activities

    @GetMapping("/strengthTraining")
    public String strengthTraining(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/index";
        }
        model.addAttribute("user", user);
        return "activities/strengthTraining";
    }

    @GetMapping("/walkTraining")
    public String walkTraining(Model model, HttpSession session) {
        model.addAttribute("walkActivity", new WalkActivity());
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/index";
        }
        model.addAttribute("user", user);
        return "activities/walkTraining";
    }

    @GetMapping("/swimTraining")
    public String swimTraining(Model model, HttpSession session) {
        model.addAttribute("swimActivity", new SwimActivity());
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/index";
        }
        model.addAttribute("user", user);
        return "activities/swimTraining";
    }

    @GetMapping("/bikeTraining")
    public String bikeTraining(Model model, HttpSession session) {
        model.addAttribute("bikeActivity", new BikeActivity());
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/index";
        }
        model.addAttribute("user", user);
        return "activities/bikeTraining";
    }

    @GetMapping("/runTraining")
    public String runTraining(Model model, HttpSession session) {
        model.addAttribute("runActivity", new RunActivity());
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/index";
        }
        model.addAttribute("user", user);
        return "activities/runTraining";
    }

}
