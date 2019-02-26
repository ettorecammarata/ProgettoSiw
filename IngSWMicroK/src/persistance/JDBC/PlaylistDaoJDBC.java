package persistance.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Artista;
import model.Canzone;
import model.IndiceDiGradimento;
import model.Playlist;
import persistance.DataSource;
import persistance.DatabaseManager;
import persistance.PersistenceException;
import persistence.dao.PlaylistDao;

public class PlaylistDaoJDBC implements PlaylistDao {
private DataSource dataSource;
private Connection connection = null;
private PreparedStatement statement = null;


public PlaylistDaoJDBC(DataSource dataSource) {
	this.dataSource=dataSource;
	}
	@Override
	
		public void save(Playlist playlist) throws SQLException {
			this.connection = this.dataSource.getConnection();
	//Insert tupla
			try {
				String insert = "insert into playlist(nome,path_image) values (?,?)";
				statement = connection.prepareStatement(insert);
				statement.setString(1, playlist.getNomePlaylist());
				statement.setString(2, playlist.getPathImagePlaylist());
				statement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				if (statement != null) {
					statement.close();
				}

				if (connection != null) {
					connection.close();
				}
			}
	}
	
	
	@Override
	public Playlist generatePlaylist(String genere) {
		CanzoneDaoJDBC list =new CanzoneDaoJDBC(dataSource);
			Playlist playlist=new Playlist();
			
		if (genere.equalsIgnoreCase("rock")) {
			playlist = new Playlist("Rock", (ArrayList<Canzone>) list.findForGenere("Rock"));
		} else if (genere.equalsIgnoreCase("pop")) {
			playlist = new Playlist("Pop", (ArrayList<Canzone>) list.findForGenere("Pop"));
		} else if (genere.equalsIgnoreCase("Raggae")) {
			playlist = new Playlist("Raggae", (ArrayList<Canzone>) list.findForGenere("Raggae"));
		}else if (genere.equalsIgnoreCase("metal")) {
			playlist =new Playlist("Metal",(ArrayList<Canzone>) list.findForGenere("Metal"));
		}else if (genere.equalsIgnoreCase("rap")) {
			playlist =new Playlist("Rap",(ArrayList<Canzone>) list.findForGenere("Rap"));
		}else if (genere.equalsIgnoreCase("classica")) {
			playlist =new Playlist("Classica",(ArrayList<Canzone>) list.findForGenere("Classica"));
		}
			

		return playlist;

	}
	@Override
	public ArrayList<Playlist> findByUtente(String name) {
		ArrayList<Playlist> playlist = new ArrayList<>();
		 connection = this.dataSource.getConnection();
		 PreparedStatement statement = null;
		 PreparedStatement statement2 = null ;
		try {
			 
			String query = "select * from playlist as p ,utente as u where p.id_utente=u.id_utente and email=? ";
			statement = connection.prepareStatement(query);
			statement.setString(1, name) ;
			ResultSet result = statement.executeQuery();
						
			while (result.next()) {
				Playlist temp = new Playlist() ; 
				temp.setIdPlaylist(result.getInt("id_playlist"));;
				temp.setNomePlaylist(result.getString("nome"));
				String query2 = "select id_canzone from contenuto_playlist where id_playlist=(?)" ; 
				statement2 = connection.prepareStatement(query2) ; 
				statement2.setInt(1, result.getInt("id_playlist"));
				ResultSet result2 = statement2.executeQuery();
				while (result2.next()) {
					Canzone c = new Canzone() ; 
					c = DatabaseManager.getInstance().getDaoFactory().getCanzoneDao().findById(result2.getInt("id_canzone")) ; 
					temp.addCanzone(c);
				}
				playlist.add(temp); 
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
		
		return playlist;
	}
	@Override
	public void update(Playlist p ,String name ) {
		 connection = this.dataSource.getConnection();
		 PreparedStatement statement = null;
			try {
				String query = "update playlist set nome = (?) WHERE id_playlist =(?)";
				statement = connection.prepareStatement(query);
				statement.setInt(2, p.getIdPlaylist()) ;
				statement.setString(1, name) ;
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
	public void delete(Playlist p) {
		 connection = this.dataSource.getConnection();
		 PreparedStatement statement = null;
			try {
				String query = "DELETE FROM contenuto_playlist WHERE id_playlist =?";
				statement = connection.prepareStatement(query);
				statement.setInt( 1, p.getIdPlaylist()) ;
				statement.addBatch(); 
				String query2 = "DELETE FROM playlist WHERE id_playlist =?" ;
				statement.setInt( 1, p.getIdPlaylist()) ;
				connection.prepareStatement(query2) ; 
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
	public void addSong(Playlist p , Canzone c) {
		 connection = this.dataSource.getConnection();
		 PreparedStatement statement = null;
			try { 
				String insert = "insert into contenuto_playlist (id_canzone, id_playlist) values (?,?)";
				statement = connection.prepareStatement(insert);
				statement.setInt(1, c.getIdCanzone());
				statement.setInt(2, p.getIdPlaylist());
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
	public void removeSong(Playlist p , Canzone c) {
		 connection = this.dataSource.getConnection();
		 PreparedStatement statement = null;
			try {
				String query = "DELETE FROM contenuto_playlist WHERE id_canzone =?";
				statement = connection.prepareStatement(query);
				statement.setInt( 1, c.getIdCanzone()) ;
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

	public static void main(String[] args) {
		System.out.println("Execute");
		Playlist p = new Playlist() ; 
		p.setIdPlaylist(1); 
		Canzone c = new Canzone() ; 
		c.setIdCanzone(7);
		DatabaseManager.getInstance().getDaoFactory().getPlaylistDAO().removeSong(p, c);
		
	}

	
}
