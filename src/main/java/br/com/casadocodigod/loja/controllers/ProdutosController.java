package br.com.casadocodigod.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigod.loja.daos.ProdutoDAO;
import br.com.casadocodigod.loja.infra.FileSaver;
import br.com.casadocodigod.loja.models.Produto;
import br.com.casadocodigod.loja.models.TipoPreco;
import br.com.casadocodigod.loja.validation.ProdutoValidation;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {
	
	
	@Autowired //aqui ele injeta o produto dao
	private ProdutoDAO produtoDAO;
	
	@Autowired
	private FileSaver fileSaver;//aqui injeta a fileServer para usar dentro da classe controller ! Aqui mesmo ! dentro do metodo salvar!
	
	@InitBinder
	public void InitBinder(WebDataBinder binder) {//metodo que faz o bind do produtovalidation com a anotação valid logo abaixo
		binder.addValidators( new ProdutoValidation());//adiciono aqui o validador
	}
		
	@RequestMapping("/form")
	public ModelAndView form(Produto produto) {//no form recebo produto que irá pra o request
		ModelAndView modelAndView = new ModelAndView("produtos/form");//nesse caso consigo mandar um objeto do model para o view
		//produtos/form-- aqui pra onde sera enviado a view
		modelAndView.addObject("tipos", TipoPreco.values());//aqui crio a variavek tipos e coloco dentro dela a classe enum
		return modelAndView;//qual pagina vou enviar o usuario
		
	}
	@RequestMapping(method=RequestMethod.POST)//gravar uso post
	public ModelAndView grava(MultipartFile sumario, //classe pra trabalhar com arquivos 
			@Valid Produto produto,//grava os produtos, recebe um redirect que sera um flash para exibir uma mensagem entre um request e outro
			BindingResult result,//result retorna o erro de validação se houver
			 RedirectAttributes redirectAttributes) {
			//flash atribute é um pequeno escopo que dura de um request a outro
		//redirect atribute-adiociono nele o flash, ou seja adiciono o sucesso no PROXIMOOO redirect 
		//@valid - biblioteca usada para validar os dados ele chama a classe produtovalidation
	
				
		if (result.hasErrors()) {//se houver erro retorna para o form
		 return	form(produto);
		}
		
		String path=fileSaver.write("arquivos-sumario", sumario);//aqui passo a pasta e o proprio arq sumario 
		
		produto.setSumarioPath(path);
		
		produtoDAO.gravar(produto);//aqui jogo produto no banco !
		
		redirectAttributes.addFlashAttribute("sucesso","Produto cadastrado com sucesso");//adiciono um flash, crio a variavel sucesso e recupero ela na view dentro de uma div 
		
		return new ModelAndView("redirect:produtos");//redireciono o usuário para a página /produtos pois nesse caso evito o bug f5
		
	}
	
	@RequestMapping(method=RequestMethod.GET) //listar uso get
	public ModelAndView listar() {
		List<Produto> produtos = produtoDAO.listar();//lista os produtos que estão no BD coloco dentro da lista produtos
		ModelAndView modelAndView = new ModelAndView("produtos/lista");//aqui digo qual pagina vou direcionar
		modelAndView.addObject("produtos",produtos);//atraves desse método consigo recuperar essa variavel la na view com a lista de produtos dentro
		
		return modelAndView;
	}
	
}
