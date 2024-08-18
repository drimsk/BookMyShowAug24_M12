package com.scalar.vivek.bookmyshowaug24_m12.services;

import com.scalar.vivek.bookmyshowaug24_m12.models.Show;
import com.scalar.vivek.bookmyshowaug24_m12.models.ShowSeat;
import com.scalar.vivek.bookmyshowaug24_m12.models.ShowSeatType;
import com.scalar.vivek.bookmyshowaug24_m12.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculationService {

     public ShowSeatTypeRepository showSeatTypeRepository;

     public PriceCalculationService(ShowSeatTypeRepository showSeatTypeRepository){
          this.showSeatTypeRepository = showSeatTypeRepository;
     }


     public int caluclatePrice(List<ShowSeat> showSeats, Show show){
         //Get the ShowSeatType for Show
          List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
          int amount = 0;
          for (ShowSeat showSeat: showSeats){
               for (ShowSeatType showSeatType: showSeatTypes){
                    if (showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                         amount += showSeatType.getPrice();
                         break;
                    }
               }
          }
     }
}
