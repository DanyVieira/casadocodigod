package br.com.casadocodigod.loja.conf;

import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement //possibilita ao spring cuidar das transações
public class JPAConfiguration {
	
	 
		
	
	@Bean //faz o spring conhecer esse método de configuração
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		//aqui é a configuração do entitymanager, para então criar o entitymanager
		LocalContainerEntityManagerFactoryBean factoryBean = 
				new LocalContainerEntityManagerFactoryBean();//objeto para criar o entitymanager factory
		
		 JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();//vendoradapter é a interface que o vendoradapterjps implementa
			//adaptador do hibernateJPA
		
		 factoryBean.setJpaVendorAdapter(vendorAdapter);
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();//objeto que gerencia as conexões
		dataSource.setUsername("root");
		dataSource.setPassword("");
		dataSource.setUrl("jdbc:mysql://localhost:3306/casasdocodigod");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		
		factoryBean.setDataSource(dataSource);
		
		Properties props = new Properties(); 
		props.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");//configura o dialeto
		props.setProperty("hibernate.show_sql", "true");//permite ver o sql gerado pelo hibernate
		props.setProperty("hibernate.hbm2ddl.auto", "update");//mapeamento do hibernate para ddl/ auto=ao mudar o modelo o hibernate muda o banco
		
		factoryBean.setJpaProperties(props);//adiciona as proprietadas ao factoryBean
		
		factoryBean.setPackagesToScan("br.com.casadocodigod.loja.models");//onde estão as entidades para procurar por elas
		
		return factoryBean;
	}
	
	@Bean //esse bean é que cria e cuida da trandação
	public JpaTransactionManager transactionalMeneger(EntityManagerFactory emf) { //coloco o entity dentro do transaction
		return new JpaTransactionManager(emf);
	}

}