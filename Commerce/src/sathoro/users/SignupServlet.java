package sathoro.users;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sathoro.BaseServlet;

@WebServlet("/users/sign_up")
public class SignupServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

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

		// TODO: Connexion avec le bean des users. Quelque chose du genre :
		//
		//   userBean.register(
		//       params.get("pseudo"),
		//       params.get("email"),
		//       ...
		//   );
		//
		// La méthode retournerait le nécessaire pour savoir s'il y a eu des erreurs
		// lors de l'inscription ou non.

		redirect("/", response);
	}
}
