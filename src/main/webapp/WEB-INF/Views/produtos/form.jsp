<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <button type="submit">Cadastrar</button>
	</form>
</body>
</html>