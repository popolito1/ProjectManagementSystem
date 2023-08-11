package com.projectmanagementsystem.controllers;

import java.util.List;
import java.util.Optional;

import com.projectmanagementsystem.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.projectmanagementsystem.models.UserModel;
import com.projectmanagementsystem.security.services.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController( UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public String createUser(@RequestBody UserModel user){
        userService.saveUser(user);
        return "New user is added";
    }

    @GetMapping("/all")
    public MessageResponse allAccess() {
        return new MessageResponse("Server is up.....");
    }

    @GetMapping("/greeting")
    @PreAuthorize("isAuthenticated()")
    public MessageResponse userAccess() {

        return new MessageResponse
                ("Congratulations! You are an authenticated user.");
    }

    @GetMapping
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public Optional<UserModel> getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }
}
/*    @PutMapping("/{userId}")
    public ResponseEntity<UserModel> updateUser(@PathVariable int userId, @RequestBody UserModel user) {
        // Set the userId to ensure that the correct user is updated.
        user.setUserId(userId);
        UserModel updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }*/