package org.example.custom.valid.controller;

import org.example.custom.valid.request.AddUserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * TODO
 *
 * @author gongmin
 * @date 2023/5/17 8:39
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/add")
    public String addUser(@Valid @RequestBody AddUserRequest request) {
        return "ok";
    }
}
