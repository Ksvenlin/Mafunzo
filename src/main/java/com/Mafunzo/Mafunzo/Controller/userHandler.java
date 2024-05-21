package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.User;
import com.Mafunzo.Mafunzo.Model.UserService;
import com.Mafunzo.Mafunzo.Model.XpHandler;
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
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * This class handles login, registration and verification of users.
 */
@RestController
public class userHandler {
    @Autowired
    UserService userService;

    /**
     * This method is used to add a user to the database. It checks if the email is already in use, if the password is valid and if the image is uploaded.
     *
     * @param fname           parameter for first name as a String
     * @param lname           parameter for last name as a String
     * @param email           parameter for email as a String
     * @param password        parameter for password as a String
     * @param evaluationScore parameter for evaluation score as an int
     * @param image           parameter for image as a MultipartFile
     * @param model           parameter for model as a Model
     * @return ResponseEntity<String> returns a message if the user was added or not. Returns error messages if needed.
     * @throws IOException
     * @author William Starå
     */

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestParam("fname") String fname, @RequestParam("lname") String lname, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("evaluationScore") int evaluationScore, @RequestParam("image") MultipartFile image, Model model) throws IOException {
        List<User> avalibleUsers = userService.getAllUsers();

        //Check if first name is empty
        if(fname.isEmpty()) {
            return ResponseEntity.status(HttpStatus.GONE).body("{\"message\": \"Du måste fylla i ett förnamn\"}");
        }

        //Check if last name is empty
        if(lname.isEmpty()) {
            return ResponseEntity.status(HttpStatus.LENGTH_REQUIRED).body("{\"message\": \"Du måste fylla i ett efternamn\"}");
        }

        /*
        Check if email is already in use and that it is valid
        Checking if match is found first since som premade users does not have a valid email
        */
        for (User user : avalibleUsers) {
            if (user.getEmail().equals(email)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\": \"Mejladressen används redan\"}");
            }
        }

        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\": \"Mejladressen är ogiltig\"}");
        }

        //Check if password is valid
        if (!Pattern.compile("(?=.*[A-Z])(?=.*[^A-Za-z0-9 ])(?=.*[!@#$%&*()_+=|<>?{}\\[\\]~-])").matcher(password).find() || password.length() < 8) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("{\"message\": \"Lösenordet är ogiltigt\"}");
        }

        //Check if image is uploaded
        if (image == null || image.isEmpty()) {
            return ResponseEntity.status(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE).body("{\"message\": \"Du måste ladda upp en profilbild\"}");
        }

        String imageString = Base64.getEncoder().encodeToString(image.getBytes());
        System.out.println("ImageString " + imageString);
        User savedUser = userService.saveUser(new User(new XpHandler(0, 1, 0, 0, 100), fname, lname, email, password, evaluationScore, imageString));
        model.addAttribute("user", savedUser);

        return ResponseEntity.ok("{\"message\": \"Inloggning lyckades!\"}");
    }

    /**
     * This method is used to verify a user when it logs in. It checks if the users email exists and then that the password is the same, if not
     * it throws back an error with a message.
     *
     * @param user    parameter for user as a User
     * @param session parameter for session as a HttpSession
     * @return ResponseEntity<String> returns a message if the user was verified or not. Returns an error message if not successful.
     * @author Adam Mheisen, Kevin Nordkvist, William Starå
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