package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import persistance.DatabaseManager;
import persistence.dao.PlaylistDao;

public class Playlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//System.out.println((String) request.getSession().getAttribute("")+"sono l'utente dentro alla servlet Playlist");
         String user=(String) request.getSession().getAttribute("username");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
         
			PlaylistDao c = DatabaseManager.getInstance().getDaoFactory().getPlaylistDAO();
			
			String action = request.getParameter("action");
			String genere = request.getParameter("genere");

			 if (action.equalsIgnoreCase("demo2")) {
				out.print(gson.toJson(c.generatePlaylist(genere)));
				out.flush();
				out.close();
			//	System.out.println("size playlist genere" + c.generatePlaylist(genere).getPlaylist().size());
			}

			 if (action.equalsIgnoreCase("utente")) {
					out.print(gson.toJson(c.findByUtente(user)));
					out.flush();
					out.close();
				
				}
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
