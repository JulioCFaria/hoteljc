package com.hoteljc.demo.service.serviceimpl;


import com.hoteljc.demo.dtos.EnderecoDtoIn;
import com.hoteljc.demo.dtos.UserDtoIn;
import com.hoteljc.demo.dtos.UserDtoOut;
import com.hoteljc.demo.exceptions.ResourceNotFoundException;
import com.hoteljc.demo.models.Endereco;
import com.hoteljc.demo.models.User;
import com.hoteljc.demo.service.CepService;
import com.hoteljc.demo.service.UserService;
import com.hoteljc.demo.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hoteljc.demo.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CepService cepService;


    @Override
    public UserDtoOut registerUser(UserDtoIn userDtoIn) {
        User existingUser = findByEmail(userDtoIn.getEmail());
        if (existingUser != null) {
            throw new RuntimeException("Usuário com este e-mail já existe");
        }
        EnderecoDtoIn enderecoDtoIn = cepService.findCep(userDtoIn.getCep());
        User user = userMapper.convertToEntity(userDtoIn);
        user.setName(userDtoIn.getName());
        user.setCpf(userDtoIn.getCpf());
        user.setEmail(userDtoIn.getEmail());
        user.setEndereco(fillEndereco(enderecoDtoIn));
        User savedUser = userRepository.save(user);
        return userMapper.convertToDtoOut(savedUser);
    }

    @Override
    public UserDtoOut findById(Long id) {
        return userMapper.convertToDtoOut(returnUser(id));
    }

    @Override
    public List<UserDtoOut> findAll() {
        return userMapper.toUserDto(userRepository.findAll());
    }

    @Override
    public UserDtoOut update(UserDtoIn userDtoIn, Long id) {
        User existingUser = returnUser(id);
        User userWithGivenEmail = findByEmail(userDtoIn.getEmail());

        if (!existingUser.getId().equals(userWithGivenEmail.getId())) {
            throw new RuntimeException("Usuario com email " + userDtoIn.getEmail() + " nao existe.");
        }

        userMapper.updateUser(existingUser, userDtoIn);
        return userMapper.convertToDtoOut(userRepository.save(existingUser));
    }

    public User findByIdAndValidate(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new RuntimeException("Usuário com ID " + id + " não encontrado");
        }
    }

    public String delete(Long id) {
        User user = findByIdAndValidate(id);
        userRepository.delete(user);
        return "Usuário deletado com sucesso";
    }

    @Override
    public User findByEmail(String email) {
        List<User> users = userRepository.findByEmail(email);
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    private User returnUser(Long id) {
        return userRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Usuario com ID " + id + " não encontrado."));
    }
    private User saveUser(UserDtoIn userDtoIn){

        User newUser = new User();
        newUser.setEmail(userDtoIn.getEmail());
        newUser.setName(userDtoIn.getName());
        newUser.setCpf(userDtoIn.getCpf());

        User savedUser = userRepository.save(newUser);
        return  savedUser;
    }

    private Endereco fillEndereco(EnderecoDtoIn enderecoDtoIn){
        Endereco enderecoDtoIn1 = new Endereco();
        enderecoDtoIn1.setCep(enderecoDtoIn.getCep());
        enderecoDtoIn1.setLogradouro(enderecoDtoIn.getLogradouro());
        enderecoDtoIn1.setBairro(enderecoDtoIn.getBairro());
        enderecoDtoIn1.setLocalidade(enderecoDtoIn.getLocalidade());
        enderecoDtoIn1.setUf(enderecoDtoIn.getUf());

        return enderecoDtoIn1;
    }
}
