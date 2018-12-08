package sathoro.admin.characteristics;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CharacteristicRemote;
import sathoro.AdminServlet;

@WebServlet("/admin/characteristics")
public class IndexServlet extends AdminServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CharacteristicRemote characteristicsBean;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("characteristics", characteristicsBean.findAll());

		render("admin/characteristics/index", request, response);
	}
}
