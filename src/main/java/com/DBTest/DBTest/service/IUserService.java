package com.DBTest.DBTest.service;

import com.DBTest.DBTest.entity.Phone;
import com.DBTest.DBTest.entity.User;

import java.util.List;

public interface IUserService {

    public List<User> findAll();

    public User findById(Long id);

    public User addUser(User user);

    public User updateUser(Long id, User user);

    public User deleteById(User user);

    public User updatePhoneNumber(Long id, Long id_phone, Phone cell);

    public User createNumber(Long id, Phone phone);
}
