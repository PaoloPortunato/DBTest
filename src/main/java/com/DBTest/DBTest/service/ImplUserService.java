package com.DBTest.DBTest.service;

import com.DBTest.DBTest.entity.Phone;
import com.DBTest.DBTest.entity.User;
import com.DBTest.DBTest.repository.PhoneRepository;
import com.DBTest.DBTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImplUserService implements IUserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PhoneRepository phoneRepository;

    @Override
    public List<User> findAll() {

        List<User> userList = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            userList.add(user);
        }
        return userList;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(Long id, User newUser) {
        User user = userRepository.findById(id).orElse(null);
        settingsUser(user, newUser);
        userRepository.save(user);
        return user;
    }

    @Override
    public User deleteById(User user) {
        User u = userRepository.findById(user.getId()).orElse(null);
        userRepository.deleteById(u.getId());
        return user;
    }

    @Override
    public User updatePhoneNumber(Long id, Long id_phone, Phone cell) {
        User user = findById(id);
        for (Phone phone : user.getPhoneList()) {
            if (phone.getPhone_id().equals(id_phone)) {
                settingsPhoneNumber(phone, cell);
                phoneRepository.save(phone);

            }
        }
        return user;
    }

    @Override
    public User createNumber(Long id, Phone phone) {
      User user = findById(id);
      user.getPhoneList().add(phone);
      phoneRepository.save(phone);
        return user;
    }


    private void settingsPhoneNumber(Phone phone, Phone newPhone) {
        phone.setNumero(newPhone.getNumero());
    }

    private void settingsUser(User user, User newUser) {
        user.setNome(newUser.getNome());
        user.setCognome(newUser.getCognome());
    }


}
