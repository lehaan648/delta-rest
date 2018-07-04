package com.delta.controller;

import com.delta.dto.DeltaUserDTO;
import com.delta.form.LoginForm;
import com.delta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Lakshit on 27-05-2018.
 */

@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/login")
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("")
    public ResponseEntity<?> login (@RequestBody @Valid LoginForm loginForm) {
        DeltaUserDTO deltaUserDTO = userService.validateLogin(loginForm);
        if (deltaUserDTO == null) {
            return new ResponseEntity<>("No User Found", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(deltaUserDTO, HttpStatus.OK);
    }
}
