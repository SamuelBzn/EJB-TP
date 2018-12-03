package sathoro.users;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserRemote;
import sathoro.BaseServlet;

@WebServlet("/users/sign_out")
public class SignoutServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UserRemote userBean;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		render("users/sign_out", request, response);
		HttpSession session = request.getSession();
		session.invalidate();
	    response.sendRedirect("/");
	}
}
