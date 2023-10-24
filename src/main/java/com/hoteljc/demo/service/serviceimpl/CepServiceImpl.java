package com.hoteljc.demo.service.serviceimpl;


import com.hoteljc.demo.dtos.EnderecoDtoIn;
import com.hoteljc.demo.service.CepService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepServiceImpl implements CepService {

    @Override
    public EnderecoDtoIn findCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<EnderecoDtoIn> resp = restTemplate
                    .getForEntity(String.format("https://viacep.com.br/ws/%s/json/", cep),EnderecoDtoIn.class);
            return resp.getBody();
    }
}


