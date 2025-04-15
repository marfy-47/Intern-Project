package org.demo;

import com.example.demo.MUserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MUserController {
    private final org.crud.MUserService userService;

    public MUserController(org.crud.MUserService userService) {
        this.userService = userService;
    }


    @PostMapping("/api/v1/user")
    public void saveUser(@RequestBody MUserDTO dto) {
        userService.save(dto);
    }

    @GetMapping("/api/v1/user/{id}")
    public ResponseEntity<MUserDTO> getUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("/")
    private ResponseEntity<String> helloworld() {
        System.out.println("Hello World");
        return ResponseEntity.ok("Hello World");
    }

}