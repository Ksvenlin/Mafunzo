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

/**
 * The FollowController handles the logic and mapping for the pages that handles the social interaction between users.
 * This includes the search page and the profile page of other users.
 */
@Controller
public class FollowController {
    @Autowired
    private UserService userService;

    /**
     * This method is used to recieve the mapping for the Profile page for the user that you can find by searching.
     * @param email the email of the user you're searching for
     * @param session the session of the user
     * @param model the model attribute from the backend
     * @return the html page
     * @author Adam Mheisen, Kasper Svenlin
     */
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


    /**
     * This method is used to search for a specific user in the Database.
     * If the user does not search or searches for nothing, it will return all the users in the Database.
     * @param search search parameter
     * @param session the session of the user
     * @param model the model attribute from the backend
     * @return the search page
     * @author Adam Mheisen, Kasper Svenlin
     */
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
