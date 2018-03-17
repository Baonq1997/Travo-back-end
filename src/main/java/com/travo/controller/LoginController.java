package com.travo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/api/auth")
    @ResponseBody
    public ResponseEntity authCheck() {
        return ResponseEntity.status(HttpStatus.OK).body("Logged in!");
    }
}
