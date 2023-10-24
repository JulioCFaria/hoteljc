package com.hoteljc.demo.dtos;

import lombok.Getter;

@Getter
public class UserDtoIn {
    String name;
    String cpf;
    String email;
    String cep;

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
