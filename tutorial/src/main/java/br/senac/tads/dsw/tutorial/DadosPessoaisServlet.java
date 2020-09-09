/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.tutorial;

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

/**
 *
 * @author fedts
 */
@WebServlet(name = "DadosPessoaisServlet", urlPatterns = {"/dados-pessoais"})
public class DadosPessoaisServlet extends HttpServlet {

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
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("dados.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
