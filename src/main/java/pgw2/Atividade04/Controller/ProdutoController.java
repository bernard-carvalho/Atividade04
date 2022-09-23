/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pgw2.Atividade04.Controller;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import pgw2.Atividade04.Repository.ProdutoRepository;
import pgw2.Atividade04.Entity.Produto;
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
    
    @GetMapping("/create")
    public RedirectView create(Produto produto, ModelMap model){
        repository.save(produto);
        return new RedirectView("/produtos/list");
    }

    @GetMapping("/delete/{id}")
    public RedirectView delete(ModelMap model, @PathVariable("id") Long id ){
        repository.remove(id);
        return new RedirectView("/produtos/list");
    }

    @GetMapping("/update")
    public RedirectView update(Produto produto, ModelMap model){
        repository.update(produto);
        return new RedirectView("/produtos/list");
    }
    
}
