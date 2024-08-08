package com.scalar.vivek.bookmyshowaug24_m12.models;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//city class
@Getter
@Setter
@Entity
public class Region extends BaseModel{
    private String name;
    private List<Theatre> theatre;
}