package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.SearchUsers;
import com.Mafunzo.Mafunzo.Model.User;
import com.Mafunzo.Mafunzo.Model.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FollowController {
    @Autowired
    private UserService userService;

    @PostMapping("/followerUserPage")
    public String followerPage(@RequestParam(value = "email", required = false) String email, HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/index";
        }
        model.addAttribute("user", user);
        List<User> users = userService.getAllUsers();
        for (User tempUser : users) {
            if (tempUser.getEmail().equals(email)) {
                model.addAttribute("searchUser", tempUser);
                break;
            }
        }
        return "followUserPage";
    }


    @PostMapping("/search")
    public String search(@RequestParam(value = "search", required = false)String search, HttpSession session, Model model){
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/index";
        }
        model.addAttribute("user", user);
        SearchUsers searchUsers = new SearchUsers(userService.getAllUsers());
        if(search != null) {
            searchUsers = new SearchUsers(userService.searchUsers(search, search));
        }else {
            searchUsers = new SearchUsers(userService.getAllUsers());
        }
        model.addAttribute("searchUsers", searchUsers);

        return "searchPage";
    }

}
