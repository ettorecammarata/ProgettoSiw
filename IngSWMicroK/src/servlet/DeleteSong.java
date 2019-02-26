package servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistance.DatabaseManager;



public class DeleteSong extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//System.out.println("SONO DENTRO LA SRVET");
		String backTo = request.getParameter("from");
		String idCarrello=request.getParameter("IdCart");
		//System.out.println(backTo);
	 if (request.getParameter("cartCanzoneId") != null && !request.getParameter("cartCanzoneId").equals("")) {
			int id_canzone = Integer.valueOf(request.getParameter("cartCanzoneId"));
			
			DatabaseManager.getInstance().getDaoFactory().getUtenteDAO().RimuoviDalCarrello( Integer.valueOf(idCarrello), id_canzone);

			request.getRequestDispatcher("/"+backTo).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("loginPage.jsp").forward(request, response);
}

}
