package com.Jwt.Controller;

import com.Jwt.Model.JwtRequest;
import com.Jwt.Model.JwtResponse;
import com.Jwt.Security.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;
@Controller
@RequestMapping("/auth")
public class AuthController
{
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtHelper jwtHelper;
    private Logger logger;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest requst)
    {
        this.doAuthenticate(requst.getEmail(),requst.getPassword());
        UserDetails userDetails=userDetailsService.loadUserByUsername(requst.getEmail());
        String token=this.jwtHelper.generateToken(userDetails);
        JwtResponse response=JwtResponse.builder().jwtToken(token).username(userDetails.getUsername()).build();
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
    private void doAuthenticate(String  mail,String password)
    {
        UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(mail,password);
        try {
            authenticationManager.authenticate(authentication);
        }
        catch (BadCredentialsException e){
            throw  new BadCredentialsException("Invalid username and Password");

        }
    }
    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHanler()
    {
        return "Credentials invalid";
    }

}