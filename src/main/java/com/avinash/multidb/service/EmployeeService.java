package com.avinash.multidb.service;

import com.avinash.multidb.bean.RequestBean;
import com.avinash.multidb.model.Employee;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {

    ResponseEntity<Employee> addEmployee(RequestBean requestBean);
}
