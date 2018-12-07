package sathoro.cart;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Purchase;
import sathoro.BaseServlet;

@WebServlet("/cart/remove")
public class RemoveServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Integer sessionId = (Integer)session.getAttribute("sessionId");

		// Utilisateur déconnecté
		if (sessionId == null) {
			redirect("/", response);
			return;
		}

		Object rawCart = session.getAttribute("cart");

		// Panier vide
		if (rawCart == null) {
			redirect("/", response);
			return;
		}

		// Mise à jour du panier
		int index = Integer.parseInt(request.getParameter("index"));
		ArrayList<Purchase> cart = (ArrayList<Purchase>)rawCart;

		cart.remove(index);
		session.setAttribute("cart", cart);

		redirect("/cart", response);
	}
}
