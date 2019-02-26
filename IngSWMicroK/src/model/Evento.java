package model;

import java.sql.Date;

public class Evento {
	
	private String nomeEvento;
	private int idEvento;
	private String LuogoEvento;
	private Artista artista;
	private Date dataEvento;
	private double prezzoEvento;
	
	public Evento() {
		super();
	}

	public Evento(String nomeEvento, int idEvento, String luogoEvento, Artista artista, Date dataEvento,
			double prezzoEvento) {
		super();
		this.nomeEvento = nomeEvento;
		this.idEvento = idEvento;
		LuogoEvento = luogoEvento;
		this.artista = artista;
		this.dataEvento = dataEvento;
		this.prezzoEvento = prezzoEvento;
	}
	
	public Evento(String nomeEvento, String LuogoEvento, Artista artista, Date dataEvento, double prezzoEvento) {
		this.nomeEvento = nomeEvento ; 
		this.LuogoEvento = LuogoEvento ; 
		this.dataEvento = dataEvento ; 
		this.artista = artista ; 
		this.prezzoEvento = prezzoEvento ; 
	}

	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public String getLuogoEvento() {
		return LuogoEvento;
	}
	public void setLuogoEvento(String luogoEvento) {
		LuogoEvento = luogoEvento;
	}
	public Artista getArtista() {
		return artista;
	}
	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	public Date getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}
	public double getPrezzoEvento() {
		return prezzoEvento;
	}
	public void setPrezzoEvento(double prezzoEvento) {
		this.prezzoEvento = prezzoEvento;
	}

}
