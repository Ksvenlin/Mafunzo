package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.XpSystem;
import com.Mafunzo.Mafunzo.Model.User;
import com.Mafunzo.Mafunzo.Model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.bson.Document;


@Controller
public class ProfileController {
    @Autowired
    UserService userService;
    User newUser = new User(new XpSystem(99.9, 3, 0, 0, 100), "Kevin", "Doe", "kevin@gmail.com", "password123", 0);

public Document userDocument(User user) {
        return new Document("name", user.getName())
                .append("email", user.getEmail())
                .append("password", user.getPassword());
    }

}
