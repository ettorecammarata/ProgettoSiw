
$(document).ready(function () {
        $.ajax({
            type: 'GET',
            url: 'prodotti?action=demo3',
            headers: {
                Accept: "application/json charset=utf-8",
                "Content-Type": "application/json; charset=utf-8"
            },
            success: function (result) {
                var record = $.parseJSON(result);
                var idCarrello = $.parseJSON(result);

                var t = '';

                for (var i = 0; i < record.length; i++) {
                    t += '  Id: ' + record[i].idCanzone + '  titolo: ' + record[i].titolo + '  artista:  ' + record[i].artista.nomeArtista + '  prezzo:   ' + record[i].prezzo;
                    
                    t+='<li class="row"><form><span class="itemName">'
												+ record[i].artista.nomeArtista + '  '  + record[i].titolo + '</span></form>'
												+ '<form class="form-inline m-auto"><span class="popbtn"><a class="arrow"></a></span></form>'
												+ '<form class="form-inline m-auto"><span class="price">' + record[i].prezzo
												+ '</span><span style="padding-left: 50px ; "></span><button class="btn navbar-btn btn-danger" '
												+'onclick=\'location.href="delete?cartCanzoneId='
									    		+ record[i].idCanzone+'&IdCart='+idCarrello+'&from=carrello.jsp" \' >rimuovi</button></form></li>';
               
               
                }
                    document.getElementById('result3').innerHTML = t;

            }
        });

    });






