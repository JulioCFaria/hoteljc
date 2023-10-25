package com.hoteljc.demo.util;

import com.hoteljc.demo.dtos.UserDtoIn;
import com.hoteljc.demo.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.hoteljc.demo.repository.BookingRepository;
import com.hoteljc.demo.repository.UserRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class Validation {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;

    public void validateDateRange(LocalDate dateArrival, LocalDate dateExit) {
        if (dateArrival.isAfter(dateExit) || dateArrival.equals(dateExit)) {
            throw new IllegalArgumentException("A data de chegada deve ser anterior à data de saída.");
        }

        if (dateArrival.isBefore(LocalDate.now().plusDays(1))) {
            throw new IllegalArgumentException("A reserva deve ser feita com pelo menos um dia de antecedência.");
        }

        if (dateArrival.isAfter(LocalDate.now().plusDays(30))) {
            throw new IllegalArgumentException("A reserva não pode ser feita para uma data superior a 30 dias.");
        }

        List<Booking> overlappingBookings = bookingRepository.findOverlappingBookings(dateArrival, dateExit);
        if (!overlappingBookings.isEmpty()) {
            throw new IllegalArgumentException("Já existe uma reserva entre as datas de chegada e saída fornecidas.");
        }
        long daysBetween = ChronoUnit.DAYS.between(dateArrival, dateExit);
        if (daysBetween > 3) {
            throw new IllegalArgumentException("Não é possível efetuar reservas com mais de 3 dias de estadia.");
        }
    }
}
