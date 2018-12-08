package sathoro.admin.categories;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CategoryRemote;
import sathoro.AdminServlet;

@WebServlet("/admin/categories/edit")
public class EditServlet extends AdminServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CategoryRemote categoryBean;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("category", categoryBean.find(id));

		render("admin/categories/form", request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");

		categoryBean.update(id, name);

		redirect("/admin/categories", response);
	}
}
