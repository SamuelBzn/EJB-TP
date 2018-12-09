package sathoro.cart;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Purchase;
import sathoro.BaseServlet;

@WebServlet("/cart")
public class ShowServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Integer sessionId = (Integer)session.getAttribute("sessionId");

		if (sessionId == null) {
			setErrorMessage(
				"Veuillez vous connecter avant de continuer.",
				request
			);

			redirect("/", response);
			return;
		}

		Object rawCart = session.getAttribute("cart");
		ArrayList<Purchase> cart;

		if (rawCart != null) {
			cart = (ArrayList<Purchase>)rawCart;
		} else {
			cart = new ArrayList<Purchase>();
		}

		request.setAttribute(
			"cartTotal",
			cart.stream().mapToDouble(e -> e.getUnitPrice() * e.getQuantity()).sum()
		);

		render("cart/show", request, response);
	}
}
