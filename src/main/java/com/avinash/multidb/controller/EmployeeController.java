package com.avinash.multidb.controller;

import com.avinash.multidb.bean.RequestBean;
import com.avinash.multidb.model.Employee;
import com.avinash.multidb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/add" )
    public ResponseEntity<Employee> addEmployee(@RequestBody RequestBean requestBean){
       return employeeService.addEmployee(requestBean);
    }
}
