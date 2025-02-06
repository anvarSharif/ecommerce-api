package com.example.ecommerce_api.config;

import com.example.ecommerce_api.entity.Role;
import com.example.ecommerce_api.entity.User;
import com.example.ecommerce_api.repo.RoleRepository;
import com.example.ecommerce_api.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public DataLoader(RoleRepository roleRepository, PasswordEncoder passwordEncoder,
                      UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Role> roleList = roleRepository.findAll();

        User user = User.builder()
                .roles(new ArrayList<>(List.of(roleList.get(0))))
                .username("a")
                .password(passwordEncoder.encode("a"))
                .fullName("eshmatjon")
                .build();
        userRepository.save(user);
        User user1 = User.builder()
                .roles(new ArrayList<>(List.of(roleList.get(1))))
                .username("b")
                .password(passwordEncoder.encode("b"))
                .fullName("Hikmatjon")
                .build();
        userRepository.save(user1);
    }
}
