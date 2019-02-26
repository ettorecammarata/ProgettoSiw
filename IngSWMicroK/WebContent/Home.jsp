<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>MicroK ListenMusic</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">


<link rel='stylesheet'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>
<link rel='stylesheet'
	href='https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css'>
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/8.3.0/nouislider.min.css'>

<link rel="stylesheet" href="css/theme_style.css">





<style>
.album_search {
	columns: sm -4px;
	columns: md -4px;
}

.img_art {
	border-radius: 90%;
}

.demo-container {
	border: 1px solid #009BE3;
	padding: 0 20px;
	font-family: "Myriad Pro Regular", "Trebuchet MS";
}

.demo-container a, .demo-container a:link, .demo-container a:visited,
	.demo-container a:hover, .demo-container a:focus, .demo-container a:active
	{
	color: #009BE3;
}

.demo-container ul {
	list-style-type: none;
	padding: 0;
	margin: 1em 0;
	width: 100%;
	overflow: hidden;
}

.demo-container ul span {
	color: #A0A600;
}

.demo-container li {
	float: left;
	margin-right: 1em;
}

.demo-container p span.track-name {
	color: #CC0090;
}
</style>
</head>

<body id="jp_container" onload="playlistGenere()">
	<c:if test="${username != null}">

<!-- *******************************************navbar************************************************* -->

		<section class="header">
			
			<div class="search" onkeypress="cerca()">
				<input type="text" placeholder="Search" id="search"
					aria-label="Search" name="search" />
				<button class="btn btn-outline-success my-20 my-sm-10" id="myBtn"
					type="submit" onclick="cerca()">Search</button>
			</div>
			<div class="user">
				<div class="user__notifications">
					<i class="ion-android-notifications"></i>
				</div>

				<div class="user__info">
					<span class="user__info__img"> <img
						src="assets/img/Icon.svg" alt="Profile Picture"
						class="img-responsive" />

					</span> <span class="user__info__name"> <span class="first">Benvenuto</span>
						${username}
					</span>
				</div>
				<div class="user__actions">
					<div class="dropdown">
						<button class="dropdown-toggle" type="button" id="dropdownMenu1"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
							<i class="ion-chevron-down"></i>
						</button>
						<ul class="dropdown-menu dropdown-menu-right"
							aria-labelledby="dropdownMenu1">
							
							<li><a href="#">Account</a></li>
							<li><a onclick="location.href='logout?logout=true'">Log	Out</a></li>
						</ul>
					</div>
				</div>
			</div>
		</section>
		
		
		
		
		
		
		<section class="content">
		
							<!-- *******************************************sidebar************************************************* -->
			<div class="content__left">
				<section class="navigation">
					<!-- Main -->
					<div class="navigation__list">
						<div class="navigation__list__header" role="button"
							data-toggle="collapse" href="#main" aria-expanded="true"
							aria-controls="main">Main</div>

						<div class="collapse in" id="main">

							<a href="#" class="navigation__list__item"> <i
								class="ion-ios-browsers"></i> <span>Browse</span>
							</a> <a href="#" class="navigation__list__item"> <i
								class="ion-person-stalker"></i> <span>Activity</span>
							</a>

						</div>

					</div>
					<!-- / -->

					<!-- Your Music -->
					<div class="navigation__list">

						<div class="navigation__list__header" role="button"
							data-toggle="collapse" href="#yourMusic" aria-expanded="true"
							aria-controls="yourMusic">Your Music</div>

						<div class="collapse in" id="yourMusic">

							<a href="#" class="navigation__list__item"> <i
								class="ion-headphone"></i> <span>Songs</span>
							</a> <a href="#" class="navigation__list__item"> <i
								class="ion-ios-musical-notes"></i> <span>Albums</span>
							</a> <a href="#" class="navigation__list__item"> <i
								class="ion-person"></i> <span>Artists</span>
							</a> <a href="#" class="navigation__list__item"> <i
								class="ion-document"></i> <span>Local Files</span>
							</a>

						</div>

					</div>
					<!-- / -->

					<!-- Playlists -->
					<div class="navigation__list">

						<div class="navigation__list__header" role="button"
							data-toggle="collapse" href="#playlists" aria-expanded="true"
							aria-controls="playlists">Playlists</div>

						<div class="collapse in" id="playlists">

							<a href="#idsearch" class="navigation__list__item"> <i
								class="ion-ios-musical-notes"></i> <span>Playlist per
									genere</span>
							</a>
						</div>

					</div>
					<!-- / -->

				</section>

				<section class="playlist">

					<a href="#"> <i class="ion-ios-plus-outline"></i> New Playlist

					</a>

				</section>
			</div>
			
			
			<!-- ******************************************************************************************** -->
			

			<div class="content__middle">
				<div class="artist is-verified">
					<div class="artist___header">




						<div class="artist__navigation">

							<ul class="nav nav-tabs" role="tablist">

								<li role="presentation" class="active"><a
									href="#artist-overview" aria-controls="artist-overview"
									role="tab" data-toggle="tab">Overview</a></li>

								<li role="presentation"><a href="#idsearch"
									aria-controls="idsearch" role="tab" data-toggle="tab">Result
										search</a></li>
								<li role="presentation"><a href="#Artist_Page"
									aria-controls="Artist_Page" role="tab" data-toggle="tab">Artista</a></li>
								<li role="presentation"><a href="#Playlist_Page"
									aria-controls="Playlist_Page" role="tab" data-toggle="tab"
									onclick="playlist()">Playlist</a></li>
								<li role="presentation" ><a href="#id_profilo"
								aria-controls="Artist_Page" role="tab" data-toggle="tab" >Profilo</a></li>

									


								<!--<li role="presentation">
              <a href="#artist-about" aria-controls="artist-about" role="tab" data-toggle="tab">About</a>
            </li>-->

							</ul>

						</div>

					</div>

					<div class="artist__content">

						<div class="tab-content">
						
					<!-- *****************PlaylistGenereOverview******************************* -->
							<!-- Overview -->
							<div role="tabpanel" class="tab-pane active" id="artist-overview">

								<div class="overview-album">

							


									<section id="result0"></section>
									
								 	<section id="result1"></section>
									
									<section id="result2"></section>
									
									<section id="result3"></section>

								</div>

							</div>
					<!-- *****************PlaylistGenereOverview******************************* -->
					
					
					
								<!-- *****************Risultati Ricerca******************************* -->

							<div role="tabpanel" class="tab-pane" id="idsearch">
								<div class="row">
									<section id="resultArtista"></section>
								</div>

								<div>
									<section id="resultCanzone"></section>

								</div>

							</div>

								<!-- *****************Fine Risultati ricerca******************************* -->
								
								<!-- *****************Pagina Artista******************************* -->
								
								
							<div role="tabpanel" class="tab-pane" id="Artist_Page">
								<div class="artist is-verified">
									<div class="artist__header">
										<div class="artist__info">
											<div class="profile__img">
												<img id="immagine_Artista" src=" " alt="">

											</div>

											<div class="artist__info__meta">

												<div class="artist__info__type">Artista</div>

												<div class="artist__info__name" id="nome_Artista"></div>

												<div class="artist__info__actions">

													<button class="button-light">Follow</button>

												</div>

											</div>


										</div>

										<div class="artist__listeners">

											<div class="artist__listeners__count"
												id="numero_riproduzione">15,662,810</div>

										</div>

										<div class="artist__navigation">

											<ul class="nav nav-tabs" role="tablist">

												<li role="presentation" class="active"><a
													href="#artist-biografy" aria-controls="artist-biografy"
													role="tab" data-toggle="tab">Biografia</a></li>

												<li role="presentation"><a href="#discografia"
													aria-controls="discografia" role="tab" data-toggle="tab">Discografia</a></li>

												<li role="presentation"><a href="#info_evento"
													aria-controls="eventi" role="tab" data-toggle="tab">Eventi</a></li>


											</ul>

										</div>

									</div>

									<div class="artist__content">

										<div class="tab-content">

											<!-- Overview -->
											<div role="tabpanel" class="tab-pane active"
												id="artist-biografy">
												<div class="bio">
													<p class="lead" id="textBiografy"></p>
												</div>



											</div>
											<!-- / -->



											<!-- Related Artists -->
											<div role="tabpanel" class="tab-pane" id="discografia">
												<div class="row">
													<section id="resultCanzoneArtista"></section>
													<div class="overview">
														<div class="row">
															<div class="col-sm-6" style="width: 500px;">
																<section id="resultAlbum"></section>
															</div>
														</div>


													</div>
												</div>
											</div>

											<div role="tabpanel" class="tab-pane" id="eventi"></div>


										</div>

									</div>

								</div>

							</div>

							<!-- *****************Fine Sezione Artista******************************* -->



							<!-- ******************Playlist Utente********************** -->

							<div role="tabpanel" class="tab-pane" id="Playlist_Page">
								<div class="row">
									<section id="resultPlaylist"></section>
								</div>
							</div>

							<!-- **************************************** -->
							
							
							
							<!-- *******************ProfiloUtente********************* -->
						<div role="tabpanel" class="tab-pane" id="id_profilo">
							<div class="overview_modifica">
								<div class="row">
								<div class="col-sm-5">
									<div ><img alt="" src="assets/img/Icon.svg" style="height: 300px ; width=250px;"></div>
								</div>
								
									<div class="col-sm-6" style="width: 500px;">
										<div class="boxinfo"  style="color : #fff;">
											<div class="boxinfo--impostazioni">
												<form method="post" action="" id="FormMail">
													<div class="cambiaemail">
														<div class="control-group">
															<label class="lead" for="editemail">Email</label>
															<div class="controls">
																<input id="editemail" name="email" type="text"
																	placeholder="" class="input-xlarge"
																	required />
															</div>
															<button type="submit" id="btnSave"
																name="btnSaveMail" class="btn btn-success">Salva</button>
														</div>
													</div>
												</form>
												<form method="post" action="" id="FormPassword">
													<div class="cambiapassword">
														<div class="control-group">
															<label class="control-label lead" for="editpassword">Cambia
																Password</label>
															<div class="controls">
																<input id="editpassword" name="password"
																	type="text" placeholder="" class="input-xlarge" required>
															</div>
														</div>
														<button type="submit" id="btnSave" name="btnSave"
															class="btn btn-success">Salva</button>
													</div>
												</form>
												<form method="post" action="CambiaAvatar"
													enctype="multipart/form-data">
													<div class="cambiaimmagine">
														<div class="control-group">
															<label class="control-label lead" for="editimmagine">Cambia
																Immagine</label>
															<div class="controls">
																<input type="file" id="main-input" name="avatar"
																	class="form-control form-input form-style-base">
																<h2 id="fake-btn"
																	class="form-input fake-styled-btn text-center truncate"></h2>
															</div>
															<button id="btnSave" name="btnSave"
																class="btn btn-success">Salva</button>
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
					</div>
							
							
							
							
							
							<!-- ******************FineProfiloUtente********************** -->
						</div>

					</div>

				</div>

			</div>

		</section>

		



