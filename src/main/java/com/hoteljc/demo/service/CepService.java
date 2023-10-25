package com.hoteljc.demo.service;


import com.hoteljc.demo.dtos.EnderecoDtoIn;

public interface CepService {
    EnderecoDtoIn findCep(String cep);
}
