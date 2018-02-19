package br.com.casadocodigod.loja.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigod.loja.models.Produto;

public class ProdutoValidation implements Validator { //ele tem que implementar essa interface pq o binder pede um validator
	
	
	

@Override
public boolean supports(Class<?> clazz) {//
	return Produto.class.isAssignableFrom(clazz);//a classe produto pode ser validad, posso chamar o validator para produto
}

@Override
public void validate(Object target, Errors errors) {//target - objeto alvo que é produto
	ValidationUtils.rejectIfEmpty(errors,"titulo", "field.required");//classe do spring que não aceita nulo	
	//recebe um erro, qual o campo e o tipo de erro(campo requerido)
	ValidationUtils.rejectIfEmpty(errors,"descricao", "field.required");
	
	Produto produto = (Produto) target;//fiz um cast e transformei o target em produto
//////////validação de numero de paginas (tem que ser >=0 )
	if(produto.getPaginas()<=0) {
		errors.rejectValue("paginas", "field.required");//nesse caso chamo a classe erro e se paginas negativas rejeito input
		
		}
	}
	
}

