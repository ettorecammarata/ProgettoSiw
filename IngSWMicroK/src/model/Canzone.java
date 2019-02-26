package model;



public class Canzone {
	
	private int idCanzone;
	
	private Artista artista;

	private String titolo;
	private String album;
	private String genere;
	private String casaDiscografica;
    private IndiceDiGradimento indiceDiGradimento;
	private Integer anno;
	private String url;
	private double prezzo;
	private boolean buy_now;
	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}

	public Canzone() {
		artista=new Artista("" );
		setIndiceDiGradimento(new IndiceDiGradimento());
		album="";
		genere="";
		casaDiscografica="";
		anno=1900;
	}

	

	public Canzone(int idCanzone, Artista artista, String titolo, String album, String genere, String casaDiscografica,
			IndiceDiGradimento indiceDiGradimento, Integer anno,double prezzo) {
		super();
		this.idCanzone = idCanzone;
		this.artista = artista;
		this.titolo = titolo;
		this.album = album;
		this.genere = genere;
		this.casaDiscografica = casaDiscografica;
		this.setIndiceDiGradimento(indiceDiGradimento);
		this.anno = anno;
		this.setPrezzo(prezzo);
	}
	public Canzone( Artista artista, String titolo, String album, String genere, String casaDiscografica,
			IndiceDiGradimento indiceDiGradimento,String url ,Integer anno) {
		super();
		
		this.artista = artista;
		this.titolo = titolo;
		this.album = album;
		this.genere = genere;
		this.casaDiscografica = casaDiscografica;
		this.setIndiceDiGradimento(indiceDiGradimento);
		this.anno = anno;
		this.url=url;
	}

	



	public Canzone(int idCanzone, Artista artista, String titolo, String album, String genere, String casaDiscografica,
			IndiceDiGradimento indiceDiGradimento,  String url,Integer anno) {
		super();
		this.idCanzone = idCanzone;
		this.artista = artista;
		this.titolo = titolo;
		this.album = album;
		this.genere = genere;
		this.casaDiscografica = casaDiscografica;
		this.indiceDiGradimento = indiceDiGradimento;
		this.anno = anno;
		this.url = url;
	}



	public Canzone(Integer id) {
		this.idCanzone = id;
	}



	public int getIdCanzone() {
		return idCanzone;
	}


	public void setIdCanzone(int idCanzone) {
		this.idCanzone = idCanzone;
	}


	public Artista getArtista() {
		return artista;
	}


	public void setArtista(Artista artista) {
		this.artista = artista;
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public String getAlbum() {
		return album;
	}


	public void setAlbum(String album) {
		this.album = album;
	}


	public String getGenere() {
		return genere;
	}


	public void setGenere(String genere) {
		this.genere = genere;
	}


	public String getCasaDiscografica() {
		return casaDiscografica;
	}


	public void setCasaDiscografica(String casaDiscografica) {
		this.casaDiscografica = casaDiscografica;
	}


	public Integer getAnno() {
		return anno;
	}


	public void setAnno(Integer anno) {
		this.anno = anno;
	}



	public IndiceDiGradimento getIndiceDiGradimento() {
		return indiceDiGradimento;
	}



	public void setIndiceDiGradimento(IndiceDiGradimento indiceDiGradimento) {
		this.indiceDiGradimento = indiceDiGradimento;
	}



	public double getPrezzo() {
		return prezzo;
	}



	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}



	public boolean isBuy_now() {
		return buy_now;
	}



	public void setBuy_now(boolean buy_now) {
		this.buy_now = buy_now;
	}
	
}
