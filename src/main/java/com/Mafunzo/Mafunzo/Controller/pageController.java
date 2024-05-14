package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.Activity.*;
import com.Mafunzo.Mafunzo.Model.User;
import jakarta.servlet.http.HttpSession;
// org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This Controller is responsible for the routing of the different pages in the application. It also checks if the user
 * is logged in or not. The model attributes are sent to the front end through thymeleaf methods. This enables the HTML front end
 * to access the data from the backend.
 */
@Controller
public class pageController {

    /**
     * This method is the first method that is called when the user enters the application. It returns the login page.
     *
     * @return index HTML filepath
     * @author William Starå
     */

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * This method is called when the user logs in or registers to route the user to the homepage
     *
     * @param model   the model attributes from the backend
     * @param session the session of the user to verify that the right user is logged in.
     * @return the homepage HTML filepath, returns the index file if the user is not logged in.
     * @author Adam Mheisen & Kevin Nordkvist
     */

    @GetMapping("/home")
    public String login(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/index";
        }
        model.addAttribute("user", user);
        return "homePage";
    }

    /**
     * This method is called when the user logs out. It removes the user from the session and redirects the user to the login page.
     *
     * @param session the session of the user to verify that the right user is logged in.
     * @return the login HTML filepath, return the user to the login page after logging out.
     * @author Adam Mheisen & Kevin Nordkvist
     */
    @GetMapping("/logOut")
    public String logOut(HttpSession session) {
        session.removeAttribute("loggedUser");
        return "redirect:/index";
    }

    /**
     * This method is called when the user wants to view their profile.
     * It checks if the user is logged in and then returns the profile page.
     *
     * @param session the session of the user to verify that the right user is logged in.
     * @param model   the model attributes from the backend
     * @return the profilepage HTML filepath, returns the index file if the user is not logged in.
     * @author Adam Mheisen & Kevin Nordkvist
     */
    @GetMapping("/profilepage")
    public String profile(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/index";
        }
        model.addAttribute("user", user);
        return "profilePage";
    }

    /**
     * This method is called when the user wants to register an activity.
     * It checks if the user is logged in and then returns the register activity page.
     *
     * @param model   the model attributes from the backend
     * @param session the session of the user to verify that the right user is logged in.
     * @return the registerActivity HTML filepath, returns the index file if the user is not logged in.
     * @author Kasper Svenlin & Isak Hakola
     */

    @GetMapping("/registerActivity")
    public String registerActivity(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/index";
        }
        model.addAttribute("user", user);
        return "registerActivity";
    }

    /**
     * This method is called when the user clicks on the "promenad" button on the register activity page.
     *
     * @param model   the model attributes from the backend
     * @param session the session of the user to verify that the right user is logged in.
     * @return the walkTraining HTML filepath, returns the index file if the user is not logged in
     * @author Svenlin & Isak Hakola
     */
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

    /**
     * This method is called when the user clicks on the "simning" button on the register activity page.
     *
     * @param model   the model attributes from the backend
     * @param session the session of the user to verify that the right user is logged in.
     * @return the swimTraining HTML filepath, returns the index file if the user is not logged in
     * @author Kasper Svenlin & Isak Hakola
     */
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

    /**
     * This method is called when the user clicks on the "cykling" button on the register activity page.
     *
     * @param model   the model attributes from the backend
     * @param session the session of the user to verify that the right user is logged in.
     * @return the bikeTraining HTML filepath, returns the index file if the user is not logged in
     * @author Kasper Svenlin & Isak Hakola
     */
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

    /**
     * This method is called when the user clicks on the "löpning" button on the register activity page.
     *
     * @param model   the model attributes from the backend
     * @param session the session of the user to verify that the right user is logged in.
     * @return the runTraining HTML filepath, returns the index file if the user is not logged in
     * @author Kasper Svenlin & Isak Hakola
     */
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

    /**
     * This method is called when the user clicks on the "golf" button on the register activity page.
     *
     * @param model   the model attributes from the backend
     * @param session the session of the user to verify that the right user is logged in.
     * @return the golfTraining HTML filepath, returns the index file if the user is not logged in
     * @author Kasper Svenlin & Isak Hakola
     */
    @GetMapping("/golfTraining")
    public String golfTraining(Model model, HttpSession session) {
        GolfActivity temp = new GolfActivity();
        model.addAttribute("golfActivity", temp);
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/index";
        }
        model.addAttribute("user", user);
        return "activities/golfTraining";
    }

    /**
     * This method is called when the user clicks on the "yoga" button on the register activity page.
     *
     * @param model   the model attributes from the backend
     * @param session the session of the user to verify that the right user is logged in.
     * @return the yogaTraining HTML filepath, returns the index file if the user is not logged in
     * @author Kasper Svenlin & Isak Hakola
     */
    @GetMapping("/yogaTraining")
    public String yogaTraining(Model model, HttpSession session) {
        model.addAttribute("yogaActivity", new YogaActivity());
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/index";
        }
        model.addAttribute("user", user);
        return "activities/yogaTraining";
    }

    /**
     * This method is called when the user clicks on the "stretch" button on the register activity page.
     *
     * @param model   the model attributes from the backend
     * @param session the session of the user to verify that the right user is logged in.
     * @return the stretchTraining HTML filepath, returns the index file if the user is not logged in
     * @author Kasper Svenlin & Isak Hakola
     */
    @GetMapping("/stretchTraining")
    public String stretchTraining(Model model, HttpSession session) {
        model.addAttribute("stretchActivity", new StretchActivity());
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/index";
        }
        model.addAttribute("user", user);
        return "activities/stretchTraining";
    }

    /**
     * This method is called when the user clicks on the "övrigt" button on the register activity page.
     *
     * @param model   the model attributes from the backend
     * @param session the session of the user to verify that the right user is logged in.
     * @return the otherTraining HTML filepath, returns the index file if the user is not logged in
     * @author Kasper Svenlin & Isak Hakola
     */
    @GetMapping("/otherTraining")
    public String otherTraining(Model model, HttpSession session) {
        model.addAttribute("otherActivity", new OtherActivity());
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/index";
        }
        model.addAttribute("user", user);
        return "activities/otherTraining";
    }

    /**
     * This method is called when the user clicks on the "styrketräning" button on the register activity page.
     *
     * @param model   the model attributes from the backend
     * @param session the session of the user to verify that the right user is logged in.
     * @return the strengthTraining HTML filepath, returns the index file if the user is not logged in
     * @author Kasper Svenlin & Isak Hakola
     */
    @GetMapping("/strengthTraining")
    public String strengthTraining(Model model, HttpSession session) {
        model.addAttribute("strengthTraining", new StrengthActivity());
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/index";
        }
        model.addAttribute("user", user);
        return "activities/strengthTraining";
    }
}
