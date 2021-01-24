package com.cucumber.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phone")
@Data
public class Phone {

    @Id
    private Long id;
    private String type;
    private String isdCode;
    private String phoneNumber;
    private String extension;
}
