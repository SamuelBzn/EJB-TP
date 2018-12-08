package sathoro.admin.vehicles;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.VehicleRemote;
import sathoro.AdminServlet;

@WebServlet("/admin/vehicles")
public class IndexServlet extends AdminServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	VehicleRemote vehicleBean;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("vehicles", vehicleBean.findAll());

		this.render("admin/vehicles/index", request, response);
	}
}
