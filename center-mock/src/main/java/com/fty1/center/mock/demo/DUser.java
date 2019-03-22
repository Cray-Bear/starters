package com.fty1.center.mock.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sys_user")
public class DUser {
    private String name;
    private int age;

    @Column(name = "address")
    private String address;
}
