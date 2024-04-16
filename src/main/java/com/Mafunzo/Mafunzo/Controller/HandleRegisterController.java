package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.User;
import com.Mafunzo.Mafunzo.Model.XpSystem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HandleRegisterController {

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user){
        System.out.println("Register in spring");
        System.out.println("First Name: " + user.getFname());
        System.out.println("Last Name: " + user.getLname());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Password: " + user.getPassword());
        System.out.println("fkn Score lets go " + user.getEvaluationScore());

        XpSystem newXP = new XpSystem(0, 1, 0);

        User user1 = new User(newXP ,user.getFname(), user.getLname(), user.getEmail(), user.getPassword(), user.getEvaluationScore());

        System.out.println("User: ");
        System.out.println(user1.toString());


        System.out.println("Registration successful");
        return ResponseEntity.ok("{\"message\": \"Registration successful\"}");
    }

}
