package com.user.service;

import com.user.model.User;
import com.user.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User userData, Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(userData.getName());
            user.setEmail(userData.getEmail());
            user.setPassword(userData.getPassword());
            // Set other fields if needed
            return userRepository.save(user);
        }
        return null;
    }

    public boolean deleteUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }
}
