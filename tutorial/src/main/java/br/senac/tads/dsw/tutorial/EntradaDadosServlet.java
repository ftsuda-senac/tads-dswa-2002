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
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EntradaDadosServlet", urlPatterns = {"/entrada-dados"})
public class EntradaDadosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("entrada.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String dataNascimentoStr = request.getParameter("dataNascimento");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ISO_DATE);
        
        DadosPessoais dados = new DadosPessoais();
        dados.setNome(nome);
        dados.setEmail(email);
        dados.setTelefone(telefone);
        dados.setDataNascimento(dataNascimento);
        dados.setImgPath("img/madruga.jpg");
        
        request.setAttribute("dad", dados);
        request.setAttribute("timeinfo", LocalDateTime.now());
        request.setAttribute("mobile", false);
        request.setAttribute("userAgent", "ABC");
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("dados.jsp");
        dispatcher.forward(request, response);
        

    }

}
