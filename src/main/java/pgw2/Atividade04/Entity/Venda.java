package pgw2.Atividade04.Entity;

import java.time.LocalDate;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Entity
@Table(name = "tb_venda")

//22/09/2022 - 09:02 criada a parte do contexto da sessao da venda
//###########################################################
@Scope(value=WebApplicationContext.SCOPE_SESSION)
@Component
//###########################################################
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
    private LocalDate data = LocalDate.now();
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "item_venda_id")
    private List<ItemVenda> itensVenda = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id_Venda=" + id +
                ", data=" + data +
                ", itensVenda=" + itensVenda +
                '}';
    }

    public double total(){
        double d=0;
        for(int i=0; i<itensVenda.size(); i++)
            d+=itensVenda.get(i).total();
        return d;
    }

}
