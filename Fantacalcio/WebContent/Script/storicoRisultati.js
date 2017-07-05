function caricaGiornata(g) {
	$(document).ready(function(){
		
		$.ajax({

			async : true,
			type : "GET",
			url : "Risultati",
			datatype : "json",
			data : {
				
				ultimaGiornata:JSON.stringify(g)
			},
			success : function(data) {
				location.href="Risultati";
			},
			error : function(data) {
				swal({
					title : "Errore!",
					text : "Impossibile caricare i risultati!",
					type : "error",
					confirmButtonText : "Ok"
				});
			}
		});

	});
}

