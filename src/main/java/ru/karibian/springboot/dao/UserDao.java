package ru.karibian.springboot.dao;

import ru.karibian.springboot.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAllUsers();
    User findUserById(int id);
    void saveUser(User user);
    void updateUser(int id, User updatedUser);
    void deleteUser(int id);
}
