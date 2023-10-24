package com.hoteljc.demo.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.hoteljc.demo.models.Booking;

import java.io.Serializable;
import java.time.LocalDate;

public class BookingDtoOut implements Serializable {
    Long id;
    Integer numPeoples;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate dateArrival;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate dateExit;

    public BookingDtoOut() {
    }

    public BookingDtoOut(Booking booking) {
        this.id = booking.getId();
        this.numPeoples=booking.getNumPeoples();
        this.dateArrival = booking.getDateArrival();
        this.dateExit = booking.getDateExit();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumPeoples() {
        return numPeoples;
    }

    public void setNumPeoples(Integer numPeoples) {
        this.numPeoples = numPeoples;
    }

    public LocalDate getDateArrival() {
        return dateArrival;
    }

    public void setDateArrival(LocalDate dateArrival) {
        this.dateArrival = dateArrival;
    }

    public LocalDate getDateExit() {
        return dateExit;
    }

    public void setDateExit(LocalDate dateExit) {
        this.dateExit = dateExit;
    }
}
