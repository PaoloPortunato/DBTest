package com.DBTest.DBTest.service;

import com.DBTest.DBTest.entity.Phone;
import com.DBTest.DBTest.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImplPhoneService implements IPhoneService {

    @Autowired
    PhoneRepository phoneRepository;


    @Override
    public List<Phone> findAll() {
        List<Phone> phoneList = new ArrayList<>();
        for (Phone phone : phoneRepository.findAll()) {
            phoneList.add(phone);
        }
        return phoneList;
    }

    @Override
    public Phone findById(Long id) {
        return phoneRepository.findById(id).orElse(null);
    }

    @Override
    public Phone addPhone(Phone phone) {
        phoneRepository.save(phone);
        return phone;
    }

    @Override
    public Phone updatePhone(Long id, Phone newPhone) {
        Phone phone = phoneRepository.findById(id).orElse(null);
        settingsUser(phone, newPhone);
        phoneRepository.save(phone);
        return phone;
    }

    @Override
    public Phone deleteById(Long id) {
        Phone phone = phoneRepository.findById(id).orElse(null);
        phoneRepository.deleteById(id);
        return phone;
    }

    private void settingsUser(Phone phone, Phone newPhone) {
        phone.setNumero(newPhone.getNumero());
    }
}
