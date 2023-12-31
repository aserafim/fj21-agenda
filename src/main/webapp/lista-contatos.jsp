<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<!--cria o dao-->
<jsp:useBean id="dao" class="br.com.caelum.agenda.ContatoDao"/>
<h2 align="center">Lista de Contatos</h2>
<table cellspacing="10">
	<tr>
		<th class="col-1">Nome</th>
		<th class="col-2">E-mail</th>
		<th class="col-3">Endereço</th>
		<th class="col-4">Data de Nascimento</th>
	</tr>
<!-- Percorre contatos montando as linhass da tabela -->
<c:forEach var="contato" items="${dao.lista}">
  <tr>
    <td class="col-1">${contato.nome}</td>
    <td class="col-1">${contato.email }</td>
    <td class="col-1">${contato.endereco }</td>
    <td class="col-1">${contato.dataNascimento.time }</td>
  </tr>
</c:forEach>
</table>
</body>
</html>