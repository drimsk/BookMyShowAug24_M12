package com.scalar.vivek.bookmyshowaug24_m12.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String seatNumber;
    private int row;
    private int col;
    @ManyToOne
    private SeatType seatType;
}

/*

    1         1
  Seat --- SeatType => M:1     =>  @ManyToOne
    M         1

 */