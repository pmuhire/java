package com.example.selling.controllers;

import com.example.selling.dtos.SignUpDTO;
import com.example.selling.models.User;
import com.example.selling.payload.ApiResponse;
import com.example.selling.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/customers")
public class UserController {

    private final IUserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public UserController(IUserService userService,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping(path = "/current-user")
    public ResponseEntity<ApiResponse> currentlyLoggedInUser() {
        return ResponseEntity.ok(new ApiResponse(true, userService.getLoggedInUser()));
    }

    @PostMapping(path = "/register")
    public ResponseEntity<ApiResponse> registerAsStandard(@Valid @RequestBody SignUpDTO dto) {
        System.out.println(dto);

        User user = new User();

        String encodedPassword = bCryptPasswordEncoder.encode(dto.getPassword());

        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhoneNumber(dto.getMobile());
        user.setPassword(encodedPassword);

        User entity = this.userService.create(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, entity));
    }



    @GetMapping(path = "/routes/standard")
    public ResponseEntity<ApiResponse> standardRoute(){
        List<User> users= userService.getAllUsers();
        return ResponseEntity.ok(new ApiResponse(true,users));
    }
}