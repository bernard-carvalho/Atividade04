package pgw2.Atividade04.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pgw2.Atividade04.Repository.VendaRepository;

import javax.transaction.Transactional;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.WebApplicationContext;
import pgw2.Atividade04.Entity.Venda;

/*

@Transactional
@Controller
@RequestMapping("produtos")
public class ProdutosController {
    @Autowired
    ProdutoRepository repository;
    @GetMapping("/list")
    public ModelAndView listar(ModelMap model){
        model.addAttribute("produtos", repository.produtos());
        return new ModelAndView("/produtos/list", model);
    }
* */
@Transactional
@Controller
@RequestMapping("vendas")
//22/09/2022 08:55 Adicionada linha do contexto do controller
//###########################################################
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
//###########################################################
public class VendaController {
    
    @Autowired
    VendaRepository repository;
    
    @Autowired
    Venda venda;
    
    @GetMapping("/list")
    public ModelAndView listar(ModelMap model){
        model.addAttribute("vendas",repository.vendas());
        return new ModelAndView("/vendas/list",model);
    }
    
    @GetMapping("/detalhar/{id}")
    public ModelAndView detalhar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("venda",repository.venda(id));
        return new ModelAndView("/vendas/detalhes", model);
    }
    
    
    //add itens
}
