function Utente(username, nome, cognome, email, password) {
	this.username = username;
	this.password = password;
}

function getCredenzialiForm() {
	var campi = $("#formLogin").find("input");

	var campo = campi.eq(0);
	var username = campo.val();

	campo = campi.eq(1);
	var password = hex_sha1(campo.val());
	
	var nome, cognome, email = null;
	var utente = new Utente(username, nome, cognome, email, password);
	return utente;
}

function controlLoginUtente(form) {

	var successBoolean = false;
	var credenziali = getCredenzialiForm();
	var jsonCredenziali = {
		username : credenziali.username,
		password : credenziali.password
	};

	$.ajax({

		async : true,
		type : "POST",
		url : "Login",
		datatype : "json",
		data : {

			credenzialiUtente : JSON.stringify(jsonCredenziali),

		},
		success : function(data) {

			if (data == 1) {
				swal({
					title : "Password errata!",
					type : "error",
					confirmButtonText : "Riprova"
				});
				form.Password.value = '';
				form.Password.focus();
				form.Password.select();

				successBoolean = false;

			} else if (data == 2) {
				swal({
					title : "Username errato!",
					type : "error",
					confirmButtonText : "Riprova"
				});
				form.Username.value = '';
				form.Username.focus();
				form.Username.select();
				form.Password.value = '';
				successBoolean = false;
			} else if (data == 0) {
				form.Password.value = '';
				location.href = "Home"
			}

		},
		error : function(data) {
			form.Password.value = '';
			swal({
				title : "Errore!",
				text : "Impossibile completare il login.",
				type : "error",
				confirmButtonText : "Riprova"
			});

		}

	});

	return Boolean(successBoolean);
}

$(document).ready();
