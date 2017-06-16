
function Utente(username, nome, cognome, email, password) {
	this.username = username;
	this.nome = nome;
	this.cognome = cognome;
	this.email = email;
	this.password = password;
}

function CreateUtente() {
	console.log("aaaaaaaaaaaaaaaaaaaaaaa");
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
	var password = campo.val();
	//password = hex_sha1(password);
	
	var utente = new Utente(username, nome, cognome, email, password);
	return utente;
}

function registraUtente(form) {

	var utente = CreateUtente();
	
	var registrazione = false;
	var jsonUtente = {
			username : utente.username,
			nome : utente.nome,
			cognome : utente.cognome,
			email : utente.email,
			password : utente.password
		};
console.log(jsonUtente);
		$.ajax({
			async : false,
			type : "POST",
			url : "Registrazione",
			datatype : "json",
			data : {
				utenteRegistrazione : JSON.stringify(jsonUtente),
			},

			success : function(data) {
				
				
				if(data == 0) {
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
					form.Username.focus();
				}
			},

			error : function(data) {
				
				swal({
					  title: "Errore!",
					  text:"Impossibile completare la registrazione",
					  type: "error",
					  confirmButtonText: "Riprova"
					});
				
				registrazione = false;
				form.Username.value='';
				form.Username.focus();
				form.Username.scrollIntoView();
			}
			
		});

		return Boolean(registrazione);
}

$(document).ready();

