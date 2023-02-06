package com.avinash.multidb.service.impl;

import com.avinash.multidb.bean.RequestBean;
import com.avinash.multidb.model.Company;
import com.avinash.multidb.model.Employee;
import com.avinash.multidb.repositories.company.CompanyRepository;
import com.avinash.multidb.repositories.employee.EmployeeRepository;
import com.avinash.multidb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Override
    public ResponseEntity<Employee> addEmployee(RequestBean requestBean) {
        Employee employee = Employee.builder()
                .empName(requestBean.getEmployee().getName())
                .email(requestBean.getEmployee().getEmail())
                .empContact(requestBean.getEmployee().getContact())
                .empAddress(requestBean.getEmployee().getAddress()).build();
        Employee response = employeeRepository.save(employee);
        Company company = Company.builder()
                .companyName(requestBean.getCompany().getName())
                .companyEmail(requestBean.getCompany().getEmail())
                .Contact(requestBean.getCompany().getContact())
                .companyAddress(requestBean.getCompany().getAddress()).build();
        Company companyResponse = companyRepository.save(company);
        if (response!=null && response.getId()>0){
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        return  null;
    }
}
