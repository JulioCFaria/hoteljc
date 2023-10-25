package com.hoteljc.demo.service.serviceimpl;

import com.hoteljc.demo.dtos.BookingDtoIn;
import com.hoteljc.demo.dtos.BookingDtoOut;
import com.hoteljc.demo.exceptions.ResourceNotFoundException;
import com.hoteljc.demo.models.Booking;
import com.hoteljc.demo.service.BookingService;
import com.hoteljc.demo.util.BookingMapper;
import com.hoteljc.demo.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hoteljc.demo.repository.BookingRepository;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private BookingMapper bookingMapper;
    @Autowired
    private Validation validation;

    @Override
    public BookingDtoOut registerBooking(BookingDtoIn bookingDtoIn) {
        validation.validateDateRange(bookingDtoIn.getDateArrival(), bookingDtoIn.getDateExit());
        Booking booking = bookingMapper.convertToEntity(bookingDtoIn);
        Booking savedBooking = bookingRepository.save(booking);
        return bookingMapper.convertToDTO(savedBooking);
    }

    @Override
    public BookingDtoOut findById(Long id) throws ResourceNotFoundException {
        return bookingMapper.convertToDTO(returnBooking(id));
    }

    @Override
    public List<BookingDtoOut> findAll() {
        return bookingMapper.toBookingDto(bookingRepository.findAll());
    }

    @Override
    public BookingDtoOut update(BookingDtoIn bookingDtoIn, Long id) {
        Booking booking = returnBooking(id);
        bookingMapper.updateBooking(booking, bookingDtoIn);
        return bookingMapper.convertToDTO(bookingRepository.save(booking));
    }

    @Override
    public String delete(Long id) {
        bookingRepository.deleteById(id);
        return "Reserva com ID " + id + " excluida com sucesso.";
    }

    private Booking returnBooking(Long id) {
        return bookingRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Reserva com ID " + id + " não encontrada."));
    }

}
