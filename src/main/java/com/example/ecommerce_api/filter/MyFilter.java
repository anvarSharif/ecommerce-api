package com.example.ecommerce_api.filter;

import com.example.ecommerce_api.repo.UserRepository;
import com.example.ecommerce_api.security.CustomUserDetailService;
import com.example.ecommerce_api.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MyFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final UserRepository userRepository;
    private final CustomUserDetailService customUserDetailService;
    public MyFilter(TokenService tokenService,
                    UserRepository userRepository, CustomUserDetailService customUserDetailService) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
        this.customUserDetailService = customUserDetailService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if (token != null) {
            if (tokenService.validate(token)) {
               final String username = tokenService.getUserName(token);
                List<SimpleGrantedAuthority> roles = tokenService.getRoles(token);
                UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
                final var auth = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        roles
                );
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(request, response);
    }


}
