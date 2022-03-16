package com.cisco.restend.repository;

import com.cisco.restend.model.UserDTO;

public interface UserRepository {
    String saveUser(UserDTO userDTO);
}
