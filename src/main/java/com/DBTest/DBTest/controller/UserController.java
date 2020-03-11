package com.DBTest.DBTest.controller;

import com.DBTest.DBTest.DTO.PhoneDTO;
import com.DBTest.DBTest.DTO.UserDTO;
import com.DBTest.DBTest.service.ImplPhoneService;
import com.DBTest.DBTest.service.ImplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    ImplUserService implUserService;
    @Autowired
    ImplPhoneService implPhoneService;

    /**
     * ok
     *
     * @return
     */
    @GetMapping(value = "user/users")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(implUserService.findAll(), HttpStatus.OK);
    }

    /**
     * ok
     *
     * @param
     * @return
     */
    @GetMapping(value = "user/users/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(implUserService.findById(id), HttpStatus.OK);
    }

    /**
     * ok
     * phoneList = null
     *
     * @param
     * @return
     */
    @PostMapping(value = "user/")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(implUserService.addUser(userDTO), HttpStatus.OK);
    }

    /**
     * ok
     * modifica dati utente
     *
     * @param id
     * @param
     * @return
     */
    @PutMapping(value = "user/")
    public ResponseEntity<UserDTO> updateUser(@RequestParam Long id, @RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(implUserService.updateUser(id, userDTO), HttpStatus.OK);
    }

    /**
     * ok
     *
     * @param id
     * @param phone_id
     * @return
     */
    @PutMapping(value = "user/{id}/phone/{phone_id}")
    public ResponseEntity<UserDTO> updatePhoneNumber(@PathVariable(value = "id") Long id,
                                                     @PathVariable(value = "phone_id") Long phone_id,
                                                     @RequestBody PhoneDTO phoneDTO) {
        return new ResponseEntity<>(implUserService.updatePhoneNumber(id, phone_id, phoneDTO), HttpStatus.OK);
    }

    /**
     * @param
     * @return
     */
    @PostMapping(value = "user/{id}/phone")
    public ResponseEntity<UserDTO> createNumber(@PathVariable(value = "id") Long id, @RequestBody PhoneDTO phoneDTO) {
        return new ResponseEntity<>(implUserService.createNumber(id, phoneDTO), HttpStatus.OK);
    }

    /**
     * ok
     *
     * @param
     * @return
     */
    @DeleteMapping(value = "user/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") Long id, @RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(implUserService.deleteById(id, userDTO), HttpStatus.OK);
    }
}
