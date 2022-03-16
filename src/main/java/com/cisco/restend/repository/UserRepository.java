package com.cisco.restend.repository;

import com.cisco.restend.model.ResDTO;
import com.cisco.restend.model.UserDTO;

import java.util.List;

public interface UserRepository {
    Integer saveUser(UserDTO userDTO);
    List<String> getUser(String nic);
    Integer updateUser(UserDTO userDTO, String nic);
    Integer deleteUser(String nic);
}
