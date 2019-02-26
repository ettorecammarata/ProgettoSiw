package persistance;

import persistance.JDBC.ArtistaDaoJDBC;
import persistance.JDBC.CanzoneDaoJDBC;
import persistance.JDBC.EventoDaoJDBC;
import persistance.JDBC.FollowDaoJDBC;
import persistance.JDBC.MiPiaceDaoJDBC;
import persistance.JDBC.PlaylistDaoJDBC;
import persistance.JDBC.UtenteDaoJDBC;
import persistence.dao.ArtistaDao;
import persistence.dao.CanzoneDao;
import persistence.dao.EventoDao;
import persistence.dao.FollowDao;
import persistence.dao.MiPiaceDao;
import persistence.dao.PlaylistDao;
import persistence.dao.UtenteDao;

public class PostgresDAOFactory extends DAOFactory {

	
	
	private static  DataSource dataSource;
	

	// --------------------------------------------

	static {
		try { 
			Class.forName("org.postgresql.Driver");
			//questi vanno messi in file di configurazione!!!	
			//dataSource=new DataSource("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
		//	dataSource=new DataSource("jdbc:postgresql://192.168.1.4:5432/Database_MicroK","postgres","postgres");
		//	dataSource=new DataSource("jdbc:postgresql://37.183.87.125:5432/postgres","postgres","password");
		//	dataSource=new DataSource("jdbc:postgresql://192.168.43.197:5432/Database_MicroK","postgres","postgres");
			//dataSource=new DataSource("jdbc:postgresql://localhost:5432/Database_MicroK","postgres","postgres");
				dataSource=new DataSource("jdbc:postgresql://37.183.87.125:5432/postgres","pi","password");

		} 
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load Postgres JDBC driver\n"+e);
			e.printStackTrace();
		}
	}

	
	// --------------------------------------------
	

	@Override
	public CanzoneDao getCanzoneDao() {
		return new CanzoneDaoJDBC(dataSource);
	}

	@Override
	public ArtistaDao getArtistaDAO() {
		return new ArtistaDaoJDBC(dataSource);
	}

	@Override
	public EventoDao getEventoDAO() {
		return new EventoDaoJDBC(dataSource);
	}

	

	@Override
	public UtenteDao getUtenteDAO() {
		return new UtenteDaoJDBC (dataSource);
	}

	@Override
	public PlaylistDao getPlaylistDAO() {
		// TODO Auto-generated method stub
		return new PlaylistDaoJDBC (dataSource);
	}

	@Override
	public MiPiaceDao getMiPiaceDao() {
		// TODO Auto-generated method stub
		return new MiPiaceDaoJDBC(dataSource);	}

	@Override
	public FollowDao getFollowDao() {
		// TODO Auto-generated method stub
		 return new FollowDaoJDBC(dataSource);
	}
}
