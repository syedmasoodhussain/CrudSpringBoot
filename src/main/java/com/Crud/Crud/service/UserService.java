package com.Crud.Crud.service;

import com.Crud.Crud.model.User;
import com.Crud.Crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // GetUser by Id
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Save or update user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Delete user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
