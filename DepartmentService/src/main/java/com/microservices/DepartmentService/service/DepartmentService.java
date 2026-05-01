package com.microservices.DepartmentService.service;

import com.microservices.DepartmentService.model.Department;
import com.microservices.DepartmentService.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepo;

    public Department createDepartmentService( Department department){
       return departmentRepo.save(department);
    }

    public Department getDepartmentByIdService(Long departmentId){
        return departmentRepo.findById(departmentId)
                .orElseThrow(()-> new RuntimeException("Department Not Found"));
    }

}
