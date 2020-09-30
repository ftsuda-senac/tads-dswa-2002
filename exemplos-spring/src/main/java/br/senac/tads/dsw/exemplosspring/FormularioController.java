/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/formulario")
public class FormularioController {

    @GetMapping
    public ModelAndView abrirFormulario() {
        ModelAndView mv = new ModelAndView("formulario");
        mv.addObject("dados", new Formulario());
        return mv;
    }

    @GetMapping("/preenchido")
    public ModelAndView abrirFormularioPreenchido() {
        Formulario formulario = new Formulario();
        formulario.setNome("Seu Madruga");
        formulario.setEmail("madruga@teste.com.br");
        formulario.setTelefone("11 98765-1122");
        formulario.setSenha("abcd1234");
        formulario.setRepetirSenha("abcd1234");
        formulario.setDescricao("Descrição Seu Madruga");
        formulario.setNumero(72);
        formulario.setAltura(BigDecimal.valueOf(1.75));
        formulario.setPeso(BigDecimal.valueOf(70));
        formulario.setDataNascimento(LocalDate.of(1970, 10, 10));
        formulario.setSexo(1);
        formulario.setInteresses(new String[] { "Tecnologia", "Esportes", "Viagens" });
        
        ModelAndView mv = new ModelAndView("formulario");
        mv.addObject("dados", formulario);
        return mv;
    }

    @PostMapping
    public ModelAndView receberDados(@ModelAttribute Formulario formulario) {
        ModelAndView mv = new ModelAndView("resultado");
        mv.addObject("dados", formulario);
        return mv;
    }
    
}
