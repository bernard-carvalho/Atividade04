package pgw2.Atividade04.Repository;

import org.springframework.stereotype.Repository;
import pgw2.Atividade04.Entity.Venda;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class VendaRepository {
    
    @PersistenceContext
    private EntityManager em;

    public void save(Venda venda){
        em.persist(venda);
    }

    public Venda venda(Long id){
        return em.find(Venda.class, id);
    }

    public List<Venda> vendas(){
        Query query = em.createQuery("from Venda");
        return query.getResultList();
    }

    public void remove(Long id){
        Venda p = em.find(Venda.class, id);
        em.remove(p);
    }

    public void update(Venda venda){
        em.merge(venda);
    }
}
