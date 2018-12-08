package sathoro.admin.vehicles;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CategoryRemote;
import beans.CharacteristicRemote;
import beans.VehicleRemote;
import models.Category;
import models.Characteristic;
import models.Vehicle;
import sathoro.AdminServlet;

@WebServlet("/admin/vehicles/new")
public class CreateServlet extends AdminServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private VehicleRemote vehicleBean;

	@EJB
	private CategoryRemote categoryBean;

	@EJB
	private CharacteristicRemote characteristicBean;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("categories", categoryBean.findAll());
		request.setAttribute("vehicle", new Vehicle());
		request.setAttribute("groups", categoryBean.groupsOfCharacteristics());

		this.render("admin/vehicles/form", request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> params = getParams(request);

		int categoryId = Integer.parseInt(params.get("category_id"));
		Category category = categoryBean.find(categoryId);

		// On récupère la liste des ids spécifiés via les checkbox
		// du formulaire et on fait appel au bean associé pour récupérer
		// des instances de la classe `Characteristic` à associer.
		List<Integer> charsIds = Arrays.asList(request.getParameterValues("characteristics"))
				.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toList());

		List<Characteristic> characteristics = characteristicBean.findSome(charsIds);

		vehicleBean.create(
			params.get("name"),
			params.get("description"),
			Double.parseDouble(params.get("price")),
			Integer.parseInt(params.get("stock")),
			category,
			characteristics
		);

		redirect("/admin/vehicles", response);
	}
}
