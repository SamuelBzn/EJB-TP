package sathoro.admin.categories;

import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CategoryRemote;
import models.Category;
import sathoro.AdminServlet;

@WebServlet("/admin/categories/new")
public class CreateServlet extends AdminServlet {
	public static final long serialVersionUID = 1L;

	@EJB
	private CategoryRemote categoryBean;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("category", new Category());

		this.render("admin/categories/form", request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> params = getParams(request);

		categoryBean.create(params.get("name"));

		redirect("/admin/categories", response);
	}
}
