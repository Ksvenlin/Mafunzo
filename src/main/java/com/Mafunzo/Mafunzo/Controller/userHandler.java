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
import java.util.List;
import java.util.regex.Pattern;

@RestController
public class userHandler {
    @Autowired
    UserService userService;

    /*
    Method for adding users to the database, this method calls for the userService which talks to the
    database.
    */

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestParam("fname") String fname, @RequestParam("lname") String lname, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("evaluationScore") int evaluationScore, @RequestParam("image") MultipartFile image, Model model) throws IOException {
        List<User> avalibleUsers = userService.getAllUsers();

        if (image == null || image.isEmpty()) {
            return ResponseEntity.status(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE).body("{\"message\": \"Du måste ladda upp en profilbild\"}");
        }

        for (User user : avalibleUsers) {
            if (user.getEmail().equals(email)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\": \"Mejladressen används redan\"}");
            }
        }

        if (!Pattern.compile("(?=.*[A-Z])(?=.*[^A-Za-z0-9 ])(?=.*[!@#$%&*()_+=|<>?{}\\[\\]~-])").matcher(password).find() || password.length() < 8) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("{\"message\": \"Lösenordet är ogiltigt\"}");
        }

        String imageString = Base64.getEncoder().encodeToString(image.getBytes());
        System.out.println("ImageString " + imageString);
        User savedUser = userService.saveUser(new User(new XpSystem(0, 1, 0, 0, 100), fname, lname, email, password, evaluationScore, imageString));
        model.addAttribute("user", savedUser);

        return ResponseEntity.ok("{\"message\": \"Inloggning lyckades!\"}");
    }

    /*
    Method for verifying the user who tries to log in.
    */

    @PostMapping("/verifyUser")
    public ResponseEntity<String> verifyUser(@RequestBody User user, HttpSession session) {
        User loggedUser = userService.getUserByEmail(user.getEmail());
        if (loggedUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Användaren hittades inte :/\"}");
        } else if (!loggedUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Fel lösenord :/\"}");
        } else {
            session.setAttribute("loggedUser", loggedUser);
            return ResponseEntity.ok("{\"message\": \"Inloggningen lyckades!\"}");
        }
    }
}