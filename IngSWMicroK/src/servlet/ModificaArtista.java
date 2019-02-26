package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Artista;
import persistance.DatabaseManager;


public class ModificaArtista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	System.out.println("Sono dentro modif");
		
		Artista registrazioneArtista = new Artista();
		registrazioneArtista.setNomeArtista(request.getParameter("nome"));
		registrazioneArtista.setPathImage(request.getParameter("path"));
		registrazioneArtista.setTextBiografia(request.getParameter("biografia"));
		DatabaseManager.getInstance().getDaoFactory().getArtistaDAO().update(registrazioneArtista);
		response.sendRedirect("amministratore.jsp");
	}

}
