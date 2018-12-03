package sathoro.users;

import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserRemote;
import sathoro.BaseServlet;

@WebServlet("/users/sign_up")
public class SignupServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UserRemote userBean;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		render("users/sign_up", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> params = getParams(request);

		System.out.println("Pseudo : " + params.get("pseudo"));
		System.out.println("Email : " + params.get("email"));
		System.out.println("Password : " + params.get("password"));
		System.out.println("Devise : " + params.get("devise"));

		try {
			userBean.create(
			    params.get("pseudo"),
			    params.get("email"),
			    params.get("password"),
			    Integer.parseInt(params.get("devise")),
			    0
			);
		} catch (Exception e) {
			e.printStackTrace();
		}

		redirect("/", response);
	}
}
