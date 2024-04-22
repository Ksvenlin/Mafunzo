package com.Mafunzo.Mafunzo.Controller;


import com.Mafunzo.Mafunzo.Model.User;
import com.Mafunzo.Mafunzo.Model.UserService;
import com.Mafunzo.Mafunzo.Model.XpSystem;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userHandler {
    @Autowired
    UserService userService;

    /*
    Method for adding users to the database, this method calls for the userService which talks to the
    database.
    */

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user, Model model) {
        //User savedUser = userService.saveUser(user);
        User savedUser = userService.saveUser(new User(new XpSystem(user.getXp(), user.getLvl(), user.getStreak(), user.getInactiveDays(), user.getXpToLevel()), user.getFname(), user.getLname(), user.getEmail(), user.getPassword(), user.getEvaluationScore()));
        model.addAttribute("user", savedUser);
        return "profilepage";
    }

    /*
    Method for verifying the user who tries to log in.
    */

    @PostMapping("/verifyUser")
    public ResponseEntity<String> verifyUser(@RequestBody User user, HttpSession session) {
        User loggedUser = userService.getUserByEmail(user.getEmail());
        if (loggedUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"User not found\"}");
        } else if (!loggedUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Wrong password\"}");
        } else {
            session.setAttribute("loggedUser", loggedUser);
            return ResponseEntity.ok("{\"message\": \"Login successful\"}");
        }
    }
}
