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
	enctype="multipart/form-data"> <!-- diz ao request ao enviar os dados ao servidor que o arquivo � de multi informa��es texto imagem -->
	 <!-- nesse caso j� digo o controler pelas iniciais Produto Controller (PC) e chamo o m�todo gravar -->		
	<!--aqui diz pra que controller-produtos- enviar os dados   , commandname- pra n�o precisar ficar escrevendo produto
	dai ele j� sabe que tudo esta se referenciando a produto-->
	<!-- o build ja constroi automaticamente se algo mudar ...exemplo mudei o nome do metodo -->
    <div>
        <label>T�tulo</label> <!-- TITULO  -->
       
        <form:input path="titulo" /> <!-- envia dados para p controllet com atributo titulo -->
         <form:errors path= "titulo"/> <!-- tag que pega os erros de vallida��o e exibe ao usuario para cada campo espec�fico -->
    </div>
    <div>
        <label>Descri��o</label>
        
        <form:textarea path="descricao" rows="10" cols="20" /><!-- text area com 10 linhas e 20 colunas -->
        <form:errors path= "descricao"/>
    </div>
    <div>
        <label>P�ginas</label>
          
        <form:input path="paginas" />
         <form:errors path= "paginas"/>
    </div>
    <div>
        <label>Data de Lan�amento</label>
          
        <form:input path="dataLancamento" />
         <form:errors path="dataLancamento"/>
     </div>
  
   
   <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">    <!-- aqui coloco o la�o de repeti��o --> <!-- chamo a variavel tipos que construi no controller -->
   	 <div>
        <label>${tipoPreco}</label> <!--aqui chamo o tipopre�o de cima  -->
        <form:input path="precos[${status.index }].valor"/>  <!--status retorna um indice  -->
        <form:hidden path="precos[${status.index }].tipo" value="${tipoPreco}"/><!-- hidden escondido usuario n�o pode alterar -->
  	  </div>     
   </c:forEach>
    
      <div>
    		<label>Sum�rio</label>
            <input name="sumario" type="file" /><!-- esse sumario � um resumo que vou mandar p servidor da op��o pra o usuario anexar um arquivo!! -->
      </div>
    
     <button type="submit">Cadastrar</button>
  
	</form:form>
</body>
</html>