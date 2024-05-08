package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.Activity.*;
import com.Mafunzo.Mafunzo.Model.User;
import com.Mafunzo.Mafunzo.Model.UserService;
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
    private XpController xpController = new XpController();
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
        walkActivity.setTimeStamp(LocalDateTime.now(Clock.systemDefaultZone()));
        user = (User) session.getAttribute("loggedUser");
        user.getActivitiesList().add(walkActivity);
        user = xpController.xpHandler(user);
        userService.updateActivity(user);
        model.addAttribute("user", user);
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
        runActivity.setTimeStamp(LocalDateTime.now(Clock.systemDefaultZone()));
        user = (User) session.getAttribute("loggedUser");
        user.getActivitiesList().add(runActivity);
        user = xpController.xpHandler(user);
        userService.updateActivity(user);
        model.addAttribute("user", user);
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
        swimActivity.setTimeStamp(LocalDateTime.now(Clock.systemDefaultZone()));
        user = (User) session.getAttribute("loggedUser");
        user.getActivitiesList().add(swimActivity);
        user = xpController.xpHandler(user);
        userService.updateActivity(user);
        model.addAttribute("user", user);
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
        bikeActivity.setTimeStamp(LocalDateTime.now(Clock.systemDefaultZone()));
        user = (User) session.getAttribute("loggedUser");
        user.getActivitiesList().add(bikeActivity);
        user = xpController.xpHandler(user);
        userService.updateActivity(user);
        model.addAttribute("user", user);
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
        golfActivity.setTimeStamp(LocalDateTime.now(Clock.systemDefaultZone()));
        user = (User) session.getAttribute("loggedUser");
        user.getActivitiesList().add(golfActivity);
        user = xpController.xpHandler(user);
        userService.updateActivity(user);
        model.addAttribute("user", user);
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
            yogaActivity.setTimeStamp(LocalDateTime.now(Clock.systemDefaultZone()));
            user = (User) session.getAttribute("loggedUser");
            user.getActivitiesList().add(yogaActivity);
            user = xpController.xpHandler(user);
            userService.updateActivity(user);
            model.addAttribute("user", user);
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
            stretchActivity.setTimeStamp(LocalDateTime.now(Clock.systemDefaultZone()));
            user = (User) session.getAttribute("loggedUser");
            user.getActivitiesList().add(stretchActivity);
            user = xpController.xpHandler(user);
            userService.updateActivity(user);
            model.addAttribute("user", user);
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
            strengthActivity.setTimeStamp(LocalDateTime.now(Clock.systemDefaultZone()));
            user = (User) session.getAttribute("loggedUser");
            user.getActivitiesList().add(strengthActivity);
            user = xpController.xpHandler(user);
            userService.updateActivity(user);
            model.addAttribute("user", user);
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
        //Detta är temporärt för att testa och kommer tas bort Star
        otherActivity.setCaption("Övrig Caption");
        //Slut
        //ZoneId zoneId = ZoneId.of("Europe/Paris");
        //ZonedDateTime now = ZonedDateTime.now(zoneId);
        //otherActivity.setTimeStamp(now);
        otherActivity.setTimeStamp(LocalDateTime.now(Clock.systemDefaultZone()));
        user = (User) session.getAttribute("loggedUser");
        user.getActivitiesList().add(otherActivity);
        user = xpController.xpHandler(user);
        userService.updateActivity(user);
        model.addAttribute("user", user);
        return "profilePage";
    }
}