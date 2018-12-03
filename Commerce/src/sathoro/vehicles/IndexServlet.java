package sathoro.vehicles;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.VehicleBean;
import beans.VehicleRemote;
import models.Vehicle;
import sathoro.BaseServlet;

public class IndexServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	VehicleRemote vehicleBean;

	public IndexServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("vehicles", vehicleBean.findAll());
			this.render("vehicles/index", request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
