/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplospringsecurity.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 *
 * @author fedts
 */
public class PostLoginHandler implements AuthenticationSuccessHandler {
    
    private static final Logger log = LoggerFactory.getLogger(PostLoginHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication a) throws IOException, ServletException {
        log.debug("REFERER: {}", request.getHeader("Referer"));
        if (request.getHeader("Referer").endsWith("login2")) {
            response.sendRedirect("/teste");
        }
        response.sendRedirect("/home");
    }
    
}
