<html>
  <body>
  <%--comentário em JSP aqui: Primeira página JSP--%>
  <%
  	String mensagem = "Bem vindo ao sistema de agendamento AgendEi!";
  %>
  <%out.print(mensagem);%>
  <br/>
  <%String autor = "Desenvolvido por Alefe Serafim";%>
  <%out.print(autor);%>
  <br/>
  <%System.out.println("Fim da execução."); %>
  </body>
</html>