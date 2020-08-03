package com.Vguru.Service.Controller;

import com.Vguru.Service.GuruService.MyUserDetailService;
import com.Vguru.Service.Jwtutil.JwtUtil;
import com.Vguru.Service.api.v1.auth.AuthenticationRequest;
import com.Vguru.Service.api.v1.auth.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Autowired
    private JwtUtil jwtTokenUtil;


    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody AuthenticationRequest authenticationRequest
    ) throws BadCredentialsException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                (authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        final UserDetails userDetails = myUserDetailService
                .loadUserByUsername(
                        authenticationRequest.getUsername()
                );
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
