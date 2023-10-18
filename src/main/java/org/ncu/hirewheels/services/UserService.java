package org.ncu.hirewheels.services;

import java.util.Optional;

import org.ncu.hirewheels.entities.User;

public interface UserService {
    User createUser(User user);
    User getUser(String email, String password);
}