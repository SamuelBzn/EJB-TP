package sathoro.vehicles;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sathoro.BaseServlet;

public class IndexServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public IndexServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.render("vehicles/index", request, response);
	}
}
