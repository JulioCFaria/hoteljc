package com.hoteljc.demo.dtos;

import com.hoteljc.demo.models.User;
import lombok.Getter;

@Getter
public class UserDtoOut {
    Long id;
    String name;
    String email;
    String cpf;
    EnderecoDtoOut endereco;

    public UserDtoOut(String name, String email,String cpf, EnderecoDtoOut endereco) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public UserDtoOut(User user) {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(EnderecoDtoOut endereco) {
        this.endereco = endereco;
    }
}
