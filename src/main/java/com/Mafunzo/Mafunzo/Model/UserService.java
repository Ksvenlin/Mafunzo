package com.Mafunzo.Mafunzo.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    public User getUserByEmail(String email){
        return userRepo.findByEmail(email).orElse(null);
    }
    public User saveUser(User user){
        return userRepo.save(user);
    }
}
