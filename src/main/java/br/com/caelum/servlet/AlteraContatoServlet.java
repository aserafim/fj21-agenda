package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.Contato;
import br.com.caelum.agenda.ContatoDao;

@WebServlet("/alteraContato")
public class AlteraContatoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
				throws IOException, ServletException{
		// busca o writer
				PrintWriter out = response.getWriter();
		// buscando os parâmetros no request
				String id = request.getParameter("id");
				String nome = request.getParameter("nome");
				String endereco = request.getParameter("endereco");
				String email = request.getParameter("email");
				String dataEmTexto = request.getParameter("dataNascimento");
				Calendar dataNascimento = null;
		// fazendo a conversão da data
				try {
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
					dataNascimento = Calendar.getInstance();
					dataNascimento.setTime(date);
				} catch (ParseException e) {
					out.println("Erro de conversão da data");
					return; // para a execução do método
				}
				//monta um objeto contato
				Contato contato = new Contato();
				contato.setId(Long.parseLong(id));
				contato.setNome(nome);
				contato.setEndereco(endereco);
				contato.setEmail(email);
				contato.setDataNascimento(dataNascimento);
		//salva o contato
				ContatoDao dao = null;
				try {
					dao = new ContatoDao();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dao.alteraContato(contato);

		//Redireciona o fluxo para o arquivo jsp corresondente
				RequestDispatcher rd = request.getRequestDispatcher("/contato-alterado.jsp");
				rd.forward(request, response);
			}
}
