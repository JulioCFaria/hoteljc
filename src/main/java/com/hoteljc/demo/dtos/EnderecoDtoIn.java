package com.hoteljc.demo.dtos;


import lombok.Getter;

@Getter
public class EnderecoDtoIn {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }
}
