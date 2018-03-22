package com.travo.service;

import com.travo.dto.SignupDTO;
import com.travo.model.User;
import com.travo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignupServiceImpl implements SignupService{
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public SignupServiceImpl(UserRepository userRepository,
                             BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User findUser(SignupDTO signupDTO) {
        return userRepository.findByUsername(signupDTO.getUsername());
    }

    @Override
    public User saveUser(SignupDTO signupDTO) {
        User user = new User();
        user.setUsername(signupDTO.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(signupDTO.getPassword()));
        user.setFullName(signupDTO.getFullName());
        return userRepository.save(user);
    }
}
