package com.avinash.multidb.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString
@Entity
@Table(name = "company")
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String companyName;
    @Column(name = "contact")
    private String Contact;
    @Column(name = "email")
    private String companyEmail;
    @Column(name = "address")
    private String companyAddress;
}
