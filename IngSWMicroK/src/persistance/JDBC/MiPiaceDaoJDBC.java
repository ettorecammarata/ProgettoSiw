package persistance.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Canzone;
import persistance.DataSource;
import persistance.DatabaseManager;
import persistance.PersistenceException;
import persistence.dao.MiPiaceDao;

public class MiPiaceDaoJDBC implements persistence.dao.MiPiaceDao{

	private DataSource dataSource;
	private Connection connection = null;

	public MiPiaceDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource ; 
	}

	@Override
	public void creaRelazione(int idcanzone, int idutente) {
		 connection = this.dataSource.getConnection();
		 PreparedStatement statement = null;
		try { 
			String insert = "insert into mipiace ( id_utente , id_canzone) values (? , ? )"  ;
			statement = connection.prepareStatement(insert);
			statement.setInt(1, idcanzone);
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
	public void rimuoviRelazione(int idutente, int idcanzone) {
		 connection = this.dataSource.getConnection();
		 PreparedStatement statement = null;
			try {
				String query = "DELETE FROM mipiace WHERE id_utente =? AND id_canzone = ? ";
				statement = connection.prepareStatement(query);
				statement.setInt( 1, idutente) ;
				statement.setInt( 2, idcanzone) ;
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
public ArrayList<Canzone> getListaPiaciuti(int idUtente) {
	 connection = this.dataSource.getConnection();
	 PreparedStatement statement = null;
	 ArrayList<Canzone> canzoni = new ArrayList<>() ; 
		try { 
			String query = "select * from mipiace where id_utente = (?)"  ; 
			statement = connection.prepareStatement(query) ; 
			statement.setInt(1, idUtente) ; 
			ResultSet result = statement.executeQuery() ; 
			while (result.next () ) {
				Canzone temp = new Canzone() ; 
				temp.setIdCanzone(result.getInt("id_canzone"));
				canzoni.add( DatabaseManager.getInstance().getDaoFactory().getCanzoneDao().findById(temp.getIdCanzone())) ;
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
	return canzoni ;
}

public static void main(String[] args) {
	DatabaseManager.getInstance().getDaoFactory().getMiPiaceDao().creaRelazione(1, 1);
}
}
