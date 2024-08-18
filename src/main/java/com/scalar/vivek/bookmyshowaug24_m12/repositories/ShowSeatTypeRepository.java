package com.scalar.vivek.bookmyshowaug24_m12.repositories;

import com.scalar.vivek.bookmyshowaug24_m12.models.Show;
import com.scalar.vivek.bookmyshowaug24_m12.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
    List<ShowSeatType> findAllByShow(Show show);
}
