package com.hoteljc.demo.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_booking")
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name="num_peoples",nullable = false)
    Integer numPeoples;
    @Column(name="date_arrival",nullable = false)
    LocalDate dateArrival;
    @Column(name="date_exit",nullable = false)
    LocalDate dateExit;

    @ManyToOne
    @JoinColumn(name= "user_id",nullable = true)
    private User user;

    public Booking() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public LocalDate getDateArrival() {
        return dateArrival;
    }

    public Integer getNumPeoples() {
        return numPeoples;
    }

    public void setNumPeoples(Integer numPeoples) {
        this.numPeoples = numPeoples;
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
