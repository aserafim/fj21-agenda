<html>
  <body>
  <%--coment�rio em JSP aqui: Primeira p�gina JSP--%>
  <%
  	String mensagem = "Bem vindo ao sistema de agendamento AgendEi!";
  %>
  <%out.print(mensagem);%>
  <br/>
  <%String autor = "Desenvolvido por Alefe Serafim";%>
  <%out.print(autor);%>
  <br/>
  <%System.out.println("Fim da execu��o."); %>
  </body>
</html>