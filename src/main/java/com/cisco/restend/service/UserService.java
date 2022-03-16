package com.cisco.restend.service;

import com.cisco.restend.model.ResDTO;
import com.cisco.restend.model.UserDTO;

public interface UserService {
    ResDTO saveUser(UserDTO userDTO);
    ResDTO getUser(String nic);
    ResDTO updateUser(UserDTO userDTO, String nic);
    ResDTO deleteUser(String nic);
}
