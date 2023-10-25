package com.hoteljc.demo.controller;

import com.hoteljc.demo.dtos.BookingDtoIn;
import com.hoteljc.demo.dtos.BookingDtoOut;
import com.hoteljc.demo.exceptions.ResourceNotFoundException;
import com.hoteljc.demo.service.BookingService;
import com.hoteljc.demo.util.BookingMapper;
import com.hoteljc.demo.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.hoteljc.demo.repository.BookingRepository;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private Validation validation;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(bookingService.findById(id));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<BookingDtoOut>> findAll() {
        return ResponseEntity.ok().body(bookingService.findAll());
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody BookingDtoIn bookingDtoIn) {
        try {
            if (bookingDtoIn.getDateArrival() != null) {
                BookingDtoOut bookingDtoOut = bookingService.registerBooking(bookingDtoIn);
                URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(bookingDtoOut.getId())
                        .toUri();
                return ResponseEntity.created(location).body(bookingDtoOut);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de chegada é nula.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<BookingDtoOut> update(@RequestBody BookingDtoIn bookingDtoIn, @PathVariable Long id) {
        return ResponseEntity.ok().body(bookingService.update(bookingDtoIn, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try{
            return ResponseEntity.ok().body(bookingService.delete(id));
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O Id "+id+" não pode ser deletado pois não existe");
        }
    }

}