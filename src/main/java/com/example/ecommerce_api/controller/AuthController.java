package com.example.ecommerce_api.controller;

import com.example.ecommerce_api.dto.LoginDTO;
import com.example.ecommerce_api.entity.User;
import com.example.ecommerce_api.service.TokenService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class AuthController {
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    public AuthController(TokenService tokenService, AuthenticationManager authenticationManager){
        this.tokenService=tokenService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    public HttpEntity<?> login(@RequestBody LoginDTO loginDTO){
        var authenticationToken=new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        User user = (User) authenticate.getPrincipal();
        return ResponseEntity.ok(Map.of(
                "token", tokenService.generateToken((User)authenticate.getPrincipal()),
                "user", Map.of(
                        "fullName", user.getFullName(),
                        "photoId", user.getPersonalPhoto().getId(),
                        "roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList()
                )
        ));
    }

}
