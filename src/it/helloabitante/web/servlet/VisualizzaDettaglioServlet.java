package it.helloabitante.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;
import it.helloabitante.service.abitante.AbitanteService;

@WebServlet("/VisualizzaDettaglioServlet")
public class VisualizzaDettaglioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VisualizzaDettaglioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parametroIdDellAbitanteDiCuiVoglioIlDettaglio = request.getParameter("idDaInviareComeParametro");

		AbitanteService abitanteServiceInstance = MyServiceFactory.getAbitanteServiceInstance();

		RequestDispatcher rd = request.getRequestDispatcher("dettaglio.jsp");

		Abitante result = null;

		try {
			result = abitanteServiceInstance
					.caricaSingoloElemento(Long.parseLong(parametroIdDellAbitanteDiCuiVoglioIlDettaglio));
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("abitante_attribute", result);
		rd.forward(request, response);

	}

}
