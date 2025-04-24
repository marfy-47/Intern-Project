package com.example.spring_intro.Controller;

import com.example.spring_intro.Data.DTO.MUserDTO;
import com.example.spring_intro.Data.DTO.Entity.MUser;
import com.example.spring_intro.Service.MUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private final MUserService userService;
    private MUserDTO MUserDTO;

    public Controller(MUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/v1/user")
    public void saveUser(@RequestBody MUserDTO dto) {
        userService.save(MUserDTO);
    }

    @GetMapping("/api/v1/user/{id}")
    public MUser getUserById(@PathVariable("id") Long id) {
        return MUserService.findById(id);
    }

    @GetMapping("/")
    private ResponseEntity<String> Helloworld() {
        System.out.println("The data is inserted into the database");
        return ResponseEntity.ok("Ok");
    }

}