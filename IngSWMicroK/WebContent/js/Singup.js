function Utente (nickname , nome , cognome , utenteartista , indirizzo , email , password , conferma ){
	this.nickname = nickname;
	this.nome = nome;
	this.cognome = cognome;
	this.utenteartista = utenteartista;
	this.indirizzo = indirizzo;
	this.email = email;
	this.password = password;
	this.conferma = conferma ; 
}



function checkPasswordMatch() {
	// Variabili associate ai campi del signup_form_data
	var nome = document.signup_form_data.nome.value;
	var cognome = document.signup_form_data.cognome.value;
	var nickname = document.signup_form_data.nickname.value;
	var password = document.signup_form_data.password.value;
	var conferma = document.signup_form_data.conferma.value;
	var indirizzo = document.signup_form_data.indirizzo.value;
	var email = document.signup_form_data.email.value;
	var email_reg_exp = /^([a-zA-Z0-9_.-])+@(([a-zA-Z0-9-]{2,})+.)+([a-zA-Z0-9]{2,})+$/;
	//Effettua il controllo sul campo NOME
	if ((nome == "") || (nome == "undefined")) {
		document.signup_form_data.nome.focus();
		return false;
	}
	//Effettua il controllo sul campo COGNOME
	else if ((cognome == "") || (cognome == "undefined")) {
		document.signup_form_data.cognome.focus();
		return false;
	}
	//Effettua il controllo sul campo NICKNAME
	else if ((nickname == "") || (nickname == "undefined")) {
		document.signup_form_data.nickname.focus();
		return false;
	}
	//Effettua il controllo sul campo PASSWORD
	else if ((password == "") || (password == "undefined")) {
		alert("Il campo Password è obbligatorio.");
		document.signup_form_data.password.focus();
		return false;
	}
	//Effettua il controllo sul campo CONFERMA PASSWORD
	if ((conferma == "") || (conferma == "undefined")) {
		alert("Il campo Conferma password è obbligatorio.");
		document.signup_form_data.conferma.focus();
		return false;
	}
	//Verifica l'uguaglianza tra i campi PASSWORD e CONFERMA PASSWORD
	else if (password != conferma) {
		alert("La password confermata è diversa da quella scelta, controllare.");
		document.signup_form_data.conferma.value = "";
		document.signup_form_data.conferma.focus();
		return false;
	}
	
	//Effettua il controllo sul campo INDIRIZZO
	else if ((indirizzo == "") || (indirizzo == "undefined")) {
		alert("Il campo Indirizzo è obbligatorio.");
		document.signup_form_data.indirizzo.focus();
		return false;
	}
	else if (!email_reg_exp.test(email) || (email == "") || (email == "undefined")) {
		alert("Inserire un indirizzo email corretto.");
		document.signup_form_data.email.select();
		return false;
	}
	//INVIA IL signup_form_data
	else {
		document.signup_form_data.action = "signUpServlet";
		document.signup_form_data.submit();
	}
}








/*
function checkPasswordMatch () {
	alert("ciao") ; 
	var password = $("#password").val () ; 
	var confermaPassword = $("#conferma").val();
	
	if (password != "" && confermaPassword != "") {
		if (password.length > 5 )
		{
			if (password == confermaPassword){
				$("#conferma").css("border", "2px solid green");
				if ($("#nome").val() != "" && $("#cognome").val() != ""
						&& $("#email").val() != "" && $("#nickname").val() != ""
						&& $("#indirizzo").val() != "") {
					$("#signup_btn").removeAttr("disabled");
				}
			}
			else {
				$("#conferma").css("border", "2px solid red");
				$("#signup_btn").attr("disabled", "disabled");
			}
			$("#conferma").removeAttr("style");
			$("#signup_btn").attr("disabled", "disabled"); 
		}
		else {
			$("#conferma").css("border", "2px solid red");
			$("#signup_btn").attr("disabled", "disabled");
		}
	}
}

function sendData() {
	var nickname = $("#nickname").val();
	var nome = $("#nome").val();
	var cognome = $("#cognome").val();
	var utenteartista = $("#utenteartista").val();
	var indirizzo = $("#indirizzo").val();
	var email = $("#email").val();
	var password = $("#password").val();
	var conferma = $("#conferma").val(); 
	
	var utente = new Utente (nickname , nome , cognome , utenteartista , indirizzo , email , password , conferma ) ; 
	
	var jsonUtente = {
			nickname : utente.nickname,
			nome : utente.nome ,
			cognome : utente.cognome,
			utenteartista : utente.utenteartista,
			indirizzo : utente.indirizzo ,
			email : utente.email,
			password : utente.password,
			conferma : utente.conferma,
		}
	
	$.ajax({
		type : "POST",
		url : "signUpServlet",
		datatype : "json",
		data : {
			toModify : JSON.stringify(jsonUser),
		},
		success : function(data) {
			location.reload();
		},
		error : function(data) {
			alert("Sorry some error occured please retry later");
		}
	});
	
	function init() {*/
		/*
		$("#modify_form_data").submit(function(event) {
			event.preventDefault();
		});
		$("#signup_btn").on("click", function() {
			sendData();
		});

		$("#notification").submit(function(event) {
			event.preventDefault();
		});

		$("#signup_btn_mailing").on("click", function() {
			sendMailing();
		});
		
	}*/
