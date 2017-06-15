function Utente(username,nome,cognome,email, password) {
	this.username = username;
	this.password = password;
}



function getCredenzialiForm() {
	console.log("aaaaaaaaaaaaaaaaaaaaaaa");
	var campi = $("#formLogin").find("input");
	
	var campo = campi.eq(0);
	var username = campo.val();
	
	campo = campi.eq(1);
	var password = campo.val();
	var nome,cognome,email=null;
	var utente = new Utente(username,nome,cognome,email, password);
	return utente;
}


function controlLoginUtente(form) {
	console.log("bbbbbbbbbbbbbb");

	var successBoolean=false;
	var credenziali= getCredenzialiForm();
	var jsonCredenziali = {
		username : credenziali.username,
		password : credenziali.password
	};

	$.ajax({

		async : false,
		type : "POST",
		url : "Login",
		datatype : "json",
		data : {

			credenzialiUtente : JSON.stringify(jsonCredenziali),

		},
		success : function(data) {

			if (data==1)
				{
				swal({
					  title: "Password errata!",
					  type: "error",
					  confirmButtonText: "Riprova"
					});
				form.password.focus();
				form.password.select();
				
				successBoolean=false;
				
				}
			
			else if (data==2)
				{
				swal({
					  title: "Username errato!",
					  type: "error",
					  confirmButtonText: "Riprova"
					});
				form.Username.focus();
				form.Username.select();
				successBoolean=false;
				}
			else if (data==0)
				{
				successBoolean=true;
				}
				
			

		},
		error : function(data) {

			swal({
				  title: "Errore!",
				  text:"Impossibile completare il login.",
				  type: "error",
				  confirmButtonText: "Riprova"
				});

		}

	});

	return Boolean(successBoolean);
}

$(document).ready();




