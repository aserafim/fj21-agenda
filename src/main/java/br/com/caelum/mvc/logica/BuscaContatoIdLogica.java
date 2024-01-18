package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.Contato;
import br.com.caelum.agenda.ContatoDao;

public class BuscaContatoIdLogica implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		long id = Long.parseLong(req.getParameter("id"));
		
		Contato contato = new Contato();
		contato.setId(id);
		
		ContatoDao dao = new ContatoDao();
		contato = dao.consultaId(id);
		System.out.print(contato.getEmail());
		
		req.setAttribute("contato", contato);
	
		return "lista-contato.jsp";
		
	}
	

}
