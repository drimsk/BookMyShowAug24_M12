package com.scalar.vivek.bookmyshowaug24_m12.repositories;

import com.scalar.vivek.bookmyshowaug24_m12.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
