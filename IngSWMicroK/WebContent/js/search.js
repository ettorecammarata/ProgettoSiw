/**
 * 
 */

function cerca() {
    $(document).ready(function () {
        if ($('#search').val().length >= 3) {
            $.ajax({
                type: 'GET',
                url: 'search?action=canzone&string=' + $('#search').val(),
                headers: {
                    Accept: "application/json charset=utf-8",
                    "Content-Type": "application/json; charset=utf-8"
                },
                success: function (result) {
                    var listresult = $.parseJSON(result);
                    var t = '<div class="overview__albums" >'
                        + '<div class="album__tracks">'
                        + '			<div class="tracks">'
                        + '				<div class="tracks__heading">'
                        + '					<div class="tracks__heading__number">#</div>'
                        + '					<div class="tracks__heading__title" id="demo">Song</div>'
                        + '					<div class="tracks__heading__length">'
                        + '						<i class="ion-ios-stopwatch-outline"></i>'
                        + '					</div>'
                        + '					<div class="tracks__heading__popularity">'
                        + '						<i class="ion-thumbsup"></i>'
                        + '					</div>'
                        + '				</div>';
                    for (var i = 0; i < listresult.length; i++) {
                        t += '<div class="track" onclick="myFunction()" >'
                            + '					<div class="track__number">' + listresult[i].idCanzone + '</div>'
                            + '					<div class="track__added">'
                            + '						<i class="ion-checkmark-round added"></i>'
                            + '					</div>'
                            + '					<div href="' + listresult[i].url + '" class="track track-default track__title">' + listresult[i].artista.nomeArtista + ' - ' + listresult[i].titolo + '</div>'
                            + '					<div class="track__explicit">'
                            + '						<span class="label">' + listresult[i].artista.nomeArtista + '</span>'
                            + '					</div>'
                            + '					<div class="track__length"></div>'
                            + '					<div class="track__popularity">'
                            + '						<i class="ion-arrow-graph-up-right"></i>'
                            + '					</div>'
                            + '				</div>';
                    }

                    t += '</div>'
                        + '</div>';

                    document.getElementById('resultCanzone').innerHTML = t;
                }
            });

        }
        if ($('#search').val().length >= 2) {
            $.ajax({
                type: 'GET',
                url: 'search?action=artista&string=' + $('#search').val(),
                headers: {
                    Accept: "application/json charset=utf-8",
                    "Content-Type": "application/json; charset=utf-8"
                },
                success: function (result) {
                    var listresult = $.parseJSON(result);

                    var t = ''
                        + '<div class="album__tracks">';
                    for (var i = 0; i < listresult.length; i++) {
                        t += '<div class="col-md-4 col-sm-4">'
                            + '          <div class="album__info__art">'
                            + '             <img src="' + listresult[i].pathImage + '" style="border-radius: 90%" alt="" />'
                            + '          </div>'
                            + '         <div class="album__info__meta">'
                            + '              <div class="album__name"  value="' + listresult[i].nomeArtista + '">' + listresult[i].nomeArtista
                            + '              <div class="album__actions">'
                            + '                  <button class="button-light save" id="_artista" value="' + listresult[i].nomeArtista + '" onclick="cercaCanzoniArtista(document.getElementById(\'_artista\').getAttribute(\'value\'))" >More</button>'
                            + '              </div>' + '</div>'
                            + '          </div>'
                            + '      </div>';
                    }

                    t += '</div>';

                    document.getElementById('resultArtista').innerHTML = t;
                }
            });

        }


    });

}

