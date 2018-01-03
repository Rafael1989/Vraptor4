package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.UsuarioDao;
import br.com.caelum.vraptor.model.Usuario;
import br.com.caelum.vraptor.model.UsuarioLogado;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class LoginController {

	private final UsuarioDao dao;
	private final Validator validator;
	private final UsuarioLogado usuarioLogado;
	private final Result result;

	@Inject
	public LoginController(UsuarioDao dao, Validator validator, UsuarioLogado usuarioLogado,Result result) {
		this.dao = dao;
		this.validator = validator;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
	}
	
	@Deprecated
	LoginController() {
		this(null,null,null,null);
	}
	
	public void formulario() {
		
	}
	
	public void autentica(Usuario usuario) {
		if(!dao.existe(usuario)) {
			validator.add(new I18nMessage("erro", "login.invalido"));
			validator.onErrorUsePageOf(this).formulario();
		}
		usuarioLogado.setUsuario(usuario);
		result.redirectTo(ProdutoController.class).lista();
	}
	
}
