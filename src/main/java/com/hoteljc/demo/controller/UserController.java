package com.hoteljc.demo.controller;

import com.hoteljc.demo.dtos.UserDtoIn;
import com.hoteljc.demo.dtos.UserDtoOut;
import com.hoteljc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDtoOut> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<UserDtoOut>> findAll(){
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDtoIn userDtoIn) {
        try {
            UserDtoOut registeredUser = userService.registerUser(userDtoIn);
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDtoOut> updateUser (@RequestBody UserDtoIn userDtoIn, @PathVariable Long id){
        return ResponseEntity.ok().body(userService.update(userDtoIn, id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>delete(@PathVariable Long id){
        try{
            return ResponseEntity.ok().body(userService.delete(id));
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O Id "+id+" não pode ser deletado pois não existe");
        }
    }
}