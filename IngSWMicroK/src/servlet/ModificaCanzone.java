package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Artista;
import model.Canzone;
import model.IndiceDiGradimento;
import persistance.DatabaseManager;


public class ModificaCanzone extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	System.out.println("seeeeeeeeeeeeee");
		Canzone registrazioneCanzone = new Canzone();
		registrazioneCanzone.setIdCanzone(Integer.valueOf((request.getParameter("id"))));
		registrazioneCanzone.setTitolo(request.getParameter("titolo"));
		registrazioneCanzone.setArtista(new Artista(request.getParameter("artista")));
		registrazioneCanzone.setAlbum(request.getParameter("album"));
		registrazioneCanzone.setAnno(2008);
		registrazioneCanzone.setCasaDiscografica(request.getParameter("casaDiscografica"));
		registrazioneCanzone.setGenere(request.getParameter("genere"));
		registrazioneCanzone.setPrezzo(1);
		registrazioneCanzone.setUrl(request.getParameter("url"));
		registrazioneCanzone.setIndiceDiGradimento(new IndiceDiGradimento(6));
		DatabaseManager.getInstance().getDaoFactory().getCanzoneDao().update(registrazioneCanzone);
		response.sendRedirect("amministratore.jsp");
	}

}
