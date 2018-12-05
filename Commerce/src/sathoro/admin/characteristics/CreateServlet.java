package sathoro.admin.characteristics;

import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CategoryRemote;
import beans.CharacteristicRemote;
import models.Category;
import models.Characteristic;
import sathoro.BaseServlet;

@WebServlet("/admin/characteristics/new")
public class CreateServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CharacteristicRemote characteristicBean;

	@EJB
	private CategoryRemote categoryBean;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("categories", categoryBean.findAll());
		request.setAttribute("characteristic", new Characteristic());

		render("admin/characteristics/form", request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> params = getParams(request);

		Category category = categoryBean.find(Integer.parseInt(params.get("category_id")));

		characteristicBean.create(
			params.get("name"),
			Double.parseDouble(params.get("price")),
			category
		);

		redirect("/admin/characteristics", response);
	}
}
