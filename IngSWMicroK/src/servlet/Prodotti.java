package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import persistance.DatabaseManager;
import persistence.dao.ArtistaDao;
import persistence.dao.CanzoneDao;
import persistence.dao.UtenteDao;

public class Prodotti extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		//System.out.println((String) request.getSession().getAttribute("username")+"sono l'utente dentro alla servlet prodotti");

			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
         
			CanzoneDao c = DatabaseManager.getInstance().getDaoFactory().getCanzoneDao();
			UtenteDao u = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
			int idCarrello=u.findidCarrello((String) request.getSession().getAttribute("username"));
			
			ArtistaDao a = DatabaseManager.getInstance().getDaoFactory().getArtistaDAO();

			String action = request.getParameter("action");

		//	System.out.println("1 o");

			if (action.equalsIgnoreCase("demo1")) {
				//System.out.println("2 o");

				out.print(gson.toJson(a.findArtista("Ligabue").get(0)));
				out.flush();
				out.close();
			//	System.out.println("3 o" + c.findAll().get(0));

			} else if (action.equalsIgnoreCase("demo2")) {
				out.print(gson.toJson(c.findAll()));
				out.flush();
				out.close();
			//	System.out.println("4 dentro");
				//System.out.println("5 o" + c.findAll().size());
			}


				if (action.equalsIgnoreCase("demo3")) {
					out.print(gson.toJson(u.CercaCanzoniCarrello(idCarrello)));
					out.flush();
					out.close();
					out.print(gson.toJson(idCarrello));
					out.flush();
					out.close();
					
					//System.out.println("dentro demo3"+u.CercaCanzoniCarrello(idCarrello));
				}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
