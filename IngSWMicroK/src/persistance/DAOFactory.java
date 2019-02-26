package persistance;



import persistence.dao.ArtistaDao;
import persistence.dao.CanzoneDao;
import persistence.dao.EventoDao;
import persistence.dao.FollowDao;
import persistence.dao.MiPiaceDao;
import persistence.dao.PlaylistDao;
import persistence.dao.UtenteDao;

public abstract class DAOFactory {

	// --- List of supported DAO types ---

	
	/**
	 * Numeric constant '1' corresponds to explicit MySQL choice
	 */
	public static final int MYSQL = 1;
	
	/**
	 * Numeric constant '2' corresponds to explicit Postgres choice
	 */
	public static final int POSTGRESQL = 2;
	
	
	// --- Actual factory method ---
	
	/**
	 * Depending on the input parameter
	 * this method returns one out of several possible 
	 * implementations of this factory spec 
	 */
	public static DAOFactory getDAOFactory(int whichFactory) {
		switch ( whichFactory ) {
		
		case MYSQL:
			return null;//new HsqldbDAOFactory();
		case POSTGRESQL:
			return new PostgresDAOFactory();
		default:
			return null;
		}
	}
	
	
	
	// --- Factory specification: concrete factories implementing this spec must provide this methods! ---
	
	/**
	 * Method to obtain a DATA ACCESS OBJECT
	 * for the datatype 'canzone'
	 */
	public abstract CanzoneDao getCanzoneDao();
	
	public abstract ArtistaDao getArtistaDAO();
	
	public abstract EventoDao getEventoDAO();
	

	
	public abstract	UtenteDao getUtenteDAO();

	public abstract	PlaylistDao getPlaylistDAO();

	public abstract MiPiaceDao getMiPiaceDao () ; 
	
	public abstract FollowDao getFollowDao () ; 
}
