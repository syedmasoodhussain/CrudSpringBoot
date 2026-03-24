package com.Crud.Crud.controller;

import com.Crud.Crud.service.UserService;
import com.Crud.Crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }


    @GetMapping("/test")
    public String testEndpoint() {
        return "Test endpoint is working!";
    }


@PutMapping("/{id}")
public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
    Optional<User> existingUser = userService.getUserById(id);
    if (!existingUser.isPresent()) {
        return ResponseEntity.notFound().build();
    }
    User u = existingUser.get();
    u.setName(user.getName());
    u.setEmail(user.getEmail());
    userService.saveUser(u);
    return ResponseEntity.ok(u);
}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User with ID " + id + " has been deleted.");
        // test branch protection
        //tested
    }
}