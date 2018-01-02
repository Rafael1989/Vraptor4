package br.com.caelum.vraptor.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.util.JPAUtil;
import br.com.caelum.vraptor.view.Results;

@Controller
public class ProdutoController {
	
	private final Result result;
	
	public ProdutoController() {
		this(null);
	}
	
	@Inject
	public ProdutoController(Result result) {
		this.result = result;
	}	
	
	public void sobre() {
		
	}
	
	public void lista(){
		result.include("produtoList",new ProdutoDao(new JPAUtil().criaEntityManager()).lista());
	}
	
	public void formulario() {
		
	}
	
	public void listaXML() {
		result.use(Results.xml()).from(new ProdutoDao(new JPAUtil().criaEntityManager()).lista()).serialize();
	}
	
	@Post
	public void adiciona(Produto produto) {
		EntityManager em = new JPAUtil().criaEntityManager();
		em.getTransaction().begin();
		new ProdutoDao(em).adiciona(produto);
		em.getTransaction().commit();
		result.include("mensagem", "Produto adicionado com sucesso");
		result.redirectTo(this).lista();
	}
	
	public void remove(Produto produto) {
		EntityManager em = new JPAUtil().criaEntityManager();
		em.getTransaction().begin();
		new ProdutoDao(em).remove(produto);
		em.getTransaction().commit();
		result.include("mensagem","Produto removido com sucesso");
		result.redirectTo(this).lista();
	}

}
