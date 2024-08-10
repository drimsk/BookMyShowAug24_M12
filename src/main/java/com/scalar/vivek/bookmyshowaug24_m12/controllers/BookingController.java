package com.scalar.vivek.bookmyshowaug24_m12.controllers;


import com.scalar.vivek.bookmyshowaug24_m12.dtos.BookingMovieRequestDto;
import com.scalar.vivek.bookmyshowaug24_m12.dtos.BookingMovieResponseDto;
import com.scalar.vivek.bookmyshowaug24_m12.services.BookingService;
import org.springframework.stereotype.Controller;


@Controller
public class BookingController {

    private BookingService bookingService;

    public BookingController (BookingService bookingService){
        this.bookingService = bookingService;
    }

    public BookingMovieResponseDto bookMovie(BookingMovieRequestDto requestDto){
        return null;
    }
}
