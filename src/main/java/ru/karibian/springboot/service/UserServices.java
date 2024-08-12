package ru.karibian.springboot.service;

import ru.karibian.springboot.model.User;

import java.util.List;

public interface UserServices {
    List<User> findAllUsers();
    User findUserById(int id);
    void createUser(User user);
    void updateUser(int id, User updatedUser);
    void deleteUserById(int id);
}
