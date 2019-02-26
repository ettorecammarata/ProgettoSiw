package model;

import java.util.ArrayList;
import java.util.List;

public class CatalogoMusicale {
	protected List<Canzone>listaDiCanzoni;
	protected List<Artista>listaDiArtisti;
	
	public CatalogoMusicale() {
		super();
		listaDiCanzoni = new ArrayList<>();
		listaDiArtisti =new ArrayList<>();
	}
	
	public int inserisciUnaCanzone(Canzone e ) {
		listaDiCanzoni.add(e);
		return listaDiCanzoni.size();
	}
	public int inserisciUnArtista(Artista a ) {
		listaDiArtisti.add(a);
		return listaDiArtisti.size();
	}
}



