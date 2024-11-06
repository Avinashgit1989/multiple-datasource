package com.avinash.multidb.bean;

import com.avinash.multidb.bean.company.CompanyBean;
import com.avinash.multidb.bean.employee.EmployeeBean;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class RequestBean {
   private EmployeeBean employee;
   private CompanyBean company;
}
