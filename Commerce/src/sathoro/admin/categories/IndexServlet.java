package sathoro.admin.categories;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CategoryRemote;
import sathoro.BaseServlet;

@WebServlet("/admin/categories")
public class IndexServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CategoryRemote categoryBean;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("categories", categoryBean.findAll());

		this.render("admin/categories/index", request, response);
	}
}
