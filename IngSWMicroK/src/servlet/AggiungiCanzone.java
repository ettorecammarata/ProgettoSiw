package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Artista;
import model.Canzone;
import model.IndiceDiGradimento;
import persistance.DatabaseManager;



public class AggiungiCanzone extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	System.out.println(request.getParameter("modifica")+"**************************");
		if(request.getParameter("modifica").equalsIgnoreCase("modifica"))
			{RequestDispatcher dispatcher =request.getRequestDispatcher("modificaCanzone");
		//	System.out.println("****************");
			dispatcher.forward(request, response);
			}else {
		
		Canzone registrazioneCanzone = new Canzone();
		registrazioneCanzone.setTitolo(request.getParameter("titolo"));
		registrazioneCanzone.setArtista(new Artista(request.getParameter("artista")));
		registrazioneCanzone.setAlbum(request.getParameter("album"));
		registrazioneCanzone.setAnno(Integer.valueOf(request.getParameter(("anno"))));
		registrazioneCanzone.setCasaDiscografica(request.getParameter("casaDiscografica"));
		registrazioneCanzone.setGenere(request.getParameter("genere"));
		registrazioneCanzone.setPrezzo(1);
		registrazioneCanzone.setUrl(request.getParameter("url"));
		registrazioneCanzone.setIndiceDiGradimento(new IndiceDiGradimento(6));


	
		//System.out.println(registrazioneCanzone.getTitolo()+" "+registrazioneCanzone.getGenere());
		try {
			DatabaseManager.getInstance().getDaoFactory().getCanzoneDao().save(registrazioneCanzone);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("amministratore.jsp");
	}
		
	}
}
