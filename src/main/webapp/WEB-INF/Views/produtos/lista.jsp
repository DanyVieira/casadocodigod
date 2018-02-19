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
   <h1>Lista de produtos</h1>	
   <div>${sucesso}</div>
   
	<table>
		<tr>
		 <td>Título</td>
		 <td>Descrição</td>
		 <td>Páginas</td>
		
		</tr>
		<c:forEach items="${produtos}" var="produto"> <!-- aqui pego a variavel produtos que defini la no controller  e faço um bind com o objeto produto --> 
			<tr>
				<td>${produto.titulo}</td> <!-- pega esses dados direto do banco enquanto houver dados! -->
				<td>${produto.descricao}</td>
				<td>${produto.paginas}</td>
				
			
			</tr>
		</c:forEach>
	</table>
</body>
</html>