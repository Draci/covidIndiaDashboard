package com.covidindia.covidIndiaDashboard.service;

import com.covidindia.covidIndiaDashboard.model.User;

public interface UserService {

    public User findUserByEmail(String email);

    public void saveUser(User user);
}