package sathoro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void render(String template, HttpServletRequest request, HttpServletResponse response) {
		try {
			getServletContext().getRequestDispatcher("/templates/" + template + ".jsp")
			.forward(request, response);
		} catch (IOException|ServletException e) {
			System.out.println("Erreur lors du rendu de la vue '" + template + "' :");
			e.printStackTrace();
		}
	}
}
