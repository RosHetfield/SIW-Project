function checkFormazione() {
	console.log("sono la caccaaaaaaa");
	var succ = false;
	$.ajax({

		async : false,
		type : "POST",
		url : "Formazione",
		datatype : "json",
		data : {},
		success : function(data) {

			if (data == 1) {

				succ = true;
			}
			if (data == 0) {

				swal({
					title : "Attenzione!",
					text : "Mercato Chiuso ",
					type : "error",
					confirmButtonText : "Ok"
				});
				success = false;
			}
			if (data == 2) {
				swal({
					title : "Attenzione!",
					text : "Inserimento formazione Chiuso ",
					type : "error",
					confirmButtonText : "Ok"
				});
				success = false;

			}
		},
		error : function(data) {
			succ = false;
		}
	});
	return Boolean(succ)
}
