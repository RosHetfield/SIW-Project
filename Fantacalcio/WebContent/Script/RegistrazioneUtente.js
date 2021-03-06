function Utente(username, nome, cognome, email, password, passwordCheck) {
	this.username = username;
	this.nome = nome;
	this.cognome = cognome;
	this.email = email;
	this.password = password;
	this.passwordCheck = passwordCheck;
}

function CreateUtente() {
	var campi = $("#formRegistrazione").find("input");

	var campo = campi.eq(0);
	var username = campo.val();

	campo = campi.eq(1);
	var nome = campo.val();

	campo = campi.eq(2);
	var cognome = campo.val();

	campo = campi.eq(3);
	var email = campo.val();

	campo = campi.eq(4);
	var password = hex_sha1(campo.val());

	campo = campi.eq(5);
	var passwordCheck = hex_sha1(campo.val());
	
	var utente = new Utente(username, nome, cognome, email, password, passwordCheck);
	return utente;
}

function registraUtente(form) {

	var utente = CreateUtente();
	if(utente.password != utente.passwordCheck) {
		swal({
			  title: "Attenzione!",
			  type: "warning",
			  confirmButtonText: "Riprova"
			});
		return false;
	}
	var registrazione = false;
	var jsonUtente = {
			username : utente.username,
			nome : utente.nome,
			cognome : utente.cognome,
			email : utente.email,
			password : utente.password,
		};
	
		$.ajax({
			async : true,
			type : "POST",
			url : "Registrazione",
			datatype : "json",
			data : {
				utenteRegistrazione : JSON.stringify(jsonUtente),
			},

			success : function(data) {
				
				
				if(data == 0) {
					form.Password.value='';
					form.Password_confirmation.value='';
					location.href = "Home";
					registrazione = true;
				}
				else if(data == 1) {
					swal({
						  title: "Username utilizzato!",
						  text:"Impossibile completare la registrazione",
						  type: "warning",
						  confirmButtonText: "Riprova"
						});
					registrazione = false;
					form.Username.value='';
					form.Password.value='';
					form.Password_confirmation.value='';
					form.Username.focus();
				}
			},


		error : function(data) {

			swal({
				title : "Errore!",
				text : "Impossibile completare la registrazione",
				type : "error",
				confirmButtonText : "Riprova"
			});

			registrazione = false;
			form.Username.value = '';
			form.Password.value = '';
			form.Password_confirmation.value = '';
			form.Username.focus();
			form.Username.scrollIntoView();
		}

	});

	return Boolean(registrazione);
}

