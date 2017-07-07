function Campionato(nome, password) {
	this.nome = nome;
	this.password = password;
}

function getCredenzialiForm() {
	var campi = $("#formLoginCampionato").find("input");

	var campo = campi.eq(0);
	var nome = campo.val();

	campo = campi.eq(1);
	var password = campo.val();
	var campionato = new Campionato(nome, password);
	return campionato;
}

function loginCampionato(form) {

	var successBoolean = false;
	var credenziali = getCredenzialiForm();
	var jsonCredenziali = {
		nome : credenziali.nome,
		password : credenziali.password
	};

	$.ajax({

		async : false,
		type : "POST",
		url : "LoginCampionato",
		datatype : "json",
		data : {

			credenzialiAmministratore : JSON.stringify(jsonCredenziali),

		},
		success : function(data) {

			if (data == 1) {
				swal({
					title : "Password errata!",
					type : "warning",
					confirmButtonText : "Riprova"
				});
				form.Password.value = '';
				form.Password.focus();
				form.Password.select();

				successBoolean = false;

			} else if (data == 2) {
				swal({
					title : "Nome errato!",
					type : "warning",
					confirmButtonText : "Riprova"
				});
				form.Nome.value = '';
				form.Nome.focus();
				form.Nome.select();
				successBoolean = false;
			} else if (data == 0) {
				successBoolean = true;
			}

		},
		error : function(data) {

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
