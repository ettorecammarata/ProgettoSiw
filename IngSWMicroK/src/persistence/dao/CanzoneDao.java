package persistence.dao;



import java.sql.SQLException;

import model.Canzone;
import model.Playlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public interface CanzoneDao{	
	public void save(Canzone canzone) throws SQLException;  // Create
//	public Canzone findByPrimaryKey(String matricola);     // Retrieve
	public List<Canzone> findAll();       
	public void update(Canzone canzone); //Update
	public void delete(Canzone canzone); //Delete	
	List<Canzone> findCanzone(String searchQuery);
	List<Canzone> findCanzoneByArtista(String searchQuery);

	List<Canzone> findForGenere(String genere);
	List<Canzone> findTop5ForGenere(String genere);
	void delete(Integer idCanzone, String email);
//	void cercaStottostringa(String s);
	public Canzone findById(int int1);
	ArrayList<Playlist> findByAlbum(String searchQuery);
	
	
}


