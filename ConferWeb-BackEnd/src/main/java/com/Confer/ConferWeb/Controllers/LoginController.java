package com.Confer.ConferWeb.Controllers;

import com.Confer.ConferWeb.Model.DTO.LoginRequest;
import com.Confer.ConferWeb.Model.DTO.LoginResponse;
import com.Confer.ConferWeb.Model.Entity.User;
import com.Confer.ConferWeb.Repository.LoginRepository;
import com.Confer.ConferWeb.Services.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
@RequiredArgsConstructor
public class LoginController {

    private final LoginRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest body){
        User user = this.repository.findByUsername(body.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.getPassword(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new LoginResponse(user.getUsername(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}

