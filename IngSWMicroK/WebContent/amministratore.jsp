<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="js/jquery-3.3.1.min.js"></script>

<script type="text/javascript" src="js/search.js"></script>
<link href="css/stileAmministratore.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>--MicroK--MusicStore--</title>
</head>
<body>
	<table class="Macro">
		<tr class="Menu">
			<td>Aggiungi Artista</td>
			<td>Aggiuangi Canzone</td>
			<td>Aggiungi Evento</td>
		</tr>

		<tr id="AggiugniArtista">
			<td>
				<form method="POST" action="aggiungiArtista">


					<div class="form-group">
						<label>Nome</label> <br> <input name="nome"
							id="_nome_Artista" value=""> <br> <label>Immagine</label>
						<br> <input class="form-control" name="path"
							id="_immagine_Artista" value=""><br> <label>Biografia</label>
						<br> <input class="form-control" id="_textBiografy"
							name="biografia" value=""> <br> <br>
					</div>
					<button type="submit" class="btn btn-default">Conferma</button>
				</form>
				<form method="POST" action="modificaArtista">
					<button type="submit" class="btn btn-default">Update</button>
				</form>

			</td>

			<td>
				<td>
				<form method="POST" action="aggiungiCanzone">


					<div class="form-group">
					
						<label>Titolo</label><br>
						 <input class="form-control" name="titolo" id="_titolo" value="">
						<br> <label>Album</label> 
						<br> <input class="form-control" name="album" id="_album" value=""><br>
						 <label>Artista</label><br>
						  <input class="form-control" name="artista" id="_artista" value=""><br>
						<label>Genere</label><br> 
						<input class="form-control"	name="genere" id="_genere" value=""> <br> 
						<label>Anno</label><br>
						<input class="form-control" name="anno" id="_anno" value=""> <br>
						<label>Casa Discografica </label><br>
						 <input	class="form-control" name="casaDiscografica" id="_casaDiscografica" value=""> <br>
						  <label>URL</label> <br>
						<input class="form-control" name="url" id="_path_canzone" value=""><br>
						  <label>digita modifica per modificare</label> <br>
						<input class="form-control" name="modifica" id="" value="modifica"><br>
						<label>idCanzone</label><br>
						 <input class="form-control" name="id" id="_id" value="" >
						<br>
					
					<button type="submit" class="btn btn-default">Conferma</button>
					</div>
				
					
				</form>
				

			</td>

				
			</td>

			
		</tr>

		<tr>
			<td>Modifica Artista</td>
			<td>Modifica Canzone</td>
			<td>Modifica Evento</td>
		</tr>
		<tr>
			<td>
				<div onkeypress="cercaAmministratoreArtista()">
					<input type="text" placeholder="digita Artista" id="search3"
						aria-label="Search" name="search" />
					<div>
						<button class="btn btn-outline-success my-20 my-sm-10"
							type="submit">Search</button>
					</div>
				</div>
			</td>
			<td>
			<td>
				<form onkeypress="cercaAmministratoreCanzoni()">
					<input type="text" placeholder="digita Canzone" id="search1"
						aria-label="Search" name="search" />
					<div>
						<button class="btn btn-outline-success my-20 my-sm-10"
							type="submit">Search</button>
					</div>
				</form>

			</td>
			<td>
				<form onkeypress="cercaAmministratoreEventi()">
					<input type="text" placeholder="digita Eventi" id="search2"
						aria-label="Search" name="search" />
					<div>
						<button class="btn btn-outline-success my-20 my-sm-10"
							type="submit">Search</button>
					</div>
				</form>
			</td>
		</tr>

	</table>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Artista</th>
				<th>Titolo</th>
				<th>Album</th>
			</tr>
		</thead>
		<tbody id="resultElencoArtista1">

		</tbody>
	</table>
</body>
</html>