package com.example.auditing.service;

import com.example.auditing.model.User;
import com.example.auditing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> login(User user) {
        return this.userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }
}
