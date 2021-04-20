package it.helloabitante.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.dao.DB_Mock;
import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;
import it.helloabitante.service.abitante.AbitanteService;

@WebServlet("/ExecuteDeleteAbitanteServlet")
public class ExecuteDeleteAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteDeleteAbitanteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parametroIdDellAbitanteDiCuiVoglioEliminare = request.getParameter("idAbitante");
		int index = Integer.parseInt(parametroIdDellAbitanteDiCuiVoglioEliminare);

		AbitanteService abitanteServiceInstance = MyServiceFactory.getAbitanteServiceInstance();

		RequestDispatcher rd = null;

		Abitante result = DB_Mock.LISTA_ABITANTI.get(index);

		try {
			if (abitanteServiceInstance.rimuovi(result) == 1)
				rd = request.getRequestDispatcher("utenteCancellato.jsp");
			else
				rd = request.getRequestDispatcher("searchForm.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

		rd.forward(request, response);
	}

}
