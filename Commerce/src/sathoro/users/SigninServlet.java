package sathoro.users;

import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserRemote;
import models.User;
import sathoro.BaseServlet;

@WebServlet("/users/sign_in")
public class SigninServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UserRemote userBean;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		render("users/sign_in", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> params = getParams(request);

		try {
			User user = userBean.login(params.get("pseudo"), params.get("password"));

			HttpSession session = request.getSession();
			session.setAttribute("sessionId", user.getId());
		} catch (User.LoginException e) {
			setErrorMessage(e.getMessage(), request);
			redirect("/users/sign_in", response);
		}

		setNoticeMessage(
			"Vous êtes maintenant connecté(e).",
			request
		);

		redirect("/", response);
	}
}
