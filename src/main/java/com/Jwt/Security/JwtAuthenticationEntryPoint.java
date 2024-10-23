package com.Jwt.Security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.core.AuthenticationException;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        // Set the response to 401 Unauthorized
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        PrintWriter printWriter=response.getWriter();
        printWriter.println("Access Denied!!"+authException.getMessage()+"");
    }
}
