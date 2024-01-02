package com.orkut.service;

import com.orkut.model.User;
import com.orkut.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl {

    @Autowired

    public UserRepo userRepo;

    public User signUp(User user) {
        return userRepo.save(user);
    }

    public Optional<User> findById(int userId) {
        return userRepo.findById(userId);
    }

    public boolean signIn(String userEmailId, String userPassword) {
        boolean flag = false;
        for (User user : findAll()) {
            if (user.getUserEmailId().equals(userEmailId) && user.getUserPassword().equals(userPassword)) {
                flag = true;
            }
        }
        return flag;
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User update(User user) {
        return userRepo.save(user);
    }

}
