<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<%@ page import="java.util.*,
	br.com.caelum.agenda.ContatoDao,
	java.text.SimpleDateFormat,
	br.com.caelum.agenda.Contato" %>
<h2 align=center> Lista de Contatos Cadastrados</h2>

<table cellspacing="10">
	<tr>
		<th>Nome</th>
		<th>E-mail</th>
		<th>Endere�o</th>
		<th>Data de Nascimento</th>
	</tr>
	<%
	ContatoDao dao = new ContatoDao();
	List<Contato> contatos = dao.getLista();
    SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
	for(Contato contato : contatos){
	%>
	<tr>
		<td class="col-1"><%=contato.getNome() %></td>
		<td class="col-2"><%=contato.getEmail()  %></td>
		<td class="col-3"><%=contato.getEndereco()  %>
		<td class="col-4"><%=dataFormatada.format(contato.getDataNascimento().getTime()) %></td>
	</tr>
	<%
	}
	%>
</table>
</body>
</html>