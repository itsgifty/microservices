package com.itsgifty.department.controller;

import com.itsgifty.department.entity.Department;
import com.itsgifty.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/")
    public Department saveDepartment (@RequestBody Department department){
       log.info("inside save dept method of dept controller");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId){
        log.info("inside get dept method of dept controller");
        return departmentService.findDepartmentById(departmentId);
    }
}
