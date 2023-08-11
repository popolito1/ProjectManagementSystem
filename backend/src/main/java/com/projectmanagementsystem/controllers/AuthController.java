package com.projectmanagementsystem.controllers;

import com.projectmanagementsystem.models.UserModel;
import com.projectmanagementsystem.repositories.UserRepository;
import com.projectmanagementsystem.request.LoginRequest;
import com.projectmanagementsystem.request.SignupRequest;
import com.projectmanagementsystem.response.JwtResponse;
import com.projectmanagementsystem.response.MessageResponse;
import com.projectmanagementsystem.security.jwt.AuthEntryPointJwt;
import com.projectmanagementsystem.security.jwt.JwtUtils;
import com.projectmanagementsystem.security.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateuser
            (@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate
                        (new UsernamePasswordAuthenticationToken
                                (loginRequest.getUsername(),
                                        loginRequest.getPassword()));
        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl)
                authentication.getPrincipal();

        logger.info("User is signed in");
        return ResponseEntity
                .ok(new JwtResponse(jwt, userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getMail()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser
            (@RequestBody SignupRequest signUpRequest) {

        if (userRepository.existsByUsername(signUpRequest
                .getUsername())) {

            return ResponseEntity.badRequest()
                    .body(new MessageResponse
                            ("Error: username is already taken!"));
        }

        if (userRepository.existsByMail
                (signUpRequest.getMail())) {

            return ResponseEntity.badRequest()
                    .body(new MessageResponse
                            ("Error: Email is already in use!"));
        }

        // Create new user account
        UserModel user = new UserModel(signUpRequest.getUsername(),
                signUpRequest.getMail(),
                encoder.encode(signUpRequest.getPassword()));
        userRepository.save(user);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signUpRequest.getUsername(), signUpRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        return ResponseEntity
                .ok(new MessageResponse("user registered successfully!"));
    }
}