<script type="text/javascript" src="dist/jplayer/jquery.jplayer.min.js"></script>
<script type="text/javascript" src="js/search.js"></script>
<script type="text/javascript" src="js/lettore.js"></script>
<script type="text/javascript" src="js/Playlist.js"></script>

		<script
			src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>



		<script src="js/index.js"></script>
	</c:if>
	<c:if test="${username == null}">
		<!--  <meta http-equiv="Refresh" content="0; http://192.168.43.197:8080/IngSWMicroK/Home.html"/> -->
		<meta http-equiv="Refresh"
			content="0; http://192.168.1.8:8080/IngSWMicroK/index.html" />
	</c:if>


</body>
<footer>
<section>


			<div id="jquery_jplayer"></div>
			<div class="demo-container">

				<ul>
					<span class="play-state"></span> :
					<span class="track-name">nothing</span> at
					<span class="extra-play-info"></span> of
					<span class="jp-duration"></span>, which is
					<span class="jp-current-time"></span>
				</ul>
				<ul>
					<li><a class="jp-play  icon-play" href="#">Play</a></li>
					<li><a class="jp-pause icon-pause" href="#">Pause</a></li>
					<li><a class="jp-stop" href="#">Stop</a></li>
				</ul>
				<ul>
					<li>volume :</li>
					<li><a class="jp-mute" href="#">Mute</a></li>
					<li><a class="jp-unmute" href="#">Unmute</a></li>
					<li><a class="jp-volume-bar" href="#">|&lt;----------&gt;|</a></li>
					<li><a class="jp-volume-max" href="#">Max</a></li>
				</ul>
			</div>
		</section>
		</footer>
</html>