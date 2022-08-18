package sistemaFeira.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import sistemaFeira.model.Produto;

public class RepositorioProduto {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistema");
	
	public void cadastrarProduto(Produto p) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
		em.close();
	}
	
	public void atualizarProduto(Produto p) {
		EntityManager em = emf.createEntityManager();
		
		Produto produto = em.find(Produto.class, p.getId());
		
		if(produto.getNome() != null) {
			em.getTransaction().begin();
			em.merge(p);
			em.getTransaction().commit();
		}
		em.close();
	}
	
	public void excluirProduto(Produto p) {
		EntityManager em = emf.createEntityManager();
		
		Produto produto = em.find(Produto.class, p.getId());
		
		em.getTransaction().begin();
		em.remove(produto);
		em.getTransaction().commit();
		
		em.close();
	}
	
	public Produto buscarPorId(int id) {
		EntityManager em = emf.createEntityManager();

		Produto p = em.find(Produto.class, id);
		
		em.close();
		
		return p;
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> todosProdutos() {
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("SELECT p FROM Produto p ORDER BY p.nome");
		List<Produto> produtos = q.getResultList();
		
		return produtos;
	}
	
	public Boolean cadastrado(Produto p) {
		List<Produto> l = todosProdutos();
		for(Produto produto : l) {
			if(produto.equals(p)) {
				return true;
			}
		}
		return false;
	}
}
