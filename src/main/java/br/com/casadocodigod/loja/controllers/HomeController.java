package br.com.casadocodigod.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //anotação que indica que é um controller
public class HomeController {
	 @RequestMapping("/")//aqui mapeio o request do meu usuario para " / " é essa url que quero mapear
	    public String index(){ //essa string informa qual a view vou retornar
	        System.out.println("Entrando na home da CDC");
	        return "Home";//aqui a view que vou retornar,vai ficar nas pasta WEB-INF essa pasta contem as sevlet JSP é uma pasta 
	        					//protegida pelo servidor
	    }
	
}
