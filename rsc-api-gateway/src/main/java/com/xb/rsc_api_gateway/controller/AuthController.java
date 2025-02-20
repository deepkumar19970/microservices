package com.xb.rsc_api_gateway.controller;

import com.xb.rsc_api_gateway.dto.AuthRequest;
import com.xb.rsc_api_gateway.dto.AuthResponse;
import com.xb.rsc_api_gateway.model.User;
import com.xb.rsc_api_gateway.security.JWTUtil;
import com.xb.rsc_api_gateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AuthController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/login")
    public Mono<ResponseEntity<AuthResponse>> login(@RequestBody AuthRequest authRequest) {
        String pass =bCryptPasswordEncoder.encode(authRequest.getPassword());
        return userService.findByUsername(authRequest.getUsername())
                .map(userDetails -> {
                    if (bCryptPasswordEncoder.matches(authRequest.getPassword() , userDetails.getPassword())) {
                        return ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(authRequest.getUsername())));
                    } else {
                        throw new BadCredentialsException("Invalid username or password");
                    }
                }).switchIfEmpty(Mono.error(new BadCredentialsException("Invalid username or password")));
    }
    @PostMapping("/signup")
    public Mono<ResponseEntity<String>> signup(@RequestBody User user) {
        // Encrypt password before saving
        user.setPassword(user.getPassword() ,bCryptPasswordEncoder );
        return userService.save(user)
                .map(savedUser -> ResponseEntity.ok("User signed up successfully"));
    }

    @GetMapping("/protected")
    public Mono<ResponseEntity<String>> protectedEndpoint() {
        return Mono.just(ResponseEntity.ok("You have accessed a protected endpoint!"));
    }
}
