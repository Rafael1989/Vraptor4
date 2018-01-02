package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.util.JPAUtil;

@Controller
public class ProdutoController {
	
	public void sobre() {
		
	}
	
	public List<Produto> lista(){
		return new ProdutoDao(new JPAUtil().criaEntityManager()).lista();
	}
	
	public void formulario() {
		
	}
	
	@Post
	public void adiciona(Produto produto) {
		EntityManager em = new JPAUtil().criaEntityManager();
		em.getTransaction().begin();
		new ProdutoDao(em).adiciona(produto);
		em.getTransaction().commit();
	}
	
	public void remove(Produto produto) {
		EntityManager em = new JPAUtil().criaEntityManager();
		em.getTransaction().begin();
		new ProdutoDao(em).remove(produto);
		em.getTransaction().commit();
	}

}
