package model;

import java.sql.SQLException;

import persistance.DatabaseManager;

public class Artista {
	
	
	private String nomeArtista;
	private int idArtista;
	private String   pathImage;
	private String TextBiografia;

	public Artista () {
		super() ;
	}
	public Artista(String nomeArtista, int idArtista,String path) {
		super();
		this.nomeArtista = nomeArtista;
		this.idArtista = idArtista;
		this.pathImage=path;
	}

	
	public Artista(String nomeArtista) {
		super();
		this.nomeArtista = nomeArtista;
		try {
			DatabaseManager.getInstance().getDaoFactory().getArtistaDAO().save(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.idArtista = DatabaseManager.getInstance().getDaoFactory().getArtistaDAO().findByName(nomeArtista).getIdArtista() ; 
	}
	
	
	
	public String getNomeArtista() {
		return nomeArtista;
	}

	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}

	public int getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}
	public String getPathImage() {
		return pathImage;
	}
	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}
	public String getTextBiografia() {
		return TextBiografia;
	}
	public void setTextBiografia(String textBiografia) {
		TextBiografia = textBiografia;
	}


}
