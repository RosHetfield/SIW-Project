
function loginCampionato() {
	
	var login = false;
	
	swal({
		html:
		'<h3 style="text-transform:capitalize">Campionato</h3>'+
		'<input id="swal-input1" class="swal2-input" autofocus placeholder="Campionato">' +
		'<h3 style="text-transform:capitalize">Password</h3>'+
		'<input id="swal-input2" class="swal2-input" placeholder="Password">',
		 preConfirm: function() {
		   return new Promise(function(resolve) {
		   if (true) {
		    resolve([
		      document.getElementById('swal-input1').value,
		      document.getElementById('swal-input2').value
		    ]);
		   }
		  });
		 }
		 }).then(function(result) {
			 
			 var jsonCredenziali = {
					nome : result[0],
					password : result[1]
			};
			 
			 console.log(jsonCredenziali);
			 
			 $.ajax({
				 	
					async : true,
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
								type : "error",
								confirmButtonText : "Riprova"
							});
							form.Password.value = '';
							form.Password.focus();
							form.Password.select();

							login = false;

						}
						else if (data == 2) {
							swal({
								title : "Username errato!",
								type : "error",
								confirmButtonText : "Riprova"
							});
							form.Username.value = '';
							form.Username.focus();
							form.Username.select();
							successBoolean = false;
						} else if (data == 0) {
							login = true;
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
		});
	return Boolean(login);
}

$(document).ready();