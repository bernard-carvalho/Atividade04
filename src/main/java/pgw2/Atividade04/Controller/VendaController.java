package pgw2.Atividade04.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import pgw2.Atividade04.Repository.ProdutoRepository;
import pgw2.Atividade04.Repository.VendaRepository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.WebApplicationContext;

import pgw2.Atividade04.Entity.ItemVenda;
import pgw2.Atividade04.Entity.Produto;
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
    ProdutoRepository produtoRepository;

    @Autowired
    Venda venda;
    
    @GetMapping("/list")
    public ModelAndView listar(ModelMap model){
        model.addAttribute("vendas",repository.vendas());
        return new ModelAndView("/vendas/list",model);
    }
    
    @GetMapping("/detalhes/{id}")
    public ModelAndView detalhar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("venda",repository.venda(id));
        return new ModelAndView("/vendas/detalhes", model);
    }

    @GetMapping("/carrinho")
    public ModelAndView listCarrinho(ModelMap model){
        List<Produto> produtos = produtoRepository.produtos();
        model.addAttribute("produtos", produtos);
        return new ModelAndView("/vendas/carrinho/list",model);
    }

    @GetMapping("/carrinho/add/{qntdProduto}")
    public RedirectView addItemNocarrinho(@PathVariable("qntdProduto") Long qntdProduto,Produto produto){
        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setProduto(produto);
        itemVenda.setQntd(qntdProduto);
        venda.getItensVenda().add(itemVenda);
        return new RedirectView("/vendas/carrinho/");
    }
    @GetMapping("/carrinho/finalizar-venda")
    public RedirectView finalizarVenda(ModelMap model){
        repository.save(venda);
        venda = new Venda();
        return new RedirectView("/vendas/list");  
    }
    
    
    //add itens
}
