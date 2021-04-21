package it.helloabitante.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;

@WebServlet("/ExecuteInsertAbitanteServlet")
public class ExecuteInsertAbitanteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ExecuteInsertAbitanteServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeParameter = request.getParameter("nomeInput");
		String cognomeParameter = request.getParameter("cognomeInput");
		String codFisParameter = request.getParameter("codFisInput");
		String etaParameter = request.getParameter("etaInput");
		String mottoParameter = request.getParameter("mottoInput");

		RequestDispatcher rd = null;
		if (nomeParameter != null && cognomeParameter != null && codFisParameter != null && etaParameter != null
				&& mottoParameter != null && !nomeParameter.isEmpty() && !cognomeParameter.isEmpty()
				&& !codFisParameter.isEmpty() && !etaParameter.isEmpty() && !mottoParameter.isEmpty()) {

			try {
				if(MyServiceFactory.getAbitanteServiceInstance().inserisci(new Abitante(nomeParameter, cognomeParameter,
						codFisParameter, Integer.parseInt(etaParameter), mottoParameter)) == 1)
					rd = request.getRequestDispatcher("inserimentoEffettuato.jsp");
				else 
					rd = request.getRequestDispatcher("searchForm.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
			

		} else {
			request.setAttribute("error_input", "Errore di inserimento dei valori");
			rd = request.getRequestDispatcher("insert.jsp");
		}
		rd.forward(request, response);
	}

}
