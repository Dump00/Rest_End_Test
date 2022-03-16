package com.cisco.restend.controller;

import com.cisco.restend.model.ResDTO;
import com.cisco.restend.model.UserDTO;
import com.cisco.restend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{nic}")
    public ResDTO getUser(@PathVariable String nic){
        return null;
    }

    @PostMapping
    public ResDTO saveUser(@RequestBody UserDTO userDTO){
        return null;
    }

    @PutMapping(value = "/{nic}")
    public ResDTO updateUser(@RequestBody UserDTO userDTO, @PathVariable String nic){
        return null;
    }

    @DeleteMapping(value = "/{nic}")
    public ResDTO deleteCustomer(@PathVariable String nic){
        return null;
    }
}
