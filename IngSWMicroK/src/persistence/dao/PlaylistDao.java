
package persistence.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Canzone;
import model.Playlist;


public interface PlaylistDao {

		public void save(Playlist corso) throws SQLException;
		public Playlist generatePlaylist(String genere);  
		public ArrayList<Playlist> findByUtente (String name) ; 
		public void update (Playlist p , String nome ) ;
		public void delete (Playlist p ) ; 
		public void addSong (Playlist p ,Canzone c) ; 
		public void removeSong (Playlist p ,Canzone c) ;
		
		
	/*	public Corso findByPrimaryKey(Long codice);     // Retrieve
		public List<Corso> findAll();       
		public void update(Corso cors); //Delete	o); //Update
		public void delete(Corso corso*/
	}
