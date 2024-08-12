package ru.karibian.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.karibian.springboot.dao.UserDao;
import ru.karibian.springboot.model.User;

import java.util.List;

@Service
public class UserServicesImpl implements UserServices {

    private UserDao userDao;

    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    @Transactional(readOnly = true)
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Transactional
    public void createUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional
    public void updateUser(int id, User updatedUser) {
        userDao.updateUser(id, updatedUser);
    }

    @Transactional
    public void deleteUserById(int id) {
        userDao.deleteUser(id);
    }
}
