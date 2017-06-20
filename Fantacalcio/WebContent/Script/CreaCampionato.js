function Campionato(nome, password) {
	this.nome = nome;
	this.password = password;
//nomecreatore???
}


function CreaCampionato() {
	var campi = $("#formCreaCampionato").find("input");
	var campo = campi.eq(0);
	var nomeCampionato = campo.val();
	
	campo = campi.eq(1);
	var password = campo.val();


	
	var campionato = new Campionato(nomeCampionato, password);
	return campionato;
}




function registraCampionato(form) {
	
	var campionato = CreaCampionato();

	var registrazione = false;
	var jsonCampionato = {
			nome : campionato.nome,
			password : campionato.password
		};

	console.log(jsonCampionato);
	
		$.ajax({
			async : true,
			type : "POST",
			url : "CreaCampionato",
			datatype : "json",
			data : {
				creazioneCampionato : JSON.stringify(jsonCampionato),
			},
			success : function(data) {
				 if(data == 0) {
					 swal({
						  title: "campionato creato!",
						  text:"Completa le operazioni nella sezione dedicata",
						  type: "success",
						  confirmButtonText: "Ok"
						});
						form.Nome_Campionato.value='';
						form.Password_Campionato.value='';
				 }
				
				 if(data == 1) {
					swal({
						  title: "Nome campionato utilizzato!",
						  text:"Impossibile completare la creazione",
						  type: "warning",
						  confirmButtonText: "Riprova"
						});
					console.log(data);
					registrazione = false;
					form.Nome_Campionato.value='';
					form.Nome_Campionato.focus();
				}
			},

			error : function(data) {
				
				swal({
					  title: "Errore!",
					  text:"Impossibile completare la creazione",
					  type: "error",
					  confirmButtonText: "Riprova"
					});
				
				registrazione = false;
				form.Nome_Campionato.value='';
				form.Nome_Campionato.focus();
				form.Nome_Campionato.scrollIntoView();
			}
			
		});

		return Boolean(registrazione);
}

$(document).ready();