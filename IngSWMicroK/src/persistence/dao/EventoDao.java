package persistence.dao;

import java.sql.SQLException;
import java.util.List;
import model.Evento;

public interface EventoDao {
	public void save(Evento evento) throws SQLException; // Create

	public List<Evento> findAll();

	public void update(Evento evento); // Update

	public void delete(Evento evento); // Delete
}
