package com.DBTest.DBTest.controller;

import com.DBTest.DBTest.entity.Phone;
import com.DBTest.DBTest.entity.User;
import com.DBTest.DBTest.service.ImplPhoneService;
import com.DBTest.DBTest.service.ImplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
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
     * @param id
     * @return
     */
    @GetMapping(value = "user/users/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(implUserService.findById(id), HttpStatus.OK);
    }

    /**
     * ok
     *phoneList = null
     * @param user
     * @return
     */
    @PostMapping(value = "user/")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(implUserService.addUser(user), HttpStatus.OK);
    }

    /**
     * ok
     *modifica dati utente
     * @param id
     * @param user
     * @return
     */
    @PutMapping(value = "user/")
    public ResponseEntity<Object> updateUser(@RequestParam Long id, @RequestBody User user) {
        return new ResponseEntity<>(implUserService.updateUser(id, user), HttpStatus.OK);
    }

    /**
     *ok
     * @param id
     * @param phone_id
     * @return
     */
    @PutMapping(value = "user/{id}/phone/{phone_id}")
    public ResponseEntity<User> updatePhoneNumber(@PathVariable(value = "id") Long id, @PathVariable(value = "phone_id") Long phone_id, @RequestBody Phone phone) {
        return new ResponseEntity<>(implUserService.updatePhoneNumber(id, phone_id, phone), HttpStatus.OK);
    }

    /**
     *
     * @param phone
     * @return
     */
    @PostMapping(value = "user/{id}/phone")
    public ResponseEntity<User> createNumber(@PathVariable(value = "id") Long id ,@RequestBody Phone phone) {
    return new ResponseEntity<>(implUserService.createNumber(id,phone),HttpStatus.OK);
    }

    /**
     * ok
     * @param user
     * @return
     */
    @DeleteMapping(value = "user/users/delete")
    public ResponseEntity<Object> deleteUser(@RequestBody User user) {
        return new ResponseEntity<>(implUserService.deleteById(user), HttpStatus.OK);
    }
}
