package pgw2.Atividade04.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_item_venda")
public class ItemVenda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double qtd;

    @OneToOne
    @JoinColumn(name="produto_id")
    private Produto produto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Long getId_itemVenda() {
        return id;
    }

    public void setId_itemVenda(Long id_itemVenda) {
        this.id = id_itemVenda;
    }

    public double getQntd() {
        return qtd;
    }

    public void setQntd(double qntd) {
        this.qtd = qntd;
    }

    @Override
    public String toString() {
        return "ItemVenda{" +
                "id_itemVenda=" + id +
                ", qntd=" + qtd +
                ", produto=" + produto +
                '}';
    }

    public double total(){
        return produto.getValor()*qtd;
    }
}
