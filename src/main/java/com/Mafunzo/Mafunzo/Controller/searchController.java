package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.User;
import com.Mafunzo.Mafunzo.Model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class searchController {

    @Autowired
    private UserService userService;

    private RedirectAttributes redirectAttributes;

    @PostMapping("/searchPage")
    public String searchRequest(@RequestParam("search") String searchTemp, Model model){
        List<User> users = userService.searchUsers(searchTemp);
        //redirectAttributes.addFlashAttribute("users", users);
        return "/searchPage";
    }
}
