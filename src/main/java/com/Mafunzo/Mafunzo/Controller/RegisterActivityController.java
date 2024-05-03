package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.Activity.*;
import com.Mafunzo.Mafunzo.Model.User;
import com.Mafunzo.Mafunzo.Model.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * This controller is used to retrieve information from the user and register the activity in the user's profile.
 */
@Controller
public class RegisterActivityController {
    @Autowired
    private UserService userService;
    private User user;

    /**
     * This method is used to register a walk activity in the user's profile.
     *
     * @param session      the session of the user.
     * @param walkActivity The walk activity that the user wants to register.
     * @param model        the model that is used to send information to the view.
     * @return the HTML filepath of the profile page.
     * @author Kasper Svenlin & Isak Hakola
     */

    @PostMapping("/registerWalk")
    public String registerWalk(HttpSession session, WalkActivity walkActivity, Model model) {
        user = (User) session.getAttribute("loggedUser");
        user.getActivitiesList().add(walkActivity);
        userService.updateActivity(user);
        model.addAttribute("user", user);
        return "profilepage";
    }

    /**
     * This method is used to register a run activity in the user's profile.
     *
     * @param session     the session of the user.
     * @param runActivity an instance of the runActivity object.
     * @param model       the model that is used to send information to the view.
     * @return the HTML filepath of the profile page.
     * @author Kasper Svenlin & Isak Hakola
     */
    @PostMapping("/registerRun")
    public String registerRun(HttpSession session, RunActivity runActivity, Model model) {
        user = (User) session.getAttribute("loggedUser");
        user.getActivitiesList().add(runActivity);
        userService.updateActivity(user);
        model.addAttribute("user", user);
        return "profilepage";
    }

    /**
     * This method is used to register a swim activity in the user's profile.
     *
     * @param session      the session of the user.
     * @param swimActivity an instance of the swimActivity object.
     * @param model        the model that is used to send information to the view.
     * @return the HTML filepath of the profile page.
     * @author Kasper Svenlin & Isak Hakola
     */
    @PostMapping("/registerSwim")
    public String registerSwim(HttpSession session, SwimActivity swimActivity, Model model) {
        user = (User) session.getAttribute("loggedUser");
        user.getActivitiesList().add(swimActivity);
        userService.updateActivity(user);
        model.addAttribute("user", user);
        return "profilepage";
    }

    /**
     * This method is used to register a bike activity in the user's profile.
     *
     * @param session      the session of the user.
     * @param bikeActivity an instance of the bikeActivity object.
     * @param model        the model that is used to send information to the view.
     * @return the HTML filepath of the profile page.
     * @author Kasper Svenlin & Isak Hakola
     */
    @PostMapping("/registerBike")
    public String registerBike(HttpSession session, BikeActivity bikeActivity, Model model) {
        user = (User) session.getAttribute("loggedUser");
        user.getActivitiesList().add(bikeActivity);
        userService.updateActivity(user);
        model.addAttribute("user", user);
        return "profilepage";
    }

    /**
     * This method is used to register a golf activity in the user's profile.
     *
     * @param session      the session of the user.
     * @param golfActivity an instance of the golfActivity object.
     * @param model        the model that is used to send information to the view.
     * @return the HTML filepath of the profile page.
     * @author Kasper Svenlin & Isak Hakola
     */
    @PostMapping("/registerGolf")
    public String registerGolf(HttpSession session, GolfActivity golfActivity, Model model) {
        user = (User) session.getAttribute("loggedUser");
        user.getActivitiesList().add(golfActivity);
        userService.updateActivity(user);
        model.addAttribute("user", user);
        return "profilepage";
    }

    /**
     * This method is used to register a yoga activity in the user's profile.
     *
     * @param session      the session of the user.
     * @param register     a string that is used to check if the user wants to register the activity.
     * @param add          a string that is used to check if the user wants to add an exercise to the activity.
     * @param yogaActivity an instance of the yogaActivity object.
     * @param model        the model that is used to send information to the view.
     * @return the HTML filepath of the profile page. If the user wants to add an exercise, the method will return the yogaTraining HTML file.
     * @author Kasper Svenlin & Isak Hakola
     */
    @PostMapping("/registerYoga")
    public String registerYoga(HttpSession session, @RequestParam(required = false) String register, @RequestParam(required = false) String add, YogaActivity yogaActivity, Model model) {

        if (add != null) {
            user = (User) session.getAttribute("loggedUser");
            model.addAttribute("user", user);
            Exercise tempExercise = new Exercise();
            yogaActivity.getExerciseList().add(tempExercise);
            for (int i = 0; i < yogaActivity.getExerciseList().size(); i++) {
                yogaActivity.getExerciseList().get(i).setExerciseNumber(i + 1);
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

    /**
     * This method is used to register a stretching activity in the user's profile.
     *
     * @param session         the session of the user.
     * @param register        a string that is used to check if the user wants to register the activity.
     * @param add             a string that is used to check if the user wants to add an exercise to the activity.
     * @param stretchActivity an instance of the stretchActivity object.
     * @param model           the model that is used to send information to the view.
     * @return the HTML filepath of the profile page. If the user wants to add an exercise, the method will return the stretchTraining HTML file.
     * @author Kasper Svenlin & Kevin Nordkvist
     */
    @PostMapping("/registerStretching")
    public String registerStretching(HttpSession session, @RequestParam(required = false) String register, @RequestParam(required = false) String add, StretchActivity stretchActivity, Model model) {

        if (add != null) {
            user = (User) session.getAttribute("loggedUser");
            model.addAttribute("user", user);
            Exercise tempExercise = new Exercise();
            stretchActivity.getExerciseList().add(tempExercise);
            for (int i = 0; i < stretchActivity.getExerciseList().size(); i++) {
                stretchActivity.getExerciseList().get(i).setExerciseNumber(i + 1);
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

    /**
     * This method is used to register an "other" activity in the user's profile.
     *
     * @param session       the session of the user.
     * @param otherActivity an instance of the otherActivity object.
     * @param model         the model that is used to send information to the view.
     * @return the HTML filepath of the profile page.
     * @author Kasper Svenlin & Kevin Nordkvist
     */

    @PostMapping("/registerOther")
    public String registerSwim(HttpSession session, OtherActivity otherActivity, Model model) {
        user = (User) session.getAttribute("loggedUser");
        user.getActivitiesList().add(otherActivity);
        userService.updateActivity(user);
        model.addAttribute("user", user);
        return "profilepage";
    }

    /**
     * This method is used to register a strength training activity in the user's profile.
     *
     * @param session          the session of the user.
     * @param register         a string that is used to check if the user wants to register the activity.
     * @param add              a string that is used to check if the user wants to add an exercise to the activity.
     * @param strengthActivity an instance of the strengthActivity object.
     * @param model            the model that is used to send information to the view.
     * @return the HTML filepath of the profile page. If the user wants to add an exercise, the method will return the strengthTraining HTML file.
     * @author Kasper Svenlin & Kevin Nordkvist
     */

    @PostMapping("/registerStrength")
    public String registerStrength(HttpSession session, @RequestParam(required = false) String register, @RequestParam(required = false) String add, StrengthActivity strengthActivity, Model model) {

        if (add != null) {
            user = (User) session.getAttribute("loggedUser");
            model.addAttribute("user", user);
            Exercise tempExercise = new Exercise();
            strengthActivity.getExerciseList().add(tempExercise);
            for (int i = 0; i < strengthActivity.getExerciseList().size(); i++) {
                strengthActivity.getExerciseList().get(i).setExerciseNumber(i + 1);
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
