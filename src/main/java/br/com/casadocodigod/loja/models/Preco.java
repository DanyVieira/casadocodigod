package br.com.casadocodigod.loja.models;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable // aqui digo que esse preco é colocado dentro do nosso produto
public class Preco {
	
	private BigDecimal valor;
	private TipoPreco tipo; //Criei um tipo enum para colocar os tipos de preços
	
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public TipoPreco getTipo() {
		return tipo;
	}
	public void setTipo(TipoPreco tipo) {
		this.tipo = tipo;
	}
	

}