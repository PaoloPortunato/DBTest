package com.DBTest.DBTest.mapper;

import com.DBTest.DBTest.DTO.PhoneDTO;
import com.DBTest.DBTest.DTO.UserDTO;
import com.DBTest.DBTest.entity.Phone;
import com.DBTest.DBTest.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring")
public interface ResourceMapper{

    @Mapping(target = "nome", source = "nomeDTO")
    @Mapping(target = "cognome", source = "cognomeDTO")
    User userDTOToUser(UserDTO userDTO);


    @Mapping(target = "nomeDTO", source = "nome")
    @Mapping(target = "cognomeDTO", source = "cognome")
    UserDTO userToUserDTO(User user);


    @Mapping(target = "numero", source = "numeroDTO")
    Phone phoneDTOtoPhone(PhoneDTO phoneDTO);


    @Mapping(target = "numeroDTO", source = "numero")
    PhoneDTO phoneTOPhoneDTO(Phone phone);

    @Mapping(target = "phoneDTOList", source = "phoneList")
    List<PhoneDTO> phoneDTOToList(User user);

    @Mapping(target = "phoneList", source = "phoneDTOList")
    List<Phone> phoneToListDTO(UserDTO userDTO);


    default List<UserDTO> listUserTOuserDTOList(List<User> userList) {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            userDTOList.add(userToUserDTO(user));
        }

        return userDTOList;
    }


}