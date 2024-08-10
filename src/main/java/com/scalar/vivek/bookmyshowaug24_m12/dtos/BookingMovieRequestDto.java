package com.scalar.vivek.bookmyshowaug24_m12.dtos;


import com.scalar.vivek.bookmyshowaug24_m12.models.ShowSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingMovieRequestDto {
    private Long userId;
    private Long showId;
    private List<Long> showSeatIds;
}
