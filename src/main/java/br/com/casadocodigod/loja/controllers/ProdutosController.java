package br.com.casadocodigod.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigod.loja.daos.ProdutoDAO;
import br.com.casadocodigod.loja.models.Produto;

@Controller
public class ProdutosController {
	
	
	@Autowired //aqui ele injeta o produto dao
	private ProdutoDAO produtoDAO;

	@RequestMapping("/produtos/form")
	public String form() {
		return "produtos/form";//qual pagina vou enviar o usuario
		
	}
	@RequestMapping("/produtos")
	public String grava(Produto produto) {//grava os produtos
		System.out.println(produto);
		produtoDAO.gravar(produto);//grava o produto no BD.
		
		return "produtos/ok";//envio para uma pagina de ok
		
	}
	
}
