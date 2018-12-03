package sathoro.admin.vehicles;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CategoryRemote;
import sathoro.BaseServlet;

@WebServlet("/admin/categories/new")
public class CreateServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	// TODO:
	// @EJB
	// VehicleBean vehicleBean;

	@EJB
	private CategoryRemote categoryBean;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("categories", categoryBean.findAll());

		this.render("admin/vehicles/new", request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		// Map<String, String> params = getParams(request);

		// TODO: Faire le bean pour créer un véhicule
		//
		//   vehicleBean.create(
		//       params.get("name"),
		//       params.get("description"),
		//       (double)params.get("price"),
		//       (int)params.get("stock"),
		//       (int)params.get("category_id")
		//   )
		//
		// La méthode lance une exception si le modèle n'est pas valide.

		this.render("admin/vehicles/index", request, response);
	}
}
