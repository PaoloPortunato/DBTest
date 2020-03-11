package com.DBTest.DBTest.DTO;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private String nomeDTO;
    private String cognomeDTO;
    private List<PhoneDTO> phoneDTOList;

    public UserDTO(String nomeDTO, String cognomeDTO,List<PhoneDTO> phoneDTOList){
        setNomeDTO(nomeDTO);
        setCognomeDTO(cognomeDTO);
        setPhoneDTOList(phoneDTOList);
    }



}
