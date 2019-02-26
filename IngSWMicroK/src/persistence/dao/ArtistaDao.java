package persistence.dao;

import java.sql.SQLException;
import java.util.List;
import model.Artista;

public interface ArtistaDao {	
	public void save(Artista artista) throws SQLException;  // Create
	public List<Artista> findAll();       
	public void update(Artista artista); //Update
	public void delete(Artista artista); //Delete	
	public List<Artista> findArtista(String searchQuery);
	public Artista findByName(String nome);
}