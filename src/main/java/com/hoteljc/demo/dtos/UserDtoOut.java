package com.hoteljc.demo.dtos;

import com.hoteljc.demo.models.Endereco;
import com.hoteljc.demo.models.User;
public class UserDtoOut {
    Long id;
    String name;
    String email;
    String cpf;
    Endereco endereco;

    public UserDtoOut(User user) {
        this.id = user.getId();
        this.name=user.getName();
        this.cpf = user.getCpf();
        this.email= user.getEmail();
        this.endereco = user.getEndereco();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
