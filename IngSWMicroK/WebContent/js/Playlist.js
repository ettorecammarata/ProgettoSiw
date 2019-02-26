function playlistGenere() {

    var string = ["Rock", "Rap", "Pop", "Metal"];


    $(document).ready(function () {
       // for (var j = 0; j < string.length; j++) {
            $.ajax({
                type: 'GET',
                url: 'playlist?action=demo2&genere=Rock' /*+ string[j]*/,
                headers: {
                    Accept: "application/json charset=utf-8",
                    "Content-Type": "application/json; charset=utf-8"
                },
                success: function (result) {
                    var record = $.parseJSON(result);

                    var t = '';

                    t += '<div class="overview__albums" >'
                        + '   <div class="overview__albums__head">'
                        + '		<span class="section-title">' + record.nomePlaylist + '</span> <span class="view-type"> <i class="fa fa-list list active"></i>'
                        + '       <i class="fa fa-th-large card"></i>'
                        + '		</span>'
                        + '</div>'
                        + '<div class="album">'
                        + '		<div class="album__info">'
                        + '           <div class="album__info__art">'
                        + '			    <img src="assets/generi/' + record.nomePlaylist + '.jpg"'
                        + '  				    alt="" />'
                        + '          </div>'
                        + '           <div class="album__info__meta">'
                        + '             <div class="album__name">' + record.nomePlaylist + '</div>'
                        + '				<div class="album__actions">'
                        + '					<button class="button-light save">More</button>'
                        + '				</div>'
                        + '			</div>'
                        + '       </div>'
                        + '		<div class="album__tracks">'
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


                    for (var i = 0; i < record.playlist.length; i++) {


                        t += '<div class="track" onclick="myFunction()" >'
                            + '					<div class="track__number">' + record.playlist[i].idCanzone + '</div>'
                            + '					<div class="track__added">'
                            + '						<i class="ion-checkmark-round added"></i>'
                            + '					</div>'
                            + '					<div href="' + record.playlist[i].url + '" class="track track-default track__title">' + record.playlist[i].artista.nomeArtista + ' - ' + record.playlist[i].titolo + '</div>'
                            + '					<div class="track__explicit">'
                            + '						<span class="label">' + record.playlist[i].artista.nomeArtista + '</span>'
                            + '					</div>'
                            + '					<div class="track__popularity">'
                            + '						<i class="ion-arrow-graph-up-right"></i>'
                            + '					</div>'
                            + '				</div>';
                    }
                    t += '		</div>'
                        + '	</div>'
                        + '</div>';







                    document.getElementById('result0' ).innerHTML = t;

                }
            });
        //}
    

 $.ajax({
                type: 'GET',
                url: 'playlist?action=demo2&genere=Pop' /*+ string[j]*/,
                headers: {
                    Accept: "application/json charset=utf-8",
                    "Content-Type": "application/json; charset=utf-8"
                },
                success: function (result) {
                    var record = $.parseJSON(result);

                    var t = '';

                    t += '<div class="overview__albums" >'
                        + '   <div class="overview__albums__head">'
                        + '		<span class="section-title">' + record.nomePlaylist + '</span> <span class="view-type"> <i class="fa fa-list list active"></i>'
                        + '       <i class="fa fa-th-large card"></i>'
                        + '		</span>'
                        + '</div>'
                        + '<div class="album">'
                        + '		<div class="album__info">'
                        + '           <div class="album__info__art">'
                        + '			    <img src="assets/generi/' + record.nomePlaylist + '.jpg"'
                        + '  				    alt="" />'
                        + '          </div>'
                        + '           <div class="album__info__meta">'
                        + '             <div class="album__name">' + record.nomePlaylist + '</div>'
                        + '				<div class="album__actions">'
                        + '					<button class="button-light save">More</button>'
                        + '				</div>'
                        + '			</div>'
                        + '       </div>'
                        + '		<div class="album__tracks">'
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


                    for (var i = 0; i < record.playlist.length; i++) {


                        t += '<div class="track" onclick="myFunction()" >'
                            + '					<div class="track__number">' + record.playlist[i].idCanzone + '</div>'
                            + '					<div class="track__added">'
                            + '						<i class="ion-checkmark-round added"></i>'
                            + '					</div>'
                            + '					<div href="' + record.playlist[i].url + '" class="track track-default track__title">' + record.playlist[i].artista.nomeArtista + ' - ' + record.playlist[i].titolo + '</div>'
                            + '					<div class="track__explicit">'
                            + '						<span class="label">' + record.playlist[i].artista.nomeArtista + '</span>'
                            + '					</div>'
                            + '					<div class="track__popularity">'
                            + '						<i class="ion-arrow-graph-up-right"></i>'
                            + '					</div>'
                            + '				</div>';
                    }
                    t += '		</div>'
                        + '	</div>'
                        + '</div>';







                    document.getElementById('result1' ).innerHTML = t;

                }
            });


 $.ajax({
                type: 'GET',
                url: 'playlist?action=demo2&genere=Metal' /*+ string[j]*/,
                headers: {
                    Accept: "application/json charset=utf-8",
                    "Content-Type": "application/json; charset=utf-8"
                },
                success: function (result) {
                    var record = $.parseJSON(result);

                    var t = '';

                    t += '<div class="overview__albums" >'
                        + '   <div class="overview__albums__head">'
                        + '		<span class="section-title">' + record.nomePlaylist + '</span> <span class="view-type"> <i class="fa fa-list list active"></i>'
                        + '       <i class="fa fa-th-large card"></i>'
                        + '		</span>'
                        + '</div>'
                        + '<div class="album">'
                        + '		<div class="album__info">'
                        + '           <div class="album__info__art">'
                        + '			    <img src="assets/generi/' + record.nomePlaylist + '.jpg"'
                        + '  				    alt="" />'
                        + '          </div>'
                        + '           <div class="album__info__meta">'
                        + '             <div class="album__name">' + record.nomePlaylist + '</div>'
                        + '				<div class="album__actions">'
                        + '					<button class="button-light save">More</button>'
                        + '				</div>'
                        + '			</div>'
                        + '       </div>'
                        + '		<div class="album__tracks">'
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


                    for (var i = 0; i < record.playlist.length; i++) {


                        t += '<div class="track" onclick="myFunction()" >'
                            + '					<div class="track__number">' + record.playlist[i].idCanzone + '</div>'
                            + '					<div class="track__added">'
                            + '						<i class="ion-checkmark-round added"></i>'
                            + '					</div>'
                            + '					<div href="' + record.playlist[i].url + '" class="track track-default track__title">' + record.playlist[i].artista.nomeArtista + ' - ' + record.playlist[i].titolo + '</div>'
                            + '					<div class="track__explicit">'
                            + '						<span class="label">' + record.playlist[i].artista.nomeArtista + '</span>'
                            + '					</div>'
                            + '					<div class="track__popularity">'
                            + '						<i class="ion-arrow-graph-up-right"></i>'
                            + '					</div>'
                            + '				</div>';
                    }
                    t += '		</div>'
                        + '	</div>'
                        + '</div>';







                    document.getElementById('result2' ).innerHTML = t;

                }
            });

 $.ajax({
                type: 'GET',
                url: 'playlist?action=demo2&genere=Rap' /*+ string[j]*/,
                headers: {
                    Accept: "application/json charset=utf-8",
                    "Content-Type": "application/json; charset=utf-8"
                },
                success: function (result) {
                    var record = $.parseJSON(result);

                    var t = '';

                    t += '<div class="overview__albums" >'
                        + '   <div class="overview__albums__head">'
                        + '		<span class="section-title">' + record.nomePlaylist + '</span> <span class="view-type"> <i class="fa fa-list list active"></i>'
                        + '       <i class="fa fa-th-large card"></i>'
                        + '		</span>'
                        + '</div>'
                        + '<div class="album">'
                        + '		<div class="album__info">'
                        + '           <div class="album__info__art">'
                        + '			    <img src="assets/generi/' + record.nomePlaylist + '.jpg"'
                        + '  				    alt="" />'
                        + '          </div>'
                        + '           <div class="album__info__meta">'
                        + '             <div class="album__name">' + record.nomePlaylist + '</div>'
                        + '				<div class="album__actions">'
                        + '					<button class="button-light save">More</button>'
                        + '				</div>'
                        + '			</div>'
                        + '       </div>'
                        + '		<div class="album__tracks">'
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


                    for (var i = 0; i < record.playlist.length; i++) {


                        t += '<div class="track" onclick="myFunction()" >'
                            + '					<div class="track__number">' + record.playlist[i].idCanzone + '</div>'
                            + '					<div class="track__added">'
                            + '						<i class="ion-checkmark-round added"></i>'
                            + '					</div>'
                            + '					<div href="' + record.playlist[i].url + '" class="track track-default track__title">' + record.playlist[i].artista.nomeArtista + ' - ' + record.playlist[i].titolo + '</div>'
                            + '					<div class="track__explicit">'
                            + '						<span class="label">' + record.playlist[i].artista.nomeArtista + '</span>'
                            + '					</div>'
                            + '					<div class="track__popularity">'
                            + '						<i class="ion-arrow-graph-up-right"></i>'
                            + '					</div>'
                            + '				</div>';
                    }
                    t += '		</div>'
                        + '	</div>'
                        + '</div>';







                    document.getElementById('result3' ).innerHTML = t;

                }
            });

    });


}
function playlist() {


    $(document).ready(function () {

        $.ajax({
            type: 'GET',
            url: 'playlist?action=utente',
            headers: {
                Accept: "application/json charset=utf-8",
                "Content-Type": "application/json; charset=utf-8"
            },
            success: function (result) {
                var record = $.parseJSON(result);

                var t = '';
for (var y=0;y<record.length;y++){
                t += '<div class="overview__albums" >'
                    + '   <div class="overview__albums__head">'
                    + '		<span class="section-title">' + record[y].nomePlaylist + '</span> <span class="view-type"> <i class="fa fa-list list active"></i>'
                    + '       <i class="fa fa-th-large card"></i>'
                    + '		</span>'
                    + '</div>'
                    + '<div class="album">'
                    + '		<div class="album__info">'
                    + '           <div class="album__info__art">'
                    + '			    <img src="assets/img/Icon.svg"'
                    + '  				    alt="" />'
                    + '          </div>'
                    + '           <div class="album__info__meta">'
                    + '             <div class="album__name">' + record[y].nomePlaylist + '</div>'
                    + '				<div class="album__actions">'
                    + '					<button class="button-light save">More</button>'
                    + '				</div>'
                    + '			</div>'
                    + '       </div>'
                    + '		<div class="album__tracks">'
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


                for (var i = 0; i < record[y].playlist.length; i++) {


                    t += '<div class="track" onclick="myFunction()" >'
                        + '					<div class="track__number">' + record[y].playlist[i].idCanzone + '</div>'
                        + '					<div class="track__added">'
                        + '						<i class="ion-checkmark-round added"></i>'
                        + '					</div>'
                        + '					<div href="' + record[y].playlist[i].url + '" class="track track-default track__title">' + record[y].playlist[i].artista.nomeArtista + ' - ' + record[y].playlist[i].titolo + '</div>'
                        + '					<div class="track__explicit">'
                        + '						<span class="label">' + record[y].playlist[i].artista.nomeArtista + '</span>'
                        + '					</div>'
                        + '					<div class="track__popularity">'
                        + '						<i class="ion-arrow-graph-up-right"></i>'
                        + '					</div>'
                        + '				</div>';
                }
                t += '		</div>'
                    + '	</div>'
                    + '</div>';

            }





                document.getElementById('resultPlaylist' ).innerHTML = t;

            }
        });
    });
}












