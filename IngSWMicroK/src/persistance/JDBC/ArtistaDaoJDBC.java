package persistance.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Artista;
import model.Canzone;
import persistance.DataSource;
import persistance.PersistenceException;
import persistence.dao.ArtistaDao;

public class ArtistaDaoJDBC implements ArtistaDao {
	private DataSource dataSource;
	private Connection connection = null;
	private PreparedStatement statement = null;

	public ArtistaDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Artista artista) throws SQLException {
		try {
			addArtista(artista);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void addArtista(Artista artista) throws SQLException {
		try {
			Boolean artistaPresente = false;
			connection = this.dataSource.getConnection();
			String sql = "SELECT Nome FROM artista WHERE nome= ?";
			this.statement = this.connection.prepareStatement(sql);
			statement.setString(1, artista.getNomeArtista());
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String username = rs.getString("nome");
				artistaPresente = true;
				System.out.println(username);
			}

			if (artistaPresente == false) {
				statement.addBatch();
				String insert = "insert into artista(nome,path_image_artista,biografia) values (?,?,?)";
				statement = connection.prepareStatement(insert);
				statement.setString(1, artista.getNomeArtista());
				statement.setString(2, artista.getPathImage());
				statement.setString(3, artista.getTextBiografia());

				statement.executeUpdate();
				artistaPresente = false;
				rs.close();
			}

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
	public List<Artista> findAll() {

		connection = this.dataSource.getConnection();
		ArrayList<Artista> artisti = new ArrayList<>();
		try {
			Artista artista;
			PreparedStatement statement;
			String query = "select * from artista";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				artista = new Artista();
				artista.setIdArtista(result.getInt("idartista"));
				artista.setNomeArtista(result.getString("nome"));
				artista.setPathImage(result.getString("path_image_artista"));
				artista.setTextBiografia(result.getString("biografia"));
				artisti.add(artista);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return artisti;
	}
	
	
	
	
	
	@Override
	public List<Artista> findArtista(String searchQuery) {
		connection = this.dataSource.getConnection();
		ArrayList<Artista> artisti = new ArrayList<>();
		if (searchQuery != null) {
			String[] someQueries = searchQuery.split(" ");
			ArrayList<String> queries = new ArrayList<String>();
			queries.add(searchQuery);
			if (someQueries.length > 1) {
				for (int i = 1; i < someQueries.length; i++)
					queries.add(someQueries[i]);
			}
			Artista artista;
			try {
				for (String search : queries) {
					PreparedStatement statement;
					String query = "SELECT * FROM artista WHERE artista.nome ILIKE ? ";
					statement = connection.prepareStatement(query);
					statement.setString(1, "%" + search + "%");
					ResultSet result = statement.executeQuery();
					while (result.next()) {
						artista = new Artista();
						artista.setIdArtista(result.getInt("idartista"));
						artista.setNomeArtista(result.getString("nome"));
						artista.setPathImage(result.getString("path_image_artista"));
						artista.setTextBiografia(result.getString("biografia"));
						artisti.add(artista);
					}
				}

			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new PersistenceException(e.getMessage());
				}
			}
		}
		return artisti;
	}
	@Override
	public void update(Artista artista) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update artista SET nome= ? , path_image_artista=? , biografia=?  Where idartista=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, artista.getNomeArtista());
			statement.setString(2, artista.getPathImage());
			statement.setString(3, artista.getTextBiografia());
			statement.setInt(4, artista.getIdArtista());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	
	@Override
	public Artista findByName(String nome) {
	
		  Connection connection = this.dataSource.getConnection();
		  Artista a = new Artista() ; 
		  try {
		   PreparedStatement statement;
		   String query = "select * from artista where nome=? ";
		   statement = connection.prepareStatement(query);
		   statement.setString(1,nome);
		   ResultSet results = statement.executeQuery();
		   while (results.next()) {
	
		    a.setIdArtista(results.getInt("idartista"));
		    a.setNomeArtista(results.getString("nome"));
		    a.setPathImage(results.getString("path_image_artista"));
		    a.setTextBiografia(results.getString("biografia"));

		   }
		  } catch (Exception e) {
		  } finally {
		   try {
		    connection.close();
		   } catch (SQLException e) {
		   }
		  }
		  try {
		   if (!connection.isClosed())
		    connection.close();
		  } catch (SQLException e) {

		  }
		  return a;
		 }

		
	
	
	
	
	
	
	
	
	@Override
	public void delete(Artista artista) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM artista WHERE idartista = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, artista.getIdArtista());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}

	}

}
