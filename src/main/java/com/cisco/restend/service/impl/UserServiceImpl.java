package com.cisco.restend.service.impl;

import com.cisco.restend.model.ResDTO;
import com.cisco.restend.model.UserDTO;
import com.cisco.restend.repository.UserRepository;
import com.cisco.restend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResDTO saveUser(UserDTO userDTO) {
        return userRepository.saveUser(userDTO) > 0 ?
                new ResDTO(0, "user saved") :
                new ResDTO(1, "failed to save the user");
    }

    @Override
    public ResDTO getUser(String nic) {
        List<String> user = userRepository.getUser(nic);
        return !user.isEmpty() ?
                new ResDTO(0, "success", new UserDTO(user.get(0), user.get(1), user.get(2), user.get(3))) :
                new ResDTO(1, "failed to fetch the user");
    }

    @Override
    public ResDTO updateUser(UserDTO userDTO, String nic) {
        return userRepository.updateUser(userDTO, nic) > 0 ?
                new ResDTO(0, "user updated") :
                new ResDTO(1, "failed to update the user");
    }

    @Override
    public ResDTO deleteUser(String nic) {
        Integer integer = userRepository.deleteUser(nic);
        return userRepository.deleteUser(nic) > 0 ?
                new ResDTO(0, "deleted the user") :
                new ResDTO(1, "failed to delete the user");
    }
}
