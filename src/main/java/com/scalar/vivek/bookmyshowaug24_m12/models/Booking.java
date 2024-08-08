package com.scalar.vivek.bookmyshowaug24_m12.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel {

    @ManyToOne
    private User bookedBy;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    @ManyToMany
    private List<ShowSeat> showSeat;

    private Date bookedAt;

    private int amount;

    @OneToMany
    private List<Payment> payments;
}
 /*
 Cardinality :
    1         1
 Booking --- User   => M :1     =>  @ManyToOne
    M         1

    1         M
  Booking --- ShowSeat => M:M     =>  @ManyToMany
    M         1

    1         M
  Booking --- Payment => M:M     =>  @OneToMany
    1         1

 */


/*
@Enumerated(EnumType.ORDINAL)
    > ENUMs will be stored in the Ordinal format.
    > Less Space in DB
    > Faster Search and other DB actions.
    > Meaning: All the values in the booking status will be
        stored in the DB ordered(Integer) fashion as provided.
        LIKE: 1     :     CONFIRMED
              2     :     PENDING,
              3     :     CANCELLED,

@Enumerated(EnumType.STRING)
    > Here th ENUMs will be stored as a String in the DB.
    > High Space taken in DB : Due to String type.
    > Slow Search and DB actions. Impact Performance.
 */