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
    public ResponseEntity<String> verifyUser(@RequestBody User user, Model model) {
        /*
        Denna loginuser ska vara en user som finns i databasen så den ska kalla på databasen och jämföra om det finns
        en user med samma email och lösenord som den som försöker logga in.
        */
        User loginUser = new User(null, "John", "Doe", "hej@gmail.com", "password", 0);

        if (!loginUser.getEmail().equals(user.getEmail())) {
            System.out.println("Login failed");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"User not found\"}");
        } else if (!loginUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Wrong password\"}");
        } else {
            System.out.println("Login successful");
            return ResponseEntity.ok("{\"message\": \"Login successful\"}");
        }
    }

}
