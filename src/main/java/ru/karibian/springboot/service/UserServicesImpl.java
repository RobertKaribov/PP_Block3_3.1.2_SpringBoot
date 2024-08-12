package ru.karibian.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.karibian.springboot.dao.UserDao;
import ru.karibian.springboot.model.User;

import java.util.List;

@Service
@Transactional
public class UserServicesImpl implements UserServices {

    private final UserDao userDao;

    @Autowired
    public UserServicesImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    public void createUser(User user) {
        userDao.saveUser(user);
    }

    public void updateUser(int id, User updatedUser) {
        userDao.updateUser(id, updatedUser);
    }

    public void deleteUserById(int id) {
        userDao.deleteUser(id);
    }
}