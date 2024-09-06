package com.user.service;


import com.user.config.JwtAuth;
import com.user.dto.LoginRequestDto;
import com.user.dto.LoginResponse;
import com.user.dto.SignUpRequest;
import com.user.enums.Role;
import com.user.model.User;
import com.user.model.Utilisateur;
import com.user.repository.UserRepository;
import com.user.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtAuth jwtAuth;



    public Utilisateur signup(SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        Utilisateur user = new Utilisateur();
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setEmail(signUpRequest.getEmail());
        user.setRole(Role.USER);
        return userRepository.save(user);
    }

    public LoginResponse login(LoginRequestDto loginRequest){
        System.out.println(loginRequest.getUsername()+"  /   "+loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        User user = findByUsername(loginRequest.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Username not found !"));
        System.out.println("aaaaaaaaaa" + user);
        String token = jwtAuth.generateToken(user.getUsername(), user.getRole());

        return LoginResponse.builder().token(token).build();
    }
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
