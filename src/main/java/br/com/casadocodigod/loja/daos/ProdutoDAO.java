package br.com.casadocodigod.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigod.loja.models.Produto;

@Repository   //faço o spring conhecer o produto dao.
@Component   //anotation que permite que a classe seja gerenciada pelo spring . Repository herda de component.
@Transactional //estou dizendo que o DAO será transacional,          
public class ProdutoDAO {
	
	@PersistenceContext //aqui injeto o entitymanager
	private EntityManager manager;//gerente das entidades
	
	public void gravar (Produto produto) {
		manager.persist(produto);
		
		
	}

	public List<Produto> listar() {
		
		return manager.createQuery("select p from Produto p",Produto.class)
				.getResultList();//aqui retorno a lista de produtos 
	}

}
