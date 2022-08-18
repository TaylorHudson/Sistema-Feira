package sistemaFeira.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import sistemaFeira.model.Venda;

public class RepositorioVenda {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistema");
	
	public void cadastrarVenda(Venda v) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		
		em.close();
	}
	
	public void atualizarVenda(Venda v) {
		EntityManager em = emf.createEntityManager();
		
		Venda venda = em.find(Venda.class, v.getId());
		
		if(venda.getId() != null) {
			em.getTransaction().begin();
			em.merge(v);
			em.getTransaction().commit();
		}
		em.close();
	}
	
	public void excluirVenda(Venda v) {
		EntityManager em = emf.createEntityManager();
		
		Venda venda = em.find(Venda.class, v.getId());
		
		em.getTransaction().begin();
		em.remove(venda);
		em.getTransaction().commit();
		
		em.close();
	}
	
	public Venda buscarPorId(int id) {
		EntityManager em = emf.createEntityManager();

		Venda v = em.find(Venda.class, id);
		
		em.close();
		
		return v;
	}
	
	@SuppressWarnings("unchecked")
	public List<Venda> todasVendas() {
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("SELECT v FROM Venda v ORDER BY v.id");
		List<Venda> vendas = q.getResultList();
		
		return vendas;
	}
	
	public Boolean cadastrado(Venda v) {
		List<Venda> l = todasVendas();
		for(Venda venda : l) {
			if(venda.getId().equals(v.getId())) {
				return true;
			}
		}
		return false;
	}
}
