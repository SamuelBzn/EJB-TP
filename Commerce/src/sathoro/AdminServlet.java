package sathoro;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserRemote;
import models.User;

public class AdminServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private UserRemote userBean;

	/**
	 * Permet de s'assurer qu'un utilisateur non identifié ou non admin ne
	 * puisse accéder à la partie administration du site.
	 *
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer sessionId = (Integer)session.getAttribute("sessionId");

		if (sessionId == null) {
			setErrorMessage("Vous n'avez pas le droit d'être ici.", request);
			redirect("/", response);
			return;
		}

		User user = userBean.find(sessionId);

		if (!user.isAdmin()) {
			setErrorMessage("Vous n'avez pas le droit d'être ici.", request);
			redirect("/", response);
			return;
		}

		super.service(request, response);
	}
}
