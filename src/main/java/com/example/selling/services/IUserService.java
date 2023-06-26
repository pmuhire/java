package com.example.selling.services;

import com.example.selling.models.User;

import java.util.List;

public interface IUserService {

    User create(User user);

    boolean isNotUnique(User user);

    void validateNewRegistration(User user);

    User getLoggedInUser();
    List<User> getAllUsers();

}