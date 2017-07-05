function caricaGiornata(g) {
	$(document).ready(function(){
		
		$.ajax({

			async : true,
			type : "GET",
			url : "Classifica",
			datatype : "json",
			data : {
				
				giornata:JSON.stringify(g)
			},
			success : function(data) {
				location.href="Classifica";
			},
			error : function(data) {
				swal({
					title : "Errore!",
					text : "Impossibile caricare la classifica!",
					type : "error",
					confirmButtonText : "Ok"
				});
			}
		});

	});
}

