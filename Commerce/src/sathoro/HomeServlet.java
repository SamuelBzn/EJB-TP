package sathoro;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class HomeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.render("index", request, response);
	}
}
