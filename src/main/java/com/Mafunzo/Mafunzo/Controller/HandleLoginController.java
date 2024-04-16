package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HandleLoginController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        User loginUser = new User(null, "John", "Doe", "hej@gmail.com", "password", 0);


        if(!loginUser.getEmail().equals(user.getEmail())) {
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
