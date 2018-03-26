<%@ page language="java" contentType="text/html; charset= UTF-8"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- diretiva que importa o jstl, esse c esta la embaixo c:-->
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %> <!-- diretiva para adicionar mensagem ao usuario form:erros -->
    <%@ taglib uri="http://www.springframework.org/tags"  prefix="s" %> 
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Livro de java android</title>
</head>
<body>
	<form:form action="${s:mvcUrl('PC#grava').build()}" method="post" commandName="produto"
	enctype="multipart/form-data"> <!-- diz ao request ao enviar os dados ao servidor que o arquivo é de multi informações texto imagem -->
	 <!-- nesse caso já digo o controler pelas iniciais Produto Controller (PC) e chamo o método gravar -->		
	<!--aqui diz pra que controller-produtos- enviar os dados   , commandname- pra não precisar ficar escrevendo produto
	dai ele já sabe que tudo esta se referenciando a produto-->
	<!-- o build ja constroi automaticamente se algo mudar ...exemplo mudei o nome do metodo -->
    <div>
        <label>Título</label> <!-- TITULO  -->
       
        <form:input path="titulo" /> <!-- envia dados para p controllet com atributo titulo -->
         <form:errors path= "titulo"/> <!-- tag que pega os erros de vallidação e exibe ao usuario para cada campo específico -->
    </div>
    <div>
        <label>Descrição</label>
        
        <form:textarea path="descricao" rows="10" cols="20" /><!-- text area com 10 linhas e 20 colunas -->
        <form:errors path= "descricao"/>
    </div>
    <div>
        <label>Páginas</label>
          
        <form:input path="paginas" />
         <form:errors path= "paginas"/>
    </div>
    <div>
        <label>Data de Lançamento</label>
          
        <form:input path="dataLancamento" />
         <form:errors path="dataLancamento"/>
     </div>
  
   
   <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">    <!-- aqui coloco o laço de repetição --> <!-- chamo a variavel tipos que construi no controller -->
   	 <div>
        <label>${tipoPreco}</label> <!--aqui chamo o tipopreço de cima  -->
        <form:input path="precos[${status.index }].valor"/>  <!--status retorna um indice  -->
        <form:hidden path="precos[${status.index }].tipo" value="${tipoPreco}"/><!-- hidden escondido usuario não pode alterar -->
  	  </div>     
   </c:forEach>
    
      <div>
    		<label>Sumário</label>
            <input name="sumario" type="file" /><!-- esse sumario é um resumo que vou mandar p servidor da opção pra o usuario anexar um arquivo!! -->
      </div>
    
     <button type="submit">Cadastrar</button>
  
	</form:form>
</body>
</html>