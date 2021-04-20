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

@WebServlet("/ExecuteModificaAbitanteServlet")
public class ExecuteModificaAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteModificaAbitanteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParameter = request.getParameter("idModificaInput");
		String nomeParameter = request.getParameter("nomeModificaInput");
		String cognomeParameter = request.getParameter("cognomeModificaInput");
		String codiceFiscaleParameter = request.getParameter("codiceFiscaleModificaInput");
		String etaParameter = request.getParameter("etaModificaInput");
		String mottoParameter = request.getParameter("mottoModificaInput");

		RequestDispatcher rd = null;

		if (nomeParameter != null && !nomeParameter.isEmpty() && cognomeParameter != null && !cognomeParameter.isEmpty()
				&& codiceFiscaleParameter != null && !codiceFiscaleParameter.isEmpty() && etaParameter != null
				&& !etaParameter.isEmpty() && etaParameter.matches("[0-9]+") && mottoParameter != null
				&& !mottoParameter.isEmpty()) {

			try {
				if (MyServiceFactory.getAbitanteServiceInstance()
						.aggiorna(new Abitante(Long.parseLong(idParameter), nomeParameter, cognomeParameter,
								codiceFiscaleParameter, Integer.parseInt(etaParameter), mottoParameter)) == 1)
					rd = request.getRequestDispatcher("modificaEffettuata.jsp");
				else
					rd = request.getRequestDispatcher("searchForm.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		rd.forward(request, response);
	}

}
