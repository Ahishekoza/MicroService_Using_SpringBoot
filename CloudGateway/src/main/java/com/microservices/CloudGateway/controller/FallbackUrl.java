package com.microservices.CloudGateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackUrl{

    @RequestMapping(value = "/user-fallback", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<String> userFallback(@RequestBody(required = false) Object object) {
        return new ResponseEntity<>("User Service is currently unavailable. Please try again later.",
                HttpStatus.SERVICE_UNAVAILABLE);
    }

    @RequestMapping(value = "/department-fallback", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<String> departmentFallback(@RequestBody(required = false) Object object) {
        return new ResponseEntity<>("Department Service is currently unavailable. Please try again later.",
                HttpStatus.SERVICE_UNAVAILABLE);
    }
}