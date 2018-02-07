package br.com.casadocodigod.loja.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigod.loja.controllers.HomeController;
import br.com.casadocodigod.loja.daos.ProdutoDAO;

@EnableWebMvc //aqui digo que qro utilizar a parte web do spring
@ComponentScan(basePackageClasses= {HomeController.class,ProdutoDAO.class})//aqui indico onde esta o pacote da classe controller e o pacote da classe DAO
public class AppWebConfiguration {

	@Bean//essa classe é gerenciada pelo spring
	public InternalResourceViewResolver internalResourceViewResolver() {//metodo que retorna a classe inetenal
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();//essa classe é o resolvedor interno de views
		resolver.setPrefix("/WEB-INF/Views/");//aqui indico onde esta a view
		resolver.setSuffix(".jsp");//digo a extensao da view
		
		return resolver;
	}
	
}
