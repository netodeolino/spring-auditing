package com.example.auditing.controller;

import com.example.auditing.model.User;
import com.example.auditing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<User> listAll() {
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        Optional<User> optionalUser = this.userService.login(user);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(this.userService.getJWTToken(user.getName()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
