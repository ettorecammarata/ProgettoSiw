package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistance.DatabaseManager;



public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//addToCart?id=8&from=PaginaPrincipale.jsp
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	 System.out.println("search value is: " + request.getParameter("search"));+
		
			String referer = request.getParameter("from");
			if (request.getParameter("id") != null && !request.getParameter("id").equals("")) {
				//System.out.println("get if");
				doPost(request, response);
			} else {
				request.getRequestDispatcher("carrello.jsp").forward(request, response);
			}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String addToCart = request.getParameter("id");
		String referer = request.getParameter("from");
	//	System.out.println((String) request.getSession().getAttribute("username")+"sono l'utente");
	//System.out.println(DatabaseManager.getInstance().getDaoFactory().getUtenteDAO().addToCart((String) request.getSession().getAttribute("username"),(Integer.valueOf(addToCart) )));
		request.setAttribute("search", request.getParameter("search"));
		request.getRequestDispatcher(referer).forward(request, response);
	}

}
