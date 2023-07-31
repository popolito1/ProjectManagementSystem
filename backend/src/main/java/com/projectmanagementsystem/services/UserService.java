package com.projectmanagementsystem.services;

import com.projectmanagementsystem.models.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public UserModel saveUser(UserModel user);
    public List<UserModel> getAllUsers();
    public Optional<UserModel> getUserById(int userID);
}
