package com.hoteljc.demo.util;


import com.hoteljc.demo.dtos.BookingDtoIn;
import com.hoteljc.demo.dtos.BookingDtoOut;
import com.hoteljc.demo.models.Booking;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookingMapper {

    public Booking convertToEntity(BookingDtoIn bookingDtoIn) {
        Booking booking = new Booking();
        booking.setDateArrival(bookingDtoIn.getDateArrival());
        booking.setDateExit(bookingDtoIn.getDateExit());
        booking.setNumPeoples(bookingDtoIn.getNumPeoples());
        return booking;
    }
    public BookingDtoOut convertToDTO(Booking booking) {
        return new BookingDtoOut(booking);
    }

    public List<BookingDtoOut> toBookingDto(List<Booking> bookingList) {
        return bookingList.stream().map(BookingDtoOut::new).collect(Collectors.toList());
    }

    public void updateBooking(Booking booking, BookingDtoIn bookingDtoIn){
        booking.setDateArrival(bookingDtoIn.getDateArrival());
        booking.setDateExit(bookingDtoIn.getDateExit());
        booking.setNumPeoples(bookingDtoIn.getNumPeoples());
    }
}

