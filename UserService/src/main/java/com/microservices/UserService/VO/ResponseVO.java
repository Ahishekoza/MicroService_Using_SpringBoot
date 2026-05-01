package com.microservices.UserService.VO;


import com.microservices.UserService.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO {

    private User user;
    private Department department;

}
