package com.scalar.vivek.bookmyshowaug24_m12.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{
    private String name;
    @OneToMany
    private List<Screen> screens;
    @ManyToOne
    private Region region;
}



/*
        1           1
    Theatre ---- Region => M:1 => @ManyToOne
        M           1
 */