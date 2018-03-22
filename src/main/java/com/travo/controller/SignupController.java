package com.travo.controller;

import com.travo.dto.SignupDTO;
import com.travo.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/signup")
public class SignupController {

    private SignupService signupService;

    @Autowired
    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity signupNewAccount(@RequestBody SignupDTO signupDTO) {
        if (signupService.findUser(signupDTO) == null) {
            signupService.saveUser(signupDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Signed up");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This username has been used");
    }
}
