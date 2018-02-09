<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- diretiva que importa o jstl, esse c esta la embaixo c:-->
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Livro de java android</title>
</head>
<body>
	<form action="/casadocodigod/produtos" method="post"> <!--aqui diz pra que controller-produtos- enviar os dados   -->
    <div>
        <label>T�tulo</label> <!-- TITULO  -->
        <input type="text" name="titulo" /> <!-- envia dados para p controllet com atributo titulo -->
    </div>
    <div>
        <label>Descri��o</label>
        <textarea rows="10" cols="20" name="descricao"></textarea><!-- text area com 10 linhas e 20 colunas -->
    </div>
    <div>
        <label>P�ginas</label>
        <input type="text" name="paginas" />
    </div>
  
   
    <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">    <!-- aqui coloco o la�o de repeti��o --> <!-- chamo a variavel tipos que construi no controller -->
    <div>
        <label>${tipoPreco}</label> <!--aqui chamo o tipopre�o de cima  -->
        <input type="text" name="precos[${status.index }].valor"/>  <!--status retorna um indice  -->
        <input type="hidden" name= "precos[${status.index }].tipo" value="${tipoPreco}"/><!-- hidden escondido usuario n�o pode alterar -->
    </div>     
   </c:forEach>
    
     <button type="submit">Cadastrar</button>
  
	</form>
</body>
</html>