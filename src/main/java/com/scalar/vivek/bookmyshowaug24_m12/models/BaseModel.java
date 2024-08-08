package com.scalar.vivek.bookmyshowaug24_m12.models;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private Date lastModifiedAt;

}
/*
* @MappedSuperClass: <What it does?>
*       Don't Create the table for ParentClass, But every Child Class
*       table will get attribute from the Parent Class.
*
*
* @Id       > This is the Annotations to Set the PrimaryKey in the DB Table
* @GeneratedValue(strategy = GenerationType.IDENTITY)
*           > This Annotation will define the PrimaryKey : @Id will AutoIncrement everytime.
* */