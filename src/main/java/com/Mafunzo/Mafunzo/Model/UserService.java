package com.Mafunzo.Mafunzo.Model;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService is a class that is used to interact with the database and the UserRepo class.
 *
 * @Author Kevin Nordkvist, William Starå, Adam Mheisen & Isak Hakola
 */
@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email).orElse(null);
    }

    public List<User> getAllUsers() {
        return List.of(userRepo.findAll().toArray(new User[0]));
    }

    @Transactional
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Transactional
    public User updateActivity(User user) {
        User existingUser = userRepo.findByEmail(user.getEmail()).orElse(null);
        if (existingUser != null) {
            existingUser = user;
            return userRepo.save(existingUser);
        } else {
            throw new RuntimeException("User not found");
        }
    }
    public List<User> searchUsers(String fname, String lname) {
        return userRepo.findByFnameContainingIgnoreCaseOrLnameContainingIgnoreCase(fname, lname);
    }
}
