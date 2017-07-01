$( '#btnUpload' ).click(function() {

var file = $('#file')[0].files[0]; //this is the input where I can choose the file
if(file==null)
	{
	alert('selezionare file');
	return ;	
	}


var formData = new FormData();
if(formData == null) {
	console.log("nullo");
}
formData.append('file', file);

$.ajax ({
	async : true,
	type : "POST",
	url : "CaricaVoti",
	cache: false,
    contentType: false,
    processData: false,
	data : formData,
	success : function(data) {
		if(data == 0) {
			alert("Giornata calcolata!");			
		}
	},
	error : function(data) {
		console.log("errore " + data);
	}
});

});
