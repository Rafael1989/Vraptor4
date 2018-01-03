package br.com.caelum.vraptor.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

@Controller
public class ProdutoController {
	
	private final Result result;
	private final ProdutoDao dao;
	private final Validator validator;
	
	public ProdutoController() {
		this(null,null,null);
	}
	
	@Inject
	public ProdutoController(Result result, ProdutoDao dao, Validator validator) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
	}	
	
	public void sobre() {
		
	}
	
	public void lista(){
		result.include("produtoList",dao.lista());
	}
	
	public void formulario() {
		
	}
	
	public void listaXML() {
		result.use(Results.xml()).from(dao.lista()).serialize();
	}
	
	@Post
	public void adiciona(@Valid Produto produto) {
		//this.validator.check(produto.getQuantidade()>0, new SimpleMessage("erro", "A quantidade tem que ser maior que zero."));
		//this.validator.check(produto.getQuantidade()>0, new I18nMessage("erro", "produto.quantidadade.negativa"));
		this.validator.onErrorForwardTo(this).formulario();
		dao.adiciona(produto);
		result.include("mensagem", "Produto adicionado com sucesso");
		result.redirectTo(this).lista();
	}
	
	public void remove(Produto produto) {
		dao.remove(produto);
		result.include("mensagem","Produto removido com sucesso");
		result.redirectTo(this).lista();
	}

}
