/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.tutorial;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DadosPessoaisServlet2", urlPatterns = {"/dados-pessoais2"})
public class DadosPessoaisServlet2 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userAgent = request.getHeader("user-agent");
        boolean isMobile = userAgent.toLowerCase().contains("mobile");
        String id = request.getParameter("id");

        DadosPessoais dados = new DadosPessoais();
        
        if ("1".equals(id)) {
            dados.setNome("Seu Madruga");
            dados.setEmail("madruga@teste.com.br");
            dados.setTelefone("(11) 99999-8877");
            dados.setDataNascimento(LocalDate.of(1971, 6, 20));
            dados.setImgPath("img/madruga.jpg");
        } else if ("2".equals(id)) {
            dados.setNome("Fulano da Silva");
            dados.setEmail("fulano@teste.com.br");
            dados.setTelefone("(11) 99999-6655");
            dados.setDataNascimento(LocalDate.of(1999, 12, 3));
            dados.setImgPath("img/madruga.jpg");
        } else {
            response.setStatus(404);
            return;
        }
        request.setAttribute("dad", dados);
        request.setAttribute("timeinfo", LocalDateTime.now());
        request.setAttribute("mobile", isMobile);
        request.setAttribute("userAgent", userAgent);
        
        // CONVERTE OBJ JAVA PARA JSON (VER NO POM.XML A DEPENDENCIA PARA LOCALDATE)
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.registerModule(new JavaTimeModule());
        String json = mapper.writeValueAsString(dados);
        System.out.println("JSON gerado: " + json);
        
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
        }
        
//        RequestDispatcher dispatcher = request.getRequestDispatcher("dados.jsp");
//        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
