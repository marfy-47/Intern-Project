package com.example.spring_intro;

import org.spring.intro.MUserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private final com.example.spring_intro.MUserService userService;
    private org.spring.intro.MUserDTO MUserDTO;

    public Controller(com.example.spring_intro.MUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/v1/user")
    public void saveUser(@RequestBody MUserDTO dto) {
        userService.save(MUserDTO);
    }

    @GetMapping("/api/v1/user/{id}")
    public ResponseEntity<org.spring.intro.MUserDTO> getUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("/")
    private ResponseEntity<String> Helloworld() {
        System.out.println("The data is inserted into the database");
        return ResponseEntity.ok("Ok");
    }

}