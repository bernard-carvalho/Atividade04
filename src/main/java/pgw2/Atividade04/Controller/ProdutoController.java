/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pgw2.Atividade04.Controller;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;
import pgw2.Atividade04.Repository.ProdutoRepository;

/**
 *
 * @author aluno
 */
@Transactional
@Controller
@RequestMapping("produtos")
//22/09/2022 08:55 Adicionada linha do contexto do controller
//###########################################################
//@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class ProdutoController {
    
    @Autowired
    ProdutoRepository repository;
    
    @GetMapping("/list")
    public ModelAndView listar(ModelMap model){
        model.addAttribute("produtos", repository.produtos());
        return new ModelAndView("/produtos/list",model);
    }
}
