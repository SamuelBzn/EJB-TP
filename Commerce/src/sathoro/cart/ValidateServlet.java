package sathoro.cart;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DeliveryRemote;
import beans.PurchaseRemote;
import beans.UserRemote;
import models.Purchase;
import models.User;
import sathoro.BaseServlet;

@WebServlet("/cart/validate")
public class ValidateServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private UserRemote userBean;

	@EJB
	private PurchaseRemote purchaseBean;

	@EJB
	private DeliveryRemote deliveryBean;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Integer sessionId = (Integer)session.getAttribute("sessionId");

		if (sessionId == null) {
			redirect("/", response);
			return;
		}

		Object rawCart = session.getAttribute("cart");

		if (rawCart == null) {
			redirect("/", response);
			return;
		}

		// Création de la commande avec tous les achats
		ArrayList<Purchase> cart = (ArrayList<Purchase>)rawCart;
		User user = userBean.find(sessionId);

		try {
			deliveryBean.create(cart, user);
		} catch (DeliveryRemote.OutOfStockException e) {
			request.setAttribute("error", e.getMessage());

			render("cart/out_of_stock", request, response);
			return;
		}

		// On vide le panier une fois que tout s'est bien passé.
		session.setAttribute("cart", new ArrayList<Purchase>());

		redirect("/", response);
	}
}
