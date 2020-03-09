package com.DBTest.DBTest.service;

import com.DBTest.DBTest.entity.Phone;

import java.util.List;

public interface IPhoneService {

    public List<Phone> findAll();

    public Phone findById(Long id);

    public Phone addPhone(Phone phone);

    public Phone updatePhone(Long id, Phone phone);

    public Phone deleteById(Long id);
}
