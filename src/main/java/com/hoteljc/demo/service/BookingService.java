package com.hoteljc.demo.service;


import com.hoteljc.demo.dtos.BookingDtoIn;
import com.hoteljc.demo.dtos.BookingDtoOut;

import java.util.List;

public interface BookingService {
    BookingDtoOut registerBooking(BookingDtoIn bookingDtoIn);
    BookingDtoOut findById(Long id);
    List<BookingDtoOut> findAll();
    BookingDtoOut update(BookingDtoIn bookingDtoIn, Long id);

    String delete(Long id);
}
