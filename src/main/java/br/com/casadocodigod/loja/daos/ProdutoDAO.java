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

	public Produto find(Integer id) {

		return manager.createQuery("select distinct(p) from Produto p join fetch  p.precos preco  where p.id= :id" , Produto.class)
				.setParameter("id", id) //busco o id e coloco esse valor dentro da variavel id
				.getSingleResult();//fornece como resultado o produto já ralacionado com os preços.
	}

}
