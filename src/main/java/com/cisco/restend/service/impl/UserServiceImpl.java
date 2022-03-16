package com.cisco.restend.service.impl;

import com.cisco.restend.model.UserDTO;
import com.cisco.restend.repository.UserRepository;
import com.cisco.restend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String saveUser(UserDTO userDTO) {
        return userRepository.saveUser(userDTO);
    }
}
