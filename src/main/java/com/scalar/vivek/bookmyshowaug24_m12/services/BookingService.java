package com.scalar.vivek.bookmyshowaug24_m12.services;

import com.scalar.vivek.bookmyshowaug24_m12.exceptions.InvalidUserIdException;
import com.scalar.vivek.bookmyshowaug24_m12.exceptions.ShowSeatNotAvailableException;
import com.scalar.vivek.bookmyshowaug24_m12.models.*;
import com.scalar.vivek.bookmyshowaug24_m12.repositories.BookingRepository;
import com.scalar.vivek.bookmyshowaug24_m12.repositories.ShowRepository;
import com.scalar.vivek.bookmyshowaug24_m12.repositories.ShowSeatRepository;
import com.scalar.vivek.bookmyshowaug24_m12.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.transaction.annotation.Isolation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private PriceCalculationService priceCalculationService;
    private BookingRepository bookingRepository;

    public BookingService(UserRepository userRepository,
                          ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository,
                          PriceCalculationService priceCalculationService,
                          BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculationService = priceCalculationService;
        this.bookingRepository = bookingRepository;

    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, Long showId, List<Long> showSeatIds) throws InvalidUserIdException {
        /*
        1. Get the user from the userid.
        2. Get the show from the showId.
        3. Get the list of show seats from the list of showSeatIds.
        4. Check if all the seats are available or not.
        -------TAKE A LOCK---------
        5. If no, throw an exception.
        6. If Yes, mark the seat as BLOCKED.
        7. Saved the status in the DB.
        -------RELEASE THE LOCK---------
        8. Create the booking object with PENDING status.
        9. Move to the Payment page.

         LOCK:
            Taking a lock in between a code is very difficult in SpringBoot. Long Procedure.
            Just for this implementation - we will take at method level.
            The same is expected in the Interview.
            We will take it at the start of method.
         */

        // 1. Get the user from the userid.
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()){
            throw new InvalidUserIdException("User with Id: "+ userId +" doesn't exist.");
        }
        User user = userOptional.get();

        // 2. Get the show from the showId.
        Optional<Show> showOptional = showRepository.findById(showId);
        if (showOptional.isEmpty()){
            throw new InvalidUserIdException("Show with id: " + showId + " doesn't exist.");
        }
        Show show = showOptional.get()

        //3. Get the list of show seats from the list of showSeatIds.
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);


        //4. Check if all the seats are available or not.
        //-------TAKE A LOCK---------
        //5. If no, throw an exception.
        for (ShowSeat showSeat : showSeats ){
            if (!showSeat.getShowSeatStatus().equals((ShowSeatStatus.AVAILABLE))){
                throw new ShowSeatNotAvailableException("ShowSeat with id: " + showSeat.getId() + " is not available.");
            }
        }

        List<ShowSeat> savedShowSeats = new ArrayList<>();

        //6. If Yes, mark the seat as BLOCKED.
        for (ShowSeat showSeat: showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            //7. Saved the status in the DB.
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }
        //-------RELEASE THE LOCK---------
        //8. Create the booking object with PENDING status.
        Booking booking = new Booking();
        booking.setBookedBy(user);
        booking.setBookedAt(new Date());
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShowSeat(savedShowSeats);
        booking.setAmount(priceCalculationService.calculatePrice(savedShowSeats, show));

        return bookingRepository.save(booking);

        //9. Move to the Payment page.
        //Call the PaymentService to Complete the payment for this booking.


    }
}
