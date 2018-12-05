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
import sathoro.BaseServlet;

@WebServlet("/admin/vehicles/edit")
public class EditServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private VehicleRemote vehicleBean;

	@EJB
	private CategoryRemote categoryBean;

	@EJB
	private CharacteristicRemote characteristicBean;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		Vehicle vehicle = vehicleBean.find(id);

		request.setAttribute("categories", categoryBean.findAll());
		request.setAttribute("groups", categoryBean.groupsOfCharacteristics());
		request.setAttribute("vehicle", vehicle);

		render("admin/vehicles/form", request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> params = getParams(request);

		int id = Integer.parseInt(params.get("id"));
		int categoryId = Integer.parseInt(params.get("category_id"));

		Category category = categoryBean.find(categoryId);

		List<Integer> charIds = Arrays.asList(request.getParameterValues("characteristics"))
				.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		List<Characteristic> characteristics = characteristicBean.findSome(charIds);

		vehicleBean.update(
			id,
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
