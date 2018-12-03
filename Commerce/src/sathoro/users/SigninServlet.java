package sathoro.users;

import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserRemote;
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
			userBean.login(params.get("pseudo"), params.get("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		redirect("/", response);
	}
}
