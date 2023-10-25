package com.hoteljc.demo.dtos;


public class UserDtoIn {
    String id;
    String name;
    String cpf;
    String email;
    String cep;

    public UserDtoIn(String id, String name, String cpf, String email, String cep) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.cep = cep;
    }

    public UserDtoIn() {
    }

    public String getName() {

        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
