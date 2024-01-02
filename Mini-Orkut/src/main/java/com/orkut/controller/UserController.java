package com.orkut.controller;

import com.orkut.exception.RecordNotFoundException;
import com.orkut.model.User;
import com.orkut.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")

public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/signUp")
    public ResponseEntity<User> signUp(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userServiceImpl.signUp(user), HttpStatus.CREATED);
    }

    @GetMapping("/signIn/{userEmailId}/{userPassword}")

    public ResponseEntity<Boolean> signIn(@PathVariable String userEmailId, @PathVariable String userPassword) {
        return ResponseEntity.ok(userServiceImpl.signIn(userEmailId, userPassword));
    }

    @GetMapping("/findById/{userId}")
    public ResponseEntity<Optional<User>> findById(@PathVariable int userId) {
        return ResponseEntity.ok(userServiceImpl.findById(userId));
    }

    @PutMapping("/upate")
    public ResponseEntity<User> update(@PathVariable int userId, @Valid @RequestBody User user) {
        User user1 = userServiceImpl.findById(userId).orElseThrow(() -> new RecordNotFoundException("User Id Does Not Found..."));

        user1.setUserName(user.getUserName());
        user1.setUserAddress(user.getUserAddress());
        user1.setUserDob(user.getUserDob());
        user1.setUserEmailId(user1.getUserEmailId());
        user1.setUserPassword(user1.getUserPassword());
        return new ResponseEntity<>(userServiceImpl.update(user1), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userServiceImpl.findAll());
    }

}
