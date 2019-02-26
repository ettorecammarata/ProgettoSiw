package persistance.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Artista;
import persistance.DataSource;
import persistance.DatabaseManager;
import persistance.PersistenceException;
import persistence.dao.FollowDao;

public class FollowDaoJDBC implements FollowDao{

	private DataSource dataSource;
	private Connection connection = null;
	
	public FollowDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource ; 
	}

	@Override
	public void creaRelazione(int idartista, int idutente) {
		 connection = this.dataSource.getConnection();
		 PreparedStatement statement = null;
		try { 
			String insert = "insert into follow  ( id_utente , id_artista) values (? , ? )"  ;
			statement = connection.prepareStatement(insert);
			statement.setInt(1, idartista);
			statement.setInt(2, idutente);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	@Override
	public void rimuoviRelazione(int idutente, int idartista) {
		 connection = this.dataSource.getConnection();
		 PreparedStatement statement = null;
			try {
				String query = "DELETE FROM follow WHERE id_utente =? AND id_artista = ? ";
				statement = connection.prepareStatement(query);
				statement.setInt( 1, idutente) ;
				statement.setInt( 2, idartista) ;
				statement.executeUpdate() ; 
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}	 finally {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new PersistenceException(e.getMessage());
				}
			}
		
	}

	@Override
	public ArrayList<Artista> getListaSeguiti(int idUtente) {
		 connection = this.dataSource.getConnection();
		 PreparedStatement statement = null;
		 ArrayList<Artista> artisti = new ArrayList<>() ; 
			try { 
				String query = "select * from follow where id_utente = (?)"  ; 
				statement = connection.prepareStatement(query) ; 
				statement.setInt(1, idUtente) ; 
				ResultSet result = statement.executeQuery() ; 
				while (result.next () ) {
					Artista temp = new Artista() ; 
					temp.setIdArtista(result.getInt("idartista"));
					artisti.add( DatabaseManager.getInstance().getDaoFactory().getArtistaDAO().findByName(temp.getNomeArtista())) ;
				}
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}	 finally {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new PersistenceException(e.getMessage());
				}
			}
		return artisti ;
	}
	
	public static void main(String[] args) {
		DatabaseManager.getInstance().getDaoFactory().getFollowDao().rimuoviRelazione(2, 7);
	}
}
