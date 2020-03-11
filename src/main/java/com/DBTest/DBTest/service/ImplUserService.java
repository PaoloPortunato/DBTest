package com.DBTest.DBTest.service;

import com.DBTest.DBTest.DTO.PhoneDTO;
import com.DBTest.DBTest.DTO.UserDTO;
import com.DBTest.DBTest.entity.Phone;
import com.DBTest.DBTest.entity.User;
import com.DBTest.DBTest.mapper.ResourceMapper;
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
    @Autowired
    ResourceMapper resourceMapper;

    @Override
    public List<UserDTO> findAll() {
        List<User> userList = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            userList.add(user);
        }
        List<UserDTO> userListDTO = resourceMapper.listUserTOuserDTOList(userList);

        return userListDTO;
    }

    @Override
    public UserDTO findById(Long id) {
        return resourceMapper.userToUserDTO(userRepository.findById(id).orElse(null));
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        userRepository.save(resourceMapper.userDTOToUser(userDTO));
        return userDTO;
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO newUserDTO) {
        User user = userRepository.findById(id).orElse(null);
        settingsUser(user, newUserDTO);
        userRepository.save(user);
        return resourceMapper.userToUserDTO(user);
    }

    @Override
    public UserDTO deleteById(Long id, UserDTO userDTO) {
        User u = userRepository.findById(id).orElse(null);
        userRepository.deleteById(u.getId());
        return resourceMapper.userToUserDTO(u);
    }

    @Override
    public UserDTO updatePhoneNumber(Long id, Long id_phone, PhoneDTO cellDTO) {
        User user = userRepository.findById(id).orElse(null);
        for (Phone phone : user.getPhoneList()) {
            if (phone.getPhone_id().equals(id_phone)) {
                settingsPhoneNumber(phone, cellDTO);
                phoneRepository.save(phone);

            }
        }
        return resourceMapper.userToUserDTO(user);
    }

    @Override
    public UserDTO createNumber(Long id, PhoneDTO phoneDTO) {
        User user = userRepository.findById(id).orElse(null);
        user.getPhoneList().add(resourceMapper.phoneDTOtoPhone(phoneDTO));
        phoneRepository.save(resourceMapper.phoneDTOtoPhone(phoneDTO));
        return resourceMapper.userToUserDTO(user);
    }


    private void settingsPhoneNumber(Phone phone, PhoneDTO newPhoneDTO) {
        phone.setNumero(resourceMapper.phoneDTOtoPhone(newPhoneDTO).getNumero());
    }

    private void settingsUser(User user, UserDTO newUserDTO) {
        user.setNome(resourceMapper.userDTOToUser(newUserDTO).getNome());
        user.setCognome(resourceMapper.userDTOToUser(newUserDTO).getCognome());
    }



}
