package sathoro.vehicles;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.VehicleRemote;
import sathoro.BaseServlet;

@WebServlet("/vehicle")
public class ShowServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private VehicleRemote vehicleBean;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("vehicle", vehicleBean.find(id));

		render("vehicles/show", request, response);
	}
}
