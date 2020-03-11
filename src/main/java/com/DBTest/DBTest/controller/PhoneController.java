package com.DBTest.DBTest.controller;


import com.DBTest.DBTest.entity.Phone;
import com.DBTest.DBTest.service.ImplPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PhoneController {

    @Autowired
    ImplPhoneService implPhoneService;

    /**
     * ok
     *
     * @return
     */
    @GetMapping(value = "/phone/phones")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(implPhoneService.findAll(), HttpStatus.OK);
    }

    /**
     * ok
     *
     * @param phone_id
     * @return
     */
    @GetMapping(value = "/phone/phones/{phone_id}")
    public ResponseEntity<Object> findById(@PathVariable("phone_id") Long phone_id) {
        return new ResponseEntity<>(implPhoneService.findById(phone_id), HttpStatus.OK);
    }

    /**
     * ok
     *
     * @param phone
     * @return
     */
    @PostMapping(value = "/phone")
    public ResponseEntity<Object> addPhone(@RequestBody Phone phone) {
        return new ResponseEntity<>(implPhoneService.addPhone(phone), HttpStatus.OK);
    }

    /**
     * ok
     *
     * @param phone_id
     * @param phone
     * @return
     */
    @PutMapping(value = "/phone/update/{phone_id}")
    public ResponseEntity<Object> updatePhone(@PathVariable("phone_id") Long phone_id, @RequestBody Phone phone) {
        return new ResponseEntity<>(implPhoneService.updatePhone(phone_id, phone), HttpStatus.OK);
    }

    /**
     * ok
     *
     * @param phone_id
     * @return
     */
    @DeleteMapping(value = "/phone/delete/{phone_id}")
    public ResponseEntity<Object> deletePhone(@PathVariable("phone_id") Long phone_id) {
        return new ResponseEntity<>(implPhoneService.deleteById(phone_id), HttpStatus.OK);
    }


}
