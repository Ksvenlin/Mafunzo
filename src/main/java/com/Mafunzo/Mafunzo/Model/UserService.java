package com.Mafunzo.Mafunzo.Model;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public User getUserByEmail(String email){
        return userRepo.findByEmail(email).orElse(null);
    }
    @Transactional
    public User saveUser(User user){
        return userRepo.save(user);
    }
    @Transactional
    public User updateActivity(User user) {
        User existingUser = userRepo.findByEmail(user.getEmail()).orElse(null);
        if(existingUser != null) {
            existingUser.setActivitiesList(user.getActivitiesList());
            return userRepo.save(existingUser);
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
