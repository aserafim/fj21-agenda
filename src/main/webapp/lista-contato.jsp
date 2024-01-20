<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<c:import url="cabecalho.jsp"/>
<head>
<link rel="stylesheet" type="text/css" href="style.css" />
<title>Alterar Contato</title>
</head>
<body>
<!--cria o dao-->
<h2 align="center">Alterar Contato</h2>
<table>
	<tr>
		<th class="colh-1">Nome</th>
		<th class="colh-2">E-mail</th>
		<th class="colh-3">Endereço</th>
		<th class="colh-4">Data de Nascimento</th>
	</tr>
<!-- Percorre contatos montando as linhass da tabela -->
  <tr>
    <td class="colc-1">${contato.nome}</td>
    <c:if test="${not empty contato.email}">
    <td class="colc-1"><a href="mailto:${contato.email}">${contato.email }</a></td>
    </c:if>
    <c:if test="${empty contato.email}"><td class="colc-1">E-mail não cadastrado.</td></c:if>
    <td class="colc-1">${contato.endereco }</td>
    <td class="colc-1"><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
    <td><a href="mvc?logica=RemoveContatoLogica&id=${contato.id}">Remover</a></td>
    <td><a href="altera-contato.jsp">Alterar</a></td>
  </tr>
</table>
<c:import url="rodape.jsp"/>
</body>
</html>