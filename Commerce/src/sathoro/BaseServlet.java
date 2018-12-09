package sathoro;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Permet de rendre une vue.
	 *
	 * @param template
	 * @param request
	 * @param response
	 */
	public void render(String template, HttpServletRequest request, HttpServletResponse response) {
		try {
			getServletContext().getRequestDispatcher("/templates/" + template + ".jsp")
				.forward(request, response);
		} catch (IOException|ServletException e) {
			System.out.println("Erreur lors du rendu de la vue '" + template + "' :");
			e.printStackTrace();
		}
	}

	/**
	 * Permet de récupérer les paramètres de la requête entrante sous forme
	 * de Map<String, String>.
	 *
	 * Par défaut, il est possible de récupérer les paramètres sous forme de
	 * Map<String, String[]>, du coup pour les formulaires n'impliquant pas
	 * de champs à choix multiple, cela évite de devoir rajouter des `[0]`.
	 *
	 * @param request
	 * @return Un Map contenant uniquement des Strings
	 */
	public Map<String, String> getParams(HttpServletRequest request) {
		Map<String, String[]> rawParams = request.getParameterMap();
		Map<String, String> params = new HashMap<String, String>();

		rawParams.forEach((key, values) -> {
			params.put(key, values[0]);
		});

		return params;
	}

	/**
	 * Permet de rediriger vers une URL ou une ressource donnée.
	 *
	 * @param location
	 * @param response
	 */
	public void redirect(String location, HttpServletResponse response) {
		try {
			response.sendRedirect(location);
		} catch (IOException e) {
			System.out.println("Erreur lors de la redirection vers '" + location + "' :");
			e.printStackTrace();
		}
	}

	/**
	 * Permet de définir facilement un message d'erreur à afficher côté vue.
	 *
	 * @param message
	 * @param request
	 */
	public void setErrorMessage(String message, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("error", message);
	}

	/**
	 * Permet de définir facilement un message de succés à afficher côté vue.
	 *
	 * @param message
	 * @param request
	 */
	public void setNoticeMessage(String message, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("notice", message);
	}

}