function cercaCanzoniArtista(nomeA) {
    // var tmp = document.getElementById("_artista");

    // var nomeA=tmp.getAttribute("value");
    $(document).ready(function () {

        $.ajax({
            type: 'GET',
            url: 'search?action=canzoneArtista&string=' + nomeA,
            headers: {
                Accept: "application/json charset=utf-8",
                "Content-Type": "application/json; charset=utf-8"
            },
            success: function (result) {
                var listresult = $.parseJSON(result);
                var t = '<div class="overview__albums" >'
                    + '<div class="album__tracks">'
                    + '			<div class="tracks">'
                    + '				<div class="tracks__heading">'
                    + '					<div class="tracks__heading__number">#</div>'
                    + '					<div class="tracks__heading__title" id="demo">Song</div>'
                    + '					<div class="tracks__heading__length">'
                    + '						<i class="ion-ios-stopwatch-outline"></i>'
                    + '					</div>'
                    + '					<div class="tracks__heading__popularity">'
                    + '						<i class="ion-thumbsup"></i>'
                    + '					</div>'
                    + '				</div>';
                for (var i = 0; i < listresult.length; i++) {
                    t += '<div class="track" onclick="myFunction()" >'
                        + '					<div class="track__number">' + listresult[i].idCanzone + '</div>'
                        + '					<div class="track__added">'
                        + '						<i class="ion-checkmark-round added"></i>'
                        + '					</div>'
                        + '					<div href="' + listresult[i].url + '" class="track track-default track__title">' + listresult[i].artista.nomeArtista + ' - ' + listresult[i].titolo + '</div>'
                        + '					<div class="track__explicit">'
                        + '						<span class="label">' + listresult[i].artista.nomeArtista + '</span>'
                        + '					</div>'
                        + '					<div class="track__length"></div>'
                        + '					<div class="track__popularity">'
                        + '						<i class="ion-arrow-graph-up-right"></i>'
                        + '					</div>'
                        + '				</div>';
                }

                t += '</div>'
                    + '</div>';

                document.getElementById('resultCanzoneArtista').innerHTML = t;
            }
        });
    });
    Artista(nomeA);
}
function Artista(nomeA) {

    $(document).ready(function () {

        $.ajax({
            type: 'GET',
            url: 'search?action=Artista&string=' + nomeA,
            headers: {
                Accept: "application/json charset=utf-8",
                "Content-Type": "application/json; charset=utf-8"
            },
            success: function (result) {
                var listresult = $.parseJSON(result);

                var img = document.getElementById("immagine_Artista");
                img.setAttribute("src", listresult[0].pathImage);
                var nome = document.getElementById("nome_Artista");
                nome.innerHTML = listresult[0].nomeArtista;
                var biografia = document.getElementById("textBiografy");
                biografia.innerHTML = listresult[0].TextBiografia;
            }
        });
        $.ajax({
            type: 'GET',
            url: 'search?action=artista1&string=' + nomeA,
            headers: {
                Accept: "application/json charset=utf-8",
                "Content-Type": "application/json; charset=utf-8"
            },
            success: function (result) {
                var listresult1 = $.parseJSON(result);
                var t = '';
                for (var j = 0; j < listresult1.length; j++) {

                    t += '<div class="overview__artist" >'
                        + '    <div class="section-title">Albums ' + j + '</div>'
                        + '    <div class="latest-release">'
                        + '          <div class="latest-release__art">'
                        + '              <img src="assets/logo.png" alt="">'
                        + '              <div class="album__actions">'
                        + '                  <button class="navigation__list__header collapsed button-light save" role="button" data-toggle="collapse" href="#more" '
                        + '                      aria-expanded="false" aria-controls="more">More</button>'
                        + '             </div>'
                        + '          </div>'
                        + '          <div class="latest-release__song">'
                        + '             <div class="latest-release__song__title">' + listresult1[j].nomePlaylist + '</div>'
                        + '          </div>'
                        + '     </div>'
                        + '     <div class="navigation__list" style="width : 500px ;">'
                        + '      <div class="collapse" id="more" aria-expanded="false" style="height: 0px;">';

                    for (var i = 0; i < listresult1[j].playlist.length; i++) {
                        t += '<a href="#" class="navigation__list__item">'
                            + '         <div class="tracks">'
                            + '             <div class="track" onclick="myFunction()">'
                            + '                   <div class="track__number">' + listresult1[j].playlist[i].idCanzone + '</div>'
                            + '                 <div class="track__added"> <i class="ion-checkmark-round added"></i>'
                            + '                 </div>'
                            + '                 <div href="' + listresult1[j].playlist[i].url + '"'
                            + '                     class="track track-default track__title">' + listresult1[j].playlist[i].artista.nomeArtista + ' - '
                            + '                        ' + listresult1[j].playlist[i].titolo + '                          </div>'
                            + '                 <div class="track__explicit"> <span class="label">' + listresult1[j].playlist[i].artista.nomeArtista + '</span>'
                            + '                 </div>'
                            + '                 <div class="track__popularity"> <i class="ion-arrow-graph-up-right"></i>'
                            + '                 </div>'
                            + '             </div>'
                            + '         </div>'
                            + '     </a>';
                    }
                    t += '      </div>' +
                        +'  </div >'
                        + '</div >';
                }
                document.getElementById('resultAlbum').innerHTML = t;
            }
        });
    });

}


