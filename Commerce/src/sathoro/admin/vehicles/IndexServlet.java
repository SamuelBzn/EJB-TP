package sathoro.admin.vehicles;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sathoro.BaseServlet;

public class IndexServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.render("admin/vehicles/index", request, response);
	}
}
