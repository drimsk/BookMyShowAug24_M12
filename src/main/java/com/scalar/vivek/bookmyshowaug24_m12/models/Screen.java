package com.scalar.vivek.bookmyshowaug24_m12.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{

    private String name;

    @OneToMany
    private List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> feature;
}


/*

    1         M
  Screen --- Seat => 1:M     =>  @OneToMany
    1         1

 */