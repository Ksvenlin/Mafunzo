package com.Mafunzo.Mafunzo.Controller;


import com.Mafunzo.Mafunzo.Model.User;
import com.Mafunzo.Mafunzo.Model.UserService;
import com.Mafunzo.Mafunzo.Model.XpSystem;
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
        user.setXp(new XpSystem(99.9, 1, 0, 0, 100));

        //User newUser = new User(new XpSystem(99.9, 1, 0, 0, 100), "Kevin", "Doe", "kevin@gmail.com", "password123",0);
        User savedUser = userService.saveUser(user);
        model.addAttribute("user", savedUser);
        return "profilepage";
    }

    /*
    Method for verifying the user who tries to log in.
    */

    @PostMapping("/verifyUser")
    public ResponseEntity<String> verifyUser(@RequestBody User user) {
        if (userService.getUserByEmail(user.getEmail()) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"User not found\"}");
        } else if (!userService.getUserByEmail(user.getEmail()).getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Wrong password\"}");
        } else {
            return ResponseEntity.ok("{\"message\": \"Login successful\"}");
        }
    }
}
