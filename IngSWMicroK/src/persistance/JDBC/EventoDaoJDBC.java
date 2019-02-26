package persistance.JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Artista;
import model.Evento;
import persistance.DataSource;
import persistance.DatabaseManager;
import persistence.dao.EventoDao;

public class EventoDaoJDBC implements EventoDao{

	private DataSource dataSource;
	private Connection connection = null;
	private PreparedStatement statement = null;
	
	
	public EventoDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	

	
	
	@Override
	public void save(Evento evento) throws SQLException {
		try {
			addEvento(evento);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addEvento(Evento evento) {
		connection = this.dataSource.getConnection();
		try {
			
			Boolean eventoPresente = false;
			String sql = "SELECT * FROM evento WHERE nomeevento= ?";
			this.statement = this.connection.prepareStatement(sql);
			statement.setString(1, evento.getNomeEvento());
			System.out.println(evento.getNomeEvento());
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String nomeEvento = rs.getString("nomeevento");
				Date dataEvento = rs.getDate("data") ; 
				if (nomeEvento.equals(evento.getNomeEvento()) && dataEvento.equals(evento.getDataEvento()))
					eventoPresente = true;
			}
			if (eventoPresente == false ) {
				statement.addBatch();
				String insert = "insert into evento(nomeevento , data , luogo , idartista , prezzo) values (?,?,?,?,?)";
				statement = connection.prepareStatement(insert);
				statement.setString(1 , evento.getNomeEvento());
				statement.setDate(2 , evento.getDataEvento());
				statement.setString(3 , evento.getLuogoEvento());
				System.err.println("id artista "+evento.getArtista().getIdArtista());
				statement.setInt(4, evento.getArtista().getIdArtista());
				statement.setDouble(5 , evento.getPrezzoEvento());
				statement.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}


	@Override
	public List<Evento> findAll() {
		return null;
	}

	@Override
	public void update(Evento evento) {
		
	}

	@Override
	public void delete(Evento evento) {
		
	}

}
