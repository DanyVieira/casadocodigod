package br.com.casadocodigod.loja.conf;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//recebe as requisições e realiza as configuraçãoes básicas
public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer { //inicializa o servlet 

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {AppWebConfiguration.class, JPAConfiguration.class}; //essa classe app é a classe de configuração do projeto web
	}
		

	@Override
	protected String[] getServletMappings() {
		 return new String[] {"/"}; //aqui digo a url que quero mapear
	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		
		return new Filter[] {encodingFilter}; //filtro que trata da codificação 
	}
}
