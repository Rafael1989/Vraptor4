package br.com.caelum.vraptor.controller;

import java.util.List;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.util.JPAUtil;

@Controller
public class ProdutoController {
	
	@Path("/produto/sobre")
	public void sobre() {
		
	}
	
	@Path("/produto/lista")
	public List<Produto> lista(){
		return new ProdutoDao(new JPAUtil().criaEntityManager()).lista();
	}

}