package model;


import java.util.ArrayList;
import java.util.List;

public class Playlist {

	
	private String nomePlaylist;
	private int idPlaylist;
	private ArrayList<Canzone>playlist;
	private String pathImagePlaylist;
	
		public Playlist(String nomePlaylist, int idPlaylist, ArrayList<Canzone> playlist) {
		super();
		this.nomePlaylist = nomePlaylist;
		this.idPlaylist = idPlaylist;
		this.playlist = playlist;
	}
		
		public Playlist(String nomePlaylist, ArrayList<Canzone>playlist) {
			this.nomePlaylist = nomePlaylist;
			this.playlist =  playlist;
		}

		public Playlist() {
			// TODO Auto-generated constructor stub
		}

		public String getNomePlaylist() {
		return nomePlaylist;
	}
	public void setNomePlaylist(String nomePlaylist) {
		this.nomePlaylist = nomePlaylist;
	}
	public int getIdPlaylist() {
		return idPlaylist;
	}
	public void setIdPlaylist(int idPlaylist) {
		this.idPlaylist = idPlaylist;
	}
	public List<Canzone> getPlaylist() {
		return playlist;
	}
	public void setPlaylist(ArrayList<Canzone> playlist) {
		this.playlist = playlist;
	}

	
	public void addCanzone (Canzone c ) {
		if (playlist==null)
			playlist = new ArrayList<>() ; 
		playlist.add(c) ; 
	}
	
	
	
	public void stampaCanzoni () {
		for (Canzone canzone : playlist) {
			System.out.println(canzone.getArtista().getNomeArtista() + " - " + canzone.getTitolo());
			
		}
	}

	public String getPathImagePlaylist() {
		return pathImagePlaylist;
	}

	public void setPathImagePlaylist(String pathImagePlaylist) {
		this.pathImagePlaylist = pathImagePlaylist;
	}
	
	
}
