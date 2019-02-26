package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Artista;
import model.Evento;
import persistance.DatabaseManager;
import persistance.JDBC.ArtistaDaoJDBC;
import persistence.dao.EventoDao;

public class AggiungiEvento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String data = request.getParameter("data"); 
		String startDate=data;
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = null;
		try {
			date = sdf1.parse(startDate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		java.sql.Date dataEvento = new java.sql.Date(date.getTime()); 

		Evento e = new Evento() ; 
		
		Artista artistaTmp = new Artista() ; 
		artistaTmp.setNomeArtista(request.getParameter("artista"));
		e.setArtista(artistaTmp);
		e.setLuogoEvento(request.getParameter("luogo"));
		e.setNomeEvento(request.getParameter("nomeevento"));
		e.setPrezzoEvento(Double.valueOf(request.getParameter("prezzo")));
		e.setDataEvento(dataEvento); 
		
		EventoDao eventoDao = DatabaseManager.getInstance().getDaoFactory().getEventoDAO() ; 
		try {
			eventoDao.save(e) ;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}  
		
		this.getServletContext().getRequestDispatcher("/loginPage.jsp").forward(request, response);

	}
	
	

}
