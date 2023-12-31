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

<table cellspacing="10">
	<tr>
		<th>Nome</th>
		<th>E-mail</th>
		<th>Endereço</th>
		<th>Data de Nascimento</th>
	</tr>
	<%
	ContatoDao dao = new ContatoDao();
	List<Contato> contatos = dao.getLista();
    SimpleDateFormat dataFormatada = new SimpleDateFormat();
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