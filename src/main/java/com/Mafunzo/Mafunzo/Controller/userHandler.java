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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
public class userHandler {
    @Autowired
    UserService userService;

    /*
    Method for adding users to the database, this method calls for the userService which talks to the
    database.
    */
    @PostMapping("/addUser")
    public String addUser(@RequestParam("fname") String fname, @RequestParam("lname") String lname, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("evaluationScore") int evaluationScore, @RequestParam("image") MultipartFile image, Model model) throws IOException {
        String imageString = Base64.getEncoder().encodeToString(image.getBytes());
        System.out.println("ImageString " + imageString);
        //User savedUser = userService.saveUser(user);
        //User savedUser = userService.saveUser(new User(new XpSystem(user.getXp(), user.getLvl(), user.getStreak(), user.getInactiveDays(), user.getXpToLevel()), user.getFname(), user.getLname(), user.getEmail(), user.getPassword(), user.getEvaluationScore()));
        User savedUser = userService.saveUser(new User(new XpSystem(0, 1, 0, 0, 100), fname, lname, email, password, evaluationScore, imageString));
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
