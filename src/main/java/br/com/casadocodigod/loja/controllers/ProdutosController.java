package br.com.casadocodigod.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigod.loja.daos.ProdutoDAO;
import br.com.casadocodigod.loja.models.Produto;
import br.com.casadocodigod.loja.models.TipoPreco;

@Controller
public class ProdutosController {
	
	
	@Autowired //aqui ele injeta o produto dao
	private ProdutoDAO produtoDAO;

	@RequestMapping("/produtos/form")
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("produtos/form");//nesse caso consigo mandar um objeto do model para o view
		//produtos/form-- aqui pra onde sera enviado a view
		modelAndView.addObject("tipos", TipoPreco.values());//aqui crio a variavek tipos e coloco dentro dela a classe enum
		return modelAndView;//qual pagina vou enviar o usuario
		
	}
	@RequestMapping("/produtos")
	public String grava(Produto produto) {//grava os produtos
		System.out.println(produto);
		produtoDAO.gravar(produto);//grava o produto no BD.
		
		return "produtos/ok";//envio para uma pagina de ok
		
	}
	
}
