package com.hoteljc.demo.dtos;

import com.hoteljc.demo.models.User;
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

    public EnderecoDtoOut getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDtoOut endereco) {
        this.endereco = endereco;
    }
}
