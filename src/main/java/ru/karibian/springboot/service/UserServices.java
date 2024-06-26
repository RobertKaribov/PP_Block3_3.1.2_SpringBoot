package ru.karibian.springboot.service;

import ru.karibian.springboot.model.User;

import java.util.List;

public interface UserServices {
    List<User> index();
    User show(int id);
    void save(User user);
    void update(int id, User updatedUser);
    void delete(int id);
}
