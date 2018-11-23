package sathoro.users;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sathoro.BaseServlet;

@WebServlet("/users/sign_in")
public class SigninServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		render("users/sign_in", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> params = getParams(request);

		System.out.println("Pseudo : " + params.get("pseudo"));
		System.out.println("Password : " + params.get("password"));

		// TODO: Connexion avec le bean des users. Quelque chose du genre :
		//
		//   userBean.login(params.get("pseudo"), params.get("password"));
		//
		// La méthode retournerait si la connexion a réussit ou non.
		//
		// Il faudrait aussi gérer la partie session pour que l'interface soit
		// adaptée une fois que l'utilisateur est connecté.
		//
		//    HttpSession session = request.getSession();
		//    session.setAttribute("user", params.get("pseudo"));

		redirect("/", response);
	}
}
