package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.*;
import com.Mafunzo.Mafunzo.Model.Activity.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Clock;
import java.time.LocalDateTime;

/**
 * This controller is used to retrieve information from the user and register the activity in the user's profile.
 */
@Controller
public class RegisterActivityController {
    @Autowired
    private UserService userService;

    private User user;
    @Autowired
    private XpController xpController;
    @Autowired
    private DayService dayService;

    /**
     * This method is used to register a walk activity in the user's profile, and sets the xp to the user based on the evaluation score
     *
     * @param session      the session of the user.
     * @param walkActivity The walk activity that the user wants to register.
     * @param model        the model that is used to send information to the view.
     * @return the HTML filepath of the profile page.
     * @author Kasper Svenlin & Isak Hakola
     */

    @PostMapping("/registerWalk")
    public String registerWalk(HttpSession session, WalkActivity walkActivity, Model model) {

        //Detta är temporärt för att testa och kommer tas bort Star
        walkActivity.setCaption("Gång Caption");
        //Slut
        processAndSaveUserActivity(walkActivity, (User) session.getAttribute("loggedUser"), model);
        return "profilePage";
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
        //Detta är temporärt för att testa och kommer tas bort Star
        runActivity.setCaption("Löpning Caption");
        //Slut
        processAndSaveUserActivity(runActivity, (User) session.getAttribute("loggedUser"), model);
        return "profilePage";
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
        //Detta är temporärt för att testa och kommer tas bort Star
        swimActivity.setCaption("Simning Caption");
        //Slut
        processAndSaveUserActivity(swimActivity, (User) session.getAttribute("loggedUser"), model);
        return "profilePage";
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
        //Detta är temporärt för att testa och kommer tas bort Star
        bikeActivity.setCaption("Cykel Caption");
        //Slut
        processAndSaveUserActivity(bikeActivity, (User) session.getAttribute("loggedUser"), model);
        return "profilePage";
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
        //Detta är temporärt för att testa och kommer tas bort Star
        golfActivity.setCaption("Golf Caption");
        //Slut
        processAndSaveUserActivity(golfActivity, (User) session.getAttribute("loggedUser"), model);

        return "profilePage";
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
        //Detta är temporärt för att testa och kommer tas bort Star
        yogaActivity.setCaption("Yoga Caption");
        //Slut
        if (add != null) {
            model.addAttribute("yogaActivity", (YogaActivity) addExercise(yogaActivity, (User) session.getAttribute("loggedUser"), model));
            return "activities/yogaTraining";
        } else if (register != null) {
            processAndSaveUserActivity(yogaActivity, (User) session.getAttribute("loggedUser"), model);
        }
        return "profilePage";
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

        //Detta är temporärt för att testa och kommer tas bort Star
        stretchActivity.setCaption("Stretching Caption");
        //Slut
        if (add != null) {
            model.addAttribute("stretchTraining", (StretchActivity) addExercise(stretchActivity, (User) session.getAttribute("loggedUser"), model));
            return "activities/stretchTraining";
        } else if (register != null) {
            processAndSaveUserActivity(stretchActivity, (User) session.getAttribute("loggedUser"), model);
        }
        return "profilePage";
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
        //Detta är temporärt för att testa och kommer tas bort Star
        strengthActivity.setCaption("Styrketräning Caption");
        //Slut
        if (add != null) {
            model.addAttribute("strengthTraining", (StrengthActivity) addExercise(strengthActivity, user = (User) session.getAttribute("loggedUser"), model));
            return "activities/strengthTraining";
        } else if (register != null) {
            processAndSaveUserActivity(strengthActivity, (User) session.getAttribute("loggedUser"), model);

        }
        return "profilePage";
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
    public String registerOther(HttpSession session, OtherActivity otherActivity, Model model) {
        otherActivity.setCaption("Övrig Caption");//Detta är temporärt för att testa och kommer tas bort Star
        processAndSaveUserActivity(otherActivity, (User) session.getAttribute("loggedUser"), model);
        return "profilePage";
    }

    /**
     * This method is used to process and save the user's activity in the user's profile.
     *
     * @param activity the activity that the user wants to register.
     * @param user     the user that wants to register the activity.
     * @param model    the model that is used to send information to the view.
     * @return the HTML filepath of the profile page.
     * @author Kasper Svenlin & Adam Mheisen
     */
    public void processAndSaveUserActivity(Activities activity, User user, Model model) {
        activity.setTimeStamp(dayService.getDay());
        user.getActivitiesList().add(activity);
        userService.updateActivity(xpController.registerXpToUser(user));
        model.addAttribute("user", user);
    }

    /**
     * This method is used to add an exercise to the activities that has multiple activities.
     *
     * @param activity the activity that the user wants to add an exercise to.
     * @param user     the user that wants to add the exercise.
     * @param model    the model that is used to send information to the view.
     * @return the activity with the added exercise.
     * @author Adam Mheisen, Kasper Svenlin
     */
    public Activities addExercise(Activities activity, User user, Model model) {
        model.addAttribute("user", user);
        Exercise tempExercise = new Exercise();
        activity.getExerciseList().add(tempExercise);
        for (int i = 0; i < activity.getExerciseList().size(); i++) {
            activity.getExerciseList().get(i).setExerciseNumber(i + 1);
        }
        return activity;
    }
}