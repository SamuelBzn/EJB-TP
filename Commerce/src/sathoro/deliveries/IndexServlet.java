package sathoro.deliveries;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DeliveryRemote;
import models.Delivery;
import sathoro.BaseServlet;

@WebServlet("/deliveries")
public class IndexServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

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

		List<Delivery> deliveries = deliveryBean.deliveriesFor(sessionId);

		request.setAttribute("deliveries", deliveries);

		render("deliveries/index", request, response);
	}
}
