package pgw2.Atividade04.Repository;

import pgw2.Atividade04.Entity.ItemVenda;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ItemVendaRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(ItemVenda itemVenda){
        em.persist(itemVenda);
    }

    public ItemVenda itemVenda(Long id){
        return em.find(ItemVenda.class, id);
    }

    public List<ItemVenda> ItensVenda(){
        Query query = em.createQuery("from ItemVenda");
        return query.getResultList();
    }

    public void remove(Long id){
        ItemVenda p = em.find(ItemVenda.class, id);
        em.remove(p);
    }

    public void update(ItemVenda itemVenda){
        em.merge(itemVenda);
    }

}
