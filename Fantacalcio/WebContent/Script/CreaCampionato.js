function Campionato(NomeCampionato, password) {
	this.nomeCampionato = nomeCampionato;
	this.password = password;
//nomecreatore???
}


function CreaCampionato() {
	console.log("aaaaaaaaaaaaaaaaaaaaaaa");
	var campi = $("#formCreaCampionato").find("input");
	var campo = campi.eq(0);
	var nomeCampionato = campo.val();
	
	campo = campi.eq(1);
	var password = campo.val();
	
	var Campionato = new Campionato(nomeCampionato, password);
	return Campionato;
}




function registraCampionato(form) {

	var campionato = CreaCampionato();
	
	var registrazione = false;
	var jsonCampionato = {
			nomeCampionato : campionato.nomeCampionato,
			password : campionato.password
		};

	console.log(jsonCampionato);
	
		$.ajax({
			async : true,
			type : "POST",
			url : "Registrazione",
			datatype : "json",
			data : {
				creazioneCampionato : JSON.stringify(jsonCampionato),
			},

			success : function(data) {
				
				/*swal({
					  title: "Benvenuto!",
					  text:"Registrazione effettuata con successo!",
					  confirmButtonText: "OK",
					  type: "success"
					});*/
				registrazione = true;
			},

			error : function(data) {
				if(data == 1) {
					swal({
						  title: "Username utilizzato!",
						  text:"Impossibile completare la registrazione",
						  type: "warning",
						  confirmButtonText: "Riprova"
						});
				}
				else {
				swal({
					  title: "Errore!",
					  text:"Impossibile completare la registrazione",
					  type: "error",
					  confirmButtonText: "Riprova"
					});
				}
				registrazione = false;
				form.Username.value='';
				form.Username.focus();
				form.Username.scrollIntoView();
			}
			
		});

		return Boolean(registrazione);
}

$(document).ready();