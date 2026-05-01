package com.microservices.UserService.controller;

import com.microservices.UserService.VO.ResponseVO;
import com.microservices.UserService.model.User;
import com.microservices.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    private User createUserController(@RequestBody  User user){
        return userService.createUserService(user);
    }

    @GetMapping("/{id}")
    private ResponseVO getUserWithDepartmentController(@PathVariable("id") Long userId){
        return userService.getUserByIdService(userId);
    }

}
