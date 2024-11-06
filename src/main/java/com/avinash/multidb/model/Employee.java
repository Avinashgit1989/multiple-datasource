package com.avinash.multidb.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString
@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String empName;
    @Column(name = "contact")
    private String empContact;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String empAddress;
}
