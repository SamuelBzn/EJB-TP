package sathoro.cart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CharacteristicRemote;
import beans.VehicleRemote;
import models.Characteristic;
import models.Purchase;
import models.Vehicle;
import sathoro.BaseServlet;

@WebServlet("/cart/add")
public class AddServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CharacteristicRemote characteristicBean;

	@EJB
	private VehicleRemote vehicleBean;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		Integer sessionId = (Integer)session.getAttribute("sessionId");

		// TODO: Afficher un message d'erreur si l'utilisateur
		// n'est pas connecté.
		if (sessionId == null) {
			redirect("/users/sign_in", response);
			return;
		}

		int id = Integer.parseInt(request.getParameter("id"));
		String[] charIds = request.getParameterValues("characteristics");
		List<Integer> ids;

		if (charIds != null) {
			ids = Arrays.asList(charIds)
					.stream()
					.map(Integer::parseInt)
					.collect(Collectors.toList());
		} else {
			ids = new ArrayList<Integer>();
		}

		Vehicle vehicle                      = vehicleBean.find(id);
		int quantity                         = Integer.parseInt(request.getParameter("quantity"));
		List<Characteristic> characteristics = characteristicBean.findSome(ids);

		Purchase purchase = new Purchase(vehicle, quantity, characteristics);

		// Chargement du panier si jamais il existe déjà, sinon création
		// puis ajout du nouvel élément au panier.
		Object rawCart = session.getAttribute("cart");
		ArrayList<Purchase> cart;

		if (rawCart != null) {
			cart = (ArrayList<Purchase>)rawCart;
		} else {
			cart = new ArrayList<Purchase>();
		}

		cart.add(purchase);
		session.setAttribute("cart", cart);

		redirect("/", response);
	}
}
