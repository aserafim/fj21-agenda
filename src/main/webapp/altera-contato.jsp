<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="data" %>
<c:import url="cabecalho.jsp"/>
<html>
<link href="css/jquery-ui.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
<title>Alterar Contato</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<body>
	<form action="adicionaContato">
		Nome: <input type="text" name="nome" /><br /> 
		E-mail: <input type="text" name="email" /><br /> 
		Endereço: <input type="text" name="endereco" /><br /> 
		Data Nascimento: <data:campoData id="dataNascimento" /><br /> 
		<input type="submit" value="Gravar" />
	</form>
</body>
<c:import url="rodape.jsp" />
</html>