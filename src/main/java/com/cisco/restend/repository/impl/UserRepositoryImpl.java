package com.cisco.restend.repository.impl;

import com.cisco.restend.model.UserDTO;
import com.cisco.restend.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public String saveUser(UserDTO userDTO) {
        return null;
    }
}
