package com.DBTest.DBTest.service;

import com.DBTest.DBTest.DTO.PhoneDTO;
import com.DBTest.DBTest.DTO.UserDTO;
import com.DBTest.DBTest.entity.Phone;
import com.DBTest.DBTest.entity.User;

import java.util.List;

public interface IUserService {

    public List<UserDTO> findAll();

    public UserDTO findById(Long id);

    public UserDTO addUser(UserDTO userDTO);

    public UserDTO updateUser(Long id, UserDTO userDTO);

    public UserDTO deleteById(Long id, UserDTO userDTO);

    public UserDTO updatePhoneNumber(Long id, Long id_phone, PhoneDTO cellDTO);

    public UserDTO createNumber(Long id, PhoneDTO phoneDTO);
}
