<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="cabecalho.jsp"/>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css" />
<title>Lista de Contatos</title>
</head>
<body>
<!--cria o dao-->
<jsp:useBean id="dao" class="br.com.caelum.agenda.ContatoDao"/>
<h2 align="center">Lista de Contatos</h2>
<table cellspacing="10">
	<tr>
		<th class="colh-1">Nome</th>
		<th class="colh-2">E-mail</th>
		<th class="colh-3">Endereço</th>
		<th class="colh-4">Data de Nascimento</th>
	</tr>
<!-- Percorre contatos montando as linhass da tabela -->
<c:forEach var="contato" items="${dao.lista}" varStatus="status">
 <c:if test="${status.index % 2 == 0}">
  <tr>
    <td class="colc-1">${contato.nome}</td>
    <c:if test="${not empty contato.email}">
    <td class="colc-1"><a href="mailto:${contato.email}">${contato.email }</a></td>
    </c:if>
    <c:if test="${empty contato.email}"><td class="colc-1">E-mail não cadastrado.</td></c:if>
    <td class="colc-1">${contato.endereco }</td>
    <td class="colc-1">${contato.dataNascimento.time }</td>
  </tr>
</c:if>
 <c:if test="${status.index % 2 != 0}">
  <tr>
    <td class="col-1">${contato.nome}</td>
    <c:if test="${not empty contato.email}">
    <td class="col-1"><a href="mailto:${contato.email}">${contato.email }</a></td>
    </c:if>
	<c:if test="${empty contato.email}"><td class="col-1">E-mail não cadastrado.</td></c:if>
    <td class="col-1">${contato.endereco }</td>
    <td class="col-1">${contato.dataNascimento.time }</td>
  </tr>
</c:if>
</c:forEach>
</table>
<c:import url="rodape.jsp"/>
</body>
</html>