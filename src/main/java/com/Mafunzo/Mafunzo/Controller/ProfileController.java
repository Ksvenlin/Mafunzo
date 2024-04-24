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
    private UserService userService;
    private User user;

}
