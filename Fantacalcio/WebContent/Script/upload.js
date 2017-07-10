$('#btnUpload').click(function() {

	var fileTypes = [ 'xls', 'xlsx' ];
	var input = $('#file')[0];
	if (input.files && input.files[0]) {
		var extension = input.files[0].name.split('.').pop().toLowerCase(),

		isSuccess = fileTypes.indexOf(extension) > -1;

		if (isSuccess) {
			var file = $('#file')[0].files[0];
			if (file == null) {
				swal({
					title : "Attenzione!",
					text : "Selezionare file",
					type : "error",
					confirmButtonText : "Ok"
				});				return;
			}

			var formData = new FormData();
			
			formData.append('file', file);

			$.ajax({
				async : false,
				type : "POST",
				url : "CaricaVoti",
				cache : false,
				contentType : false,
				processData : false,
				data : formData,
				success : function(data) {
					if (data == 0) {
						swal({
							title : "Voti caricati con successo!",
							text: "Giornata calcolata.",
							type : "success",
							confirmButtonText : "Ok"
						});
						setTimeout(function() {
							location.href = "GestioneCampionato";
						}, 2000);
					}
				},
				error : function(data) {
					swal({
						title : "Errore!",
						text : "Impossibile completare l'operazione.",
						type : "error",
						confirmButtonText : "Ok"
					});
				}
			});

		} else {
			swal({
				title : "Attenzione!",
				text : "Inserire un formato valido.",
				type : "warning",
				confirmButtonText : "Ok"
			});
			return false;
		}
	}

});
