package com.scalar.vivek.bookmyshowaug24_m12.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;

}


/*
    1          1
 ShowSeat --- Show => M:1 => @ManyToOne
    M          1


    1          1
 ShowSeat --- Seat => M :1 => @ManyToOne
    M          1

 */