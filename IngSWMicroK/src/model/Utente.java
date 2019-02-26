package model;


public class Utente {
	
		private int idUtente;
		private int idArtista;
		private String nickname;
		private String nome;
		private String cognome;
		private boolean utenteartista;
		private String telefono;
		private String indirizzo;
		private String email;
		private String password;
		private String conferma;
		private Carrello carrelloUtente;
		
		
		
		public Utente( String name, String surname,String nickname, String email,boolean utente ,String password,String address) {
			this.nickname=nickname;
			this.nome = name;
			this.cognome = surname;
			this.indirizzo = address;
			this.email = email;
			this.password = password;
			this.utenteartista=utente;
		}
		
		
		
		public int getIdUtente() {
			return idUtente;
		}

		public void setIdUtente(int idUtente) {
			this.idUtente = idUtente;
		}

		public int getIdArtista() {
			return idArtista;
		}

		public void setIdArtista(int idArtista) {
			this.idArtista = idArtista;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCognome() {
			return cognome;
		}

		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getIndirizzo() {
			return indirizzo;
		}

		public void setIndirizzo(String indirizzo) {
			this.indirizzo = indirizzo;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConferma() {
			return conferma;
		}

		public void setConferma(String conferma) {
			this.conferma = conferma;
		}

		public Carrello getCarrelloUtente() {
			return carrelloUtente;
		}

		public void setCarrelloUtente(Carrello carrelloUtente) {
			this.carrelloUtente = carrelloUtente;
		}

		

		public Utente() {
			super();
		}

		public Utente(int id, String name, String surname, String phone, String address, String email, String password,String nickname) {
			super();
			carrelloUtente=new Carrello();
			this.idUtente = id;
			this.nickname=nickname;
			this.nome = name;
			this.cognome = surname;
			this.telefono = phone;
			this.indirizzo = address;
			this.email = email;
			this.password = password;
			
		}
		public Utente( String name, String surname, String phone, String address, String email, String password,String nickname) {
			super();
			carrelloUtente=new Carrello();
		
			this.nickname=nickname;
			this.nome = name;
			this.cognome = surname;
			this.telefono = phone;
			this.indirizzo = address;
			this.email = email;
			this.password = password;
			
		}


		

		public boolean isUtenteartista() {
			return utenteartista;
		}

		public void setUtenteartista(boolean utenteartista) {
			this.utenteartista = utenteartista;
		}

		
		
	}
