package com.microservices.DepartmentService.controller;

import com.microservices.DepartmentService.model.Department;
import com.microservices.DepartmentService.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    private Department createDepartmentController(@RequestBody  Department department){
        return departmentService.createDepartmentService(department);
    }

    @GetMapping("/{id}")
    private Department getDepartmentByIdController(@PathVariable("id") Long departmentId){
        return departmentService.getDepartmentByIdService(departmentId);
    }
}
