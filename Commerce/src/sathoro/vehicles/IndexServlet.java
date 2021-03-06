package sathoro.vehicles;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.VehicleRemote;
import sathoro.BaseServlet;

@WebServlet("/")
public class IndexServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private VehicleRemote vehicleBean;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("vehicles", vehicleBean.findAll());

		this.render("vehicles/index", request, response);
	}
}
