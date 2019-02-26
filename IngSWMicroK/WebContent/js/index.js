// Sliders

var slider = document.getElementById('song-progress');

noUiSlider.create(slider, {
	start: [ 20 ],
	range: {
		'min': [   0 ],
		'max': [ 100 ]
	}
});

var slider = document.getElementById('song-volume');

noUiSlider.create(slider, {
	start: [ 90 ],
	range: {
		'min': [   0 ],
		'max': [ 100 ]
	}
});

// Tooltips

$(function () {
  $('[data-toggle="tooltip"]').tooltip()
})

// Viewport Heights

$(window).on("resize load", function(){
  
  var totalHeight = $(window).height();

  var headerHeight = $('.header').outerHeight();
  var footerHeight = $('.current-track').outerHeight();
  var playlistHeight = $('.playlist').outerHeight();
  var nowPlaying = $('.playing').outerHeight();

  var navHeight = totalHeight - (headerHeight + footerHeight + playlistHeight + nowPlaying);
  var artistHeight = totalHeight - (headerHeight + footerHeight);

  console.log(totalHeight);
  
  $(".navigation").css("height" , navHeight);
  $(".artist").css("height" , artistHeight);
  $(".social").css("height" , artistHeight);
  
});
    


  

// Collapse Toggles

$(".navigation__list__header").on( "click" , function() {
  
  $(this).toggleClass( "active" );
  
});


// Media Queries

$(window).on("resize load", function(){
	if ($(window).width() <= 768){	
		
    $(".collapse").removeClass("in");
    
    $(".navigation").css("height" , "auto");
    
    $(".artist").css("height" , "auto");
    
	}	
});

$(window).on("resize load", function(){
	if ($(window).width() > 768){	
		
    $(".collapse").addClass("in");
    
	}	
});

$(document).ready(function(){
// Calcola la posizione in altezza dell'elemento. Usa outerHeight() se hai del padding https://api.jquery.com/outerHeight/ o offset().top.
//Altrimenti usa anche height() https://api.jquery.com/height/
//#nav è il selettore del menù di navigazione
var navHeight = $('#nav').outerHeight();
// Entra quando si scrolla la pagina
$(window).scroll(function(){
// Se scorre la pagina oltre il valore salvato in navHeight (quindi la posizione della nav Bar), esegue altre istruzioni
if ($(window).scrollTop() > navHeight){
// Aggiunge la classe .fixed al menù, così da renderlo fisso nella parte superiore dello schermo (impostato tramite style.css)
$('#nav').addClass('fixed');
// aggiungo il padding al contenuto principale, altrimenti l'inizio non si vedrebbe a causa della sovrapposizione della barra di navigazione
$('#content').css('padding-top', navHeight+'px');
}else{
// se torna sopra il valore di navHeight, rimuove la classe .fixed, e la barra ritorna alla sua posizione originale
$('#nav').removeClass('fixed');
// rimuovo il padding
$('#content').css('padding-top', '0');
}
});
});


