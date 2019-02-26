package persistance.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Artista;
import model.Canzone;
import model.Carrello;
import model.IndiceDiGradimento;
import model.Utente;

import persistance.DataSource;
import persistance.PersistenceException;
import persistance.UtenteCredenziali;
import persistence.dao.UtenteDao;

public class UtenteDaoJDBC implements UtenteDao {
	private DataSource dataSource;
	private PreparedStatement statement = null;

	public UtenteDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int save(Utente utente) {
		int status = -1;
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into utente(nome,cognome,nickname,email,utente_artista,password,indirizzo) values (?,?,?,?,?,?,?)";
			statement = connection.prepareStatement(insert);
			statement.setString(1, utente.getNome());
			statement.setString(2, utente.getCognome());
			statement.setString(3, utente.getNickname());
			statement.setString(4, utente.getEmail());
			statement.setBoolean(5, utente.isUtenteartista());
			statement.setString(6, utente.getPassword());
			statement.setString(7, utente.getIndirizzo());

			Utente u = findByPrimaryKeyq(utente.getEmail());
			if (u.getEmail() != null)
				return 1;
			else {
				statement.executeUpdate();
				Utente uu = findByPrimaryKeyq(utente.getEmail());
				System.out.println(uu.getIdUtente());

				String insertCart = "INSERT INTO \"carrelloUtente\" (\"idUtente\") VALUES (?)";
				statement = connection.prepareStatement(insertCart);
				statement.setInt(1, uu.getIdUtente());
				statement.executeUpdate();
			}

			ResultSet resultSet = statement.getGeneratedKeys();
			while (resultSet.next()) {
				utente.setIdUtente(resultSet.getInt(1));
			}
			status = 0;
		} catch (SQLException e) {
			String message = e.getMessage();
			if (message.contains("Duplicate entry '" + utente.getEmail() + "' for key 'email_UNIQUE'")) {
				status = 1;
			}
			// throw new RuntimeException(messatmp);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				status = 2;
//				e.printStackTrace();
				// throw new RuntimeException(e.getMessage());
			}
		}

		return status;
	}

	@Override
	public List<Utente> findAll() {

		Connection connection = this.dataSource.getConnection();
		ArrayList<Utente> utenti = new ArrayList<>();
		try {
			Utente utente;
			PreparedStatement statement;
			String query = "select * from utente";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				utente = new Utente();
				utente.setIdUtente(result.getInt("id_utente"));
				utente.setNome(result.getString("nome"));
				utente.setCognome(result.getString("cognome"));
				utente.setNickname(result.getString("nickname"));
				utente.setEmail(result.getString("email"));
				utente.setUtenteartista(result.getBoolean("utente_artista"));
				utente.setPassword((result.getString("password")));
				utente.setIndirizzo(result.getString("indirizzo"));

				utenti.add(utente);
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
		return utenti;
	}

	@Override
	public void update(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update utente SET nome=?,cognome=?,nickname=?,email=?,utente_artista=? password=?,indirizzo=? WHERE id_utente=?";

			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, utente.getNome());
			statement.setString(2, utente.getCognome());
			statement.setString(3, utente.getNickname());
			statement.setString(4, utente.getEmail());
			statement.setBoolean(5, utente.isUtenteartista());
			statement.setInt(6, utente.getIdUtente());
			statement.setString(7, utente.getPassword());
			statement.setString(8, utente.getIndirizzo());
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

	public void delete(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM utente WHERE id_utente = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, utente.getIdUtente());
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
	public int findidCarrello(String email) {
		Connection connection = this.dataSource.getConnection();
		int idCarrello = 0;
		try {
			PreparedStatement statement;
			String query = "select c.\"idCarrello\" from utente as u ,\"carrelloUtente\" as c where c.\"idUtente\"=u.id_utente AND u.email=?";
			statement = (PreparedStatement) connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				idCarrello = results.getInt("idCarrello");

			}

		} catch (Exception e) {
			// return null;
//			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// return null;
//				throw new PersistenceException(e.getMessage());
			}
		}
		try {
			if (!connection.isClosed())
				connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return idCarrello;
	}

	@Override
	public UtenteCredenziali findByPrimaryKeyCredential(String email) {
		UtenteCredenziali studCred = null;
		/*
		 * Utente stud = findByPrimaryKey1(email); UtenteCredenziali studCred = null; if
		 * (stud != null) { studCred = new UtenteCredenziali(dataSource);
		 * studCred.setIdUtente(stud.getIdUtente());
		 * studCred.setCognome(stud.getCognome()); studCred.setNome(stud.getNome());
		 * 
		 * }
		 */
		return studCred;
	}

	/*
	 * */

	public Utente findByPrimaryKeyq(String email) {
		Connection connection = this.dataSource.getConnection();
		Utente u = new Utente();
		try {
			PreparedStatement statement;
			String query = "select * from utente where email=?  ";
			statement = (PreparedStatement) connection.prepareStatement(query);
			statement.setString(1, email);

			ResultSet results = statement.executeQuery();
			while (results.next()) {

				u.setIdUtente(results.getInt("id_utente"));
				u.setNome(results.getString(("nome")));
				u.setCognome(results.getString("cognome"));
				u.setIndirizzo(results.getString("indirizzo"));
				u.setEmail(results.getString("email"));
				u.setPassword(results.getString("password"));

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
		return u;
	}

	@Override
	public Utente findPrimaryKey(String email, String password) {
		Connection connection = this.dataSource.getConnection();
		Utente u = new Utente();
		try {
			PreparedStatement statement;
			String query = "select * from utente where email=? AND password=? ";
			statement = (PreparedStatement) connection.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet results = statement.executeQuery();
			while (results.next()) {

				u.setIdUtente(results.getInt("id_utente"));
				u.setNome(results.getString(("nome")));
				u.setCognome(results.getString("cognome"));
				u.setIndirizzo(results.getString("indirizzo"));
				u.setEmail(results.getString("email"));
				u.setPassword(results.getString("password"));

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
		return u;

	}

	private void addInCart(int idcarrello, int id_canzone) {
		Connection connection = this.dataSource.getConnection();

		try {
			String insert = "insert into contenutocarrello (idcarrello,idcanzone) values(?,?)";
			PreparedStatement statement4 = connection.prepareStatement(insert);
			statement4.setInt(1, idcarrello);
			statement4.setInt(2, id_canzone);
			statement4.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

	@Override
	public int addToCart(String email, int canzone_id) {
		Connection connection = this.dataSource.getConnection();
		int utente_id = 0;
		int carrello_id = 0;
		int status = -1;
		try {
			String getUtenteId = "select id_utente from utente where email=?";
			PreparedStatement getUtente_id = connection.prepareStatement(getUtenteId);
			getUtente_id.setString(1, email);
			ResultSet resultSet = getUtente_id.executeQuery();
			if (resultSet.next()) {
				utente_id = resultSet.getInt(1);
			}
			System.out.println(utente_id + "  zzzz");
			String getCartId = "select u.\"idCarrello\" from \"carrelloUtente\"as u where u.\"idUtente\" =?";
			PreparedStatement statement = connection.prepareStatement(getCartId);
			statement.setInt(1, utente_id);
			ResultSet resultSet2 = statement.executeQuery();

			if (resultSet2.next()) {
				System.out.println("somo dentro");
				carrello_id = resultSet2.getInt(1);
			}
			System.out.println(carrello_id + " as");

			String getListaCanzoniCarrello = "select * from contenutocarrello as u where u.idcarrello=? and u.idcanzone=?";
			PreparedStatement getListaCanzoniCarrelloStatement = connection.prepareStatement(getListaCanzoniCarrello);
			getListaCanzoniCarrelloStatement.setInt(1, carrello_id);
			getListaCanzoniCarrelloStatement.setInt(2, canzone_id);
			ResultSet resultSet3 = getListaCanzoniCarrelloStatement.executeQuery();

			int cartItemsListID = 0;
			while (resultSet3.next()) {
				cartItemsListID = resultSet.getInt(1);
				System.out.println(resultSet.getInt(1) + " ass");
			}
			if (cartItemsListID == 0) {
				System.out.println("Ciao mamma");
				addInCart(carrello_id, canzone_id);

			}

			status = 0;
		} catch (SQLException e) {
			String message = e.getMessage();
			if (message.contains("Duplicate entry")) {
				status = 1;

			}
//			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				status = 2;
//				throw new PersistenceException(e.getMessage());
			}
		}
		return status;
	}

	@Override
	public void RimuoviDalCarrello(int idCarrello, int id_canzone) {

		Connection connection = this.dataSource.getConnection();
		try {
			String select = "DELETE  from contenutocarrello as c where c.idcarrello=? and c.idcanzone=?";
			PreparedStatement statement = connection.prepareStatement(select);
			statement.setInt(1, idCarrello);
			statement.setInt(2, id_canzone);
			statement.execute();

		} catch (SQLException e) {
//			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
//				throw new PersistenceException(e.getMessage());
			}
		}
	}

	@Override
	public int CercaIdCarrello(int idUtente) {
		Connection connection = this.dataSource.getConnection();
		Carrello c = null;
		PreparedStatement statement = null;

		try {
			String query = "select c.\"idCarrello\" from \"carrelloUtente\" as c where c.\"idUtente\"=? ";
			statement = connection.prepareStatement(query);
			statement.setInt(1, idUtente);
			c = new Carrello();
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				c.setId(results.getInt("idCarrello"));
			}
		} catch (SQLException e) {
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}

		return c.getId();
	}

	@Override
	public List<Canzone> CercaCanzoniCarrello(int IdCarrello) {
		Connection connection = this.dataSource.getConnection();
		Canzone canzone = null;
		List<Canzone> listaC = new ArrayList<>();
		try {
			PreparedStatement statement;
			String query = "select * from contenutocarrello as a,canzone as c where a.idcarrello=? and c.idcanzone= a.idcanzone";
			statement = (PreparedStatement) connection.prepareStatement(query);
			statement.setInt(1, IdCarrello);

			ResultSet result = statement.executeQuery();
			while (result.next()) {
				canzone = new Canzone();
				canzone.setIdCanzone(result.getInt("idcanzone"));
				canzone.setTitolo(result.getString("titolo"));
				canzone.setArtista(new Artista(result.getString("artista")));
				canzone.setGenere(result.getString("genere"));
				canzone.setAnno(result.getInt("anno"));
				canzone.setCasaDiscografica(result.getString("casadiscografica"));
				canzone.setIndiceDiGradimento(new IndiceDiGradimento(result.getInt("IndiceDiGradimento")));
				canzone.setUrl(result.getString("url"));
				canzone.setAlbum(result.getString("album"));
				canzone.setIdCanzone(result.getInt("idcanzone"));
				canzone.setPrezzo(result.getDouble("prezzo"));
				listaC.add(canzone);
			}
		} catch (Exception e) {
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}

		return listaC;

	}
}