function cercaAmministratoreArtista() {
    $(document).ready(function () {
        $.ajax({
            type: 'GET',
            url: 'search?action=artista&string=' + $('#search3').val(),
            headers: {
                Accept: "application/json charset=utf-8",
                "Content-Type": "application/json; charset=utf-8"
            },
            success: function (result) {
                var listresult = $.parseJSON(result);
                var t = '';
                for (var i = 0; i < listresult.length; i++) {
                    t += '  <tr>'
                        + '<td>' + listresult[i].nomeArtista + '</td>'
                        + '<td>' + +'</td>'
                        + '<td>' + +'</td>'
                        + '<td><button class="btn navbar-btn"  id="_artista_" value="' + listresult[i].nomeArtista + '" name="apri" onclick="caricaDatiArtista(document.getElementById(\'_artista_\').getAttribute(\'value\'))">'
                        + '		Apri</button></td>'
                        + ' </tr>';

                }
                document.getElementById('resultElencoArtista1').innerHTML = t;
            }
        });





    });


}
function cercaAmministratoreCanzoni() {
    $(document).ready(function () {
        $.ajax({
            type: 'GET',
            url: 'search?action=canzone&string=' + $('#search1').val(),
            headers: {
                Accept: "application/json charset=utf-8",
                "Content-Type": "application/json; charset=utf-8"
            },
            success: function (result) {
                var listresult = $.parseJSON(result);
                var t = '';
                for (var i = 0; i < listresult.length; i++) {
                    t += '  <tr>'
                        + '<td>' + listresult[i].artista.nomeArtista + '</td>'
                        + '<td>' + listresult[i].titolo + '</td>'
                        + '<td>' + listresult[i].album + '</td>'
                        + '<td><button class="btn navbar-btn" name="apri" id="_canzone_"  value="' + listresult[i].titolo + '" name="apri" onclick="caricaDatiCanzone(document.getElementById(\'_canzone_\').getAttribute(\'value\'))"caricaDatiCanzone>'
                        + '		Apri</button></td>'
                        + ' </tr>';

                }
                document.getElementById('resultElencoArtista1').innerHTML = t;
            }
        });





    });


}
function cercaAmministratoreEventi() {
    $(document).ready(function () {
        $.ajax({
            type: 'GET',
            url: 'search?action=artista&string=' + $('#search2').val(),
            headers: {
                Accept: "application/json charset=utf-8",
                "Content-Type": "application/json; charset=utf-8"
            },
            success: function (result) {
                var listresult = $.parseJSON(result);
                var t = '';
                for (var i = 0; i < listresult.length; i++) {
                    t += '  <tr>'
                        + '<td>' + listresult[i].nomeArtista + '</td>'
                        + '<td>' + +'</td>'
                        + '<td>' + +'</td>'
                        + '<td><button class="btn navbar-btn" id="_artista_" value="' + listresult[i].nomeArtista + '" name="apri" onclick="caricaDatiArtista(document.getElementById(\'_artista_\').getAttribute(\'value\'))">'
                        + '		Apri</button></td>'
                        + ' </tr>';

                }
                document.getElementById('resultElencoArtista1').innerHTML = t;
            }
        });





    });


}
function caricaDatiArtista(nomeA) {
    $(document).ready(function () {

        $.ajax({
            type: 'GET',
            url: 'search?action=artista&string=' + nomeA,
            headers: {
                Accept: "application/json charset=utf-8",
                "Content-Type": "application/json; charset=utf-8"
            },
            success: function (result) {
                var listresult = $.parseJSON(result);
                var img = document.getElementById("_immagine_Artista");
                img.setAttribute("value", listresult[0].pathImage);
                var nome = document.getElementById("_nome_Artista");
                nome.setAttribute("value", listresult[0].nomeArtista);
                var biografia = document.getElementById("_textBiografy");
                biografia.setAttribute("value", listresult[0].TextBiografia);
            }
        });

    });

}
function caricaDatiCanzone(nomeA) {
    $(document).ready(function () {

        $.ajax({
            type: 'GET',
            url: 'search?action=canzone&string=' + nomeA,
            headers: {
                Accept: "application/json charset=utf-8",
                "Content-Type": "application/json; charset=utf-8"
            },
            success: function (result) {
                var listresult = $.parseJSON(result);
                var id = document.getElementById("_id");
                id.setAttribute("value", listresult[0].idCanzone);
                var img = document.getElementById("_path_canzone");
                img.setAttribute("value", listresult[0].url);
                var nome = document.getElementById("_titolo");
                nome.setAttribute("value", listresult[0].titolo);
                var album = document.getElementById("_album");
                album.setAttribute("value", listresult[0].album);
                var anno = document.getElementById("_anno");
                anno.setAttribute("value", listresult[0].anno);
                var genere = document.getElementById("_genere");
                genere.setAttribute("value", listresult[0].genere);
                var casaDiscografica = document.getElementById("_casaDiscografica");
                casaDiscografica.setAttribute("value", listresult[0].casaDiscografica);
                var artistaa = document.getElementById("_artista");
                artistaa.setAttribute("value", listresult[0].artista.nomeArtista);
            }
        });

    });

}