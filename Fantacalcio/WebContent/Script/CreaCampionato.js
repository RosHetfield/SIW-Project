function Campionato(nome, password) {
	this.nome = nome;
	this.password = password;
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
					
					 console.log("sono qua con "+data);
						 return true;
				 }
				
				 if(data == 1) {
					swal({
						  title: "Nome campionato utilizzato!",
						  text:"Impossibile completare la creazione",
						  type: "warning",
						  confirmButtonText: "Riprova"
						});
					console.log(data);
					form.Nome_Campionato.value='';
					form.Nome_Campionato.focus();
					return false;
					 
				}
			},

			error : function(data) {
				
				swal({
					  title: "Errore!",
					  text:"Impossibile completare la creazione",
					  type: "error",
					  confirmButtonText: "Riprova"
					});
				
				form.Nome_Campionato.value='';
				form.Nome_Campionato.focus();
				form.Nome_Campionato.scrollIntoView();
				return false;
			}
			
		});

		
}

$(document).ready();