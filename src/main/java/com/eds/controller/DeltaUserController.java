package com.eds.controller;

import com.eds.repository.DeltaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/user")

@RestController
public class DeltaUserController {

    @Autowired
    DeltaUserRepository deltaUserRepository;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(deltaUserRepository.getAllusers(), HttpStatus.OK);
    }
}
