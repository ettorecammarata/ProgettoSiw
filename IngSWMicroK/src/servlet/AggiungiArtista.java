package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Artista;
import persistance.DatabaseManager;



public class AggiungiArtista extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Artista registrazioneArtista = new Artista();
		registrazioneArtista.setNomeArtista(request.getParameter("nome"));
		registrazioneArtista.setPathImage(request.getParameter("path"));
		registrazioneArtista.setTextBiografia(request.getParameter("biografia"));
	
		System.out.println(registrazioneArtista.getNomeArtista()+" "+registrazioneArtista.getTextBiografia());
		try {
			DatabaseManager.getInstance().getDaoFactory().getArtistaDAO().save(registrazioneArtista);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("amministratore.jsp");

	}

}
