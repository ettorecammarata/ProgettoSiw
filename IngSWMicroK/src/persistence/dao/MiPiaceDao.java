package persistence.dao;

import java.util.ArrayList;

import model.Canzone;

public interface MiPiaceDao {

	public void creaRelazione (int idutente , int idcanzone) ; 
	public void rimuoviRelazione (int idutente , int idcanzone) ;
	public ArrayList<Canzone> getListaPiaciuti (int idUtente ) ; 
	
}
