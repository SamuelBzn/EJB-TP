package sathoro.admin.characteristics;


import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CategoryRemote;
import beans.CharacteristicRemote;
import models.Category;
import sathoro.AdminServlet;

@WebServlet("/admin/characteristics/edit")
public class EditServlet extends AdminServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	CharacteristicRemote characteristicBean;

	@EJB
	CategoryRemote categoryBean;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));

		request.setAttribute("categories", categoryBean.findAll());
		request.setAttribute("characteristic", characteristicBean.find(id));

		render("admin/characteristics/form", request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> params = getParams(request);

		int id         = Integer.parseInt(params.get("id"));
		int categoryId = Integer.parseInt(params.get("category_id"));

		Category category = categoryBean.find(categoryId);

		characteristicBean.update(
			id,
			request.getParameter("name"),
			Double.parseDouble(request.getParameter("price")),
			category
		);

		redirect("/admin/characteristics", response);
	}
}
