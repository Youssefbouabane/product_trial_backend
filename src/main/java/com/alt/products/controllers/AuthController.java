package com.alt.products.controllers;

import com.alt.products.dto.LoginReqDTO;
import com.alt.products.services.UserService;
import com.alt.products.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody LoginReqDTO loginRequest) {
        return userService.authenticate(loginRequest.getEmail(), loginRequest.getPassword())
                .map(user -> ResponseEntity.ok(jwtUtil.generateToken(user.getEmail())))
                .orElse(ResponseEntity.status(401).body("Invalid credentials"));
    }
}


