package persistence.dao;

import java.util.ArrayList;

import model.Artista;

public interface FollowDao {

	public void creaRelazione (int idutente , int idartista) ; 
	public void rimuoviRelazione (int idutente , int idartista) ;
	public ArrayList<Artista> getListaSeguiti (int idUtente ) ; 
	
}
