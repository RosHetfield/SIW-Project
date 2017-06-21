
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
			console.log("sono la gggtthttrk");

			if (data == 0) {

				succ = true;
			}
			if (data == 1) {
				swal({
					title : "Attenzione!",
					text : "Mercato Chiuso ",
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


