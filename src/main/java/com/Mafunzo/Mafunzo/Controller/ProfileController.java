package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.XpSystem;
import org.springframework.ui.Model;
import com.Mafunzo.Mafunzo.Model.User;
import com.Mafunzo.Mafunzo.Model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.bson.Document;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {
    @Autowired
    UserService userService;
    User newUser = new User(new XpSystem(99.9, 3, 0, 0, 100), "Kevin", "Doe", "kevin@gmail.com", "password123");


    @GetMapping("/profilepage")
    public String profilePage(Model model) {
       User user = newUser;
        if (user == null) {
            return "userNotFound";
        }
        model.addAttribute("user", user);
        model.addAttribute("xp", user.getXp());
        model.addAttribute("lvl", user.getLvl());
        addUser(model);
        userDocument(user);
        return "profilepage";
    }

public Document userDocument(User user) {
        return new Document("name", user.getName())
                .append("email", user.getEmail())
                .append("password", user.getPassword());
    }

    @PostMapping("/addUser")
    public String addUser(Model model) {
        User newUser = new User(new XpSystem(99.9, 1, 0, 0, 100), "Kevin", "Doe", "kevin@gmail.com", "password123");
        User savedUser = userService.saveUser(newUser);
        model.addAttribute("user", savedUser);
        return "profilepage";
    }


}
