

function mercato() {
	
	var succ = false;
	console.log("eeeeee");
	$.ajax({

		async : false,
		type : "POST",
		url : "Mercato",
		datatype : "json",
		data : {},
		success : function(data) {
			if(data == 0) {
				
				succ = true;
			}
			 if(data == 1) {
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