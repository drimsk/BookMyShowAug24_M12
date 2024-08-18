package com.scalar.vivek.bookmyshowaug24_m12.repositories;

import com.scalar.vivek.bookmyshowaug24_m12.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    List<ShowSeat> findAllById(List<Long> showSeatIds);

}
