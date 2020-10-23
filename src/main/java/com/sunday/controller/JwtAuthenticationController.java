package com.sunday.controller;

import com.sunday.config.JwtTokenUtil;
import com.sunday.model.JwtRequest;
import com.sunday.model.JwtResponse;
import com.sunday.model.UserDTO;
import com.sunday.service.JwtUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class JwtAuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService userDetailsService;

    @PostMapping(value = "/login")
    public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest ar) throws Exception {
        System.out.println(ar);
        System.out.println(ar.getUsername());
        final var userDetails = userDetailsService.loadUserByUsername(ar.getUsername());
        authenticate(ar.getUsername(), ar.getPassword());
        final var token = jwtTokenUtil.generateToken(userDetails);
        var jwt = new JwtResponse(token, ar.getUsername());
        return ResponseEntity.ok(jwt);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) {
        return ResponseEntity.ok(userDetailsService.save(user));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
