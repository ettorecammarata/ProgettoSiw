
$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: 'prodotti?action=demo2',
        headers: {
            Accept: "application/json charset=utf-8",
            "Content-Type": "application/json; charset=utf-8"
        },
        success: function (result) {
            var listproducts = $.parseJSON(result);
            var s = '';
            for (var i = 0; i < listproducts.length; i++) {
                //s+='id:'+listproducts[i].idCanzone+'<br>Name:'+listproducts[i].titolo+'<br>Name:'+listproducts[i].Album+'<br>:::::::::::::::::::::::::::::::::<br>';
                s += '<div class="col-sm-3 text-center">' + '<img class="copertina" alt="" src="' + listproducts[i].url + '"><p>'
                    + listproducts[i].titolo + '</p><h2>' + listproducts[i].artista.nomeArtista + '</h3><p>' + listproducts[i].genere + '</p><a href="addToCart?id=' + listproducts[i].idCanzone +
                    '&from=paginaPrincipale.jsp"><i class="fa fa-shopping-cart"></i>Add to cart</a></div>';

            }
            document.getElementById('result2').innerHTML = s;
        }
    });

    $('#buttonCart').click(function () {
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
    $('#button2').click(function () {

        $.ajax({
            type: 'GET',
            url: 'prodotti?action=demo2',
            headers: {
                Accept: "application/json charset=utf-8",
                "Content-Type": "application/json; charset=utf-8"
            },
            success: function (result) {
                var listproducts = $.parseJSON(result);
                var s = '';
                for (var i = 0; i < listproducts.length; i++) {
                    //s+='id:'+listproducts[i].idCanzone+'<br>Name:'+listproducts[i].titolo+'<br>Name:'+listproducts[i].Album+'<br>:::::::::::::::::::::::::::::::::<br>';
                    s += '<div class="col-sm-3 text-center">' + '<img class="copertina" alt="" src="' + listproducts[i].url + '"><p>' +
                        + listproducts[i].titolo + '</p><h2>' + listproducts[i].artista.nomeArtista + '</h3><p>' + listproducts[i].genere + '</p>' + '<a href="addToCart?id=' +
                        listproducts[i].idCanzone + "\"&from=paginaPrincipale.jsp>" + '<i class="fa fa-shopping-cart"></i>Add to cart</a></div>';
                }
                document.getElementById('result2').innerHTML = s;
            }
        });

    });
});




