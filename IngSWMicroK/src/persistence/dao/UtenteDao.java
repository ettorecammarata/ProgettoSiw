package persistence.dao;

import java.util.List;

import model.Canzone;
import model.Utente;
import persistance.UtenteCredenziali;

public interface UtenteDao {
	public int save(Utente utente);  // Create
	public List<Utente> findAll();       
	public void update(Utente canzone); //Update
	public void delete(Utente canzone); //Delete	
	public Utente findPrimaryKey(String email, String password) ;
	public UtenteCredenziali findByPrimaryKeyCredential(String email);
	public int findidCarrello(String email);
	public Utente  findByPrimaryKeyq(String email);
	public int addToCart(String email, int item_id);
	public List<Canzone> CercaCanzoniCarrello(int IdCarrello);
	public int CercaIdCarrello(int idUtente);
	public void RimuoviDalCarrello(int idCarrello, int id_canzone);
	
}
