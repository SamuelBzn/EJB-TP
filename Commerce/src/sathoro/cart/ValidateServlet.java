package sathoro.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DeliveryRemote;
import beans.PurchaseRemote;
import beans.UserRemote;
import models.Delivery;
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

		Delivery delivery = deliveryBean.create(user);

		List<Purchase> purchases = cart.stream()
			.map(p -> {
				p.setDelivery(delivery);
				return purchaseBean.save(p);
			})
			.collect(Collectors.toList());

		delivery.setPurchases(purchases);

		// On vide le panier une fois que tout s'est bien passé.
		session.setAttribute("cart", new ArrayList<Purchase>());

		redirect("/", response);
	}
}
