package com.AlkemyChallenge.Disney.auth.controller;

import com.AlkemyChallenge.Disney.auth.dto.AuthenticationRequest;
import com.AlkemyChallenge.Disney.auth.dto.AuthenticationResponse;
import com.AlkemyChallenge.Disney.auth.dto.UserDTO;
import com.AlkemyChallenge.Disney.auth.service.JwtUtils;
import com.AlkemyChallenge.Disney.auth.service.UserDetailsCustomService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserDetailsCustomService userDetailsCustomService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtTokenUtils;
    
    
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@Valid @RequestBody UserDTO userDto)throws Exception{
    userDetailsCustomService.save(userDto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse>login(@RequestBody AuthenticationRequest authRequest)throws Exception{
        UserDetails userDetails;
        try {
            Authentication auth=authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            
            );
            userDetails=(UserDetails)auth.getPrincipal();
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password ",e);
        }
     final String jwt=jwtTokenUtils.generateToken(userDetails);
     return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
    

}
