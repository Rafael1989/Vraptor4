package br.com.caelum.vraptor.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.simplemail.Mailer;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

@Controller
public class ProdutoController {
	
	private final Result result;
	private final ProdutoDao dao;
	private final Validator validator;
	private Mailer mailer;
	
	public ProdutoController() {
		this(null,null,null,null);
	}
	
	@Inject
	public ProdutoController(Result result, ProdutoDao dao, Validator validator, Mailer mailer) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
		this.mailer = mailer;
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
	
	public void pedi(Produto produto) throws EmailException {
		Email email = new SimpleEmail();
		email.setSubject("Precisamos de mais estoque");
		email.addTo("remetente@gmail.com");
		email.setMsg("Precisamos de mais itens do produto " + produto.getNome());
		mailer.send(email);
		result.redirectTo(this).lista();
	}

}
