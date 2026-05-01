package com.microservices.UserService.service;

import com.microservices.UserService.VO.Department;
import com.microservices.UserService.VO.ResponseVO;
import com.microservices.UserService.model.User;
import com.microservices.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User createUserService(User user){
        return userRepository.save(user);
    }

    public ResponseVO getUserByIdService(Long userId){


        User user  = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found with id: "+userId));

//        --- RestTemplate Call
        Department department = restTemplate.getForObject
                ("http://localhost:9001/department/"+user.getDepartmentId(), Department.class);


        ResponseVO responseVO  = new ResponseVO();
        responseVO.setUser(user);
        responseVO.setDepartment(department);

        return responseVO;

    }
}
