package com.scalar.vivek.bookmyshowaug24_m12.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;

    private Date startTime;

    private Date endTime;

    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> feature;
}


/*
 1         1
Show --- Movie => M:1   => @ManyToOne
 M         1

 1         1
Show --- Screen => 1:M   => @ManyToOne
 M         1
 */