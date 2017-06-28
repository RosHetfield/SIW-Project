$( "#btnUpload" ).click(function() {

var file = $("#file").files[0]; //this is the input where I can choose the file
if(file==null)
	{
	alert('selezionare file');
	return ;	
	}

var formData = new FormData();
formData.append('file', file);

var xhr = new XMLHttpRequest();
xhr.open('POST', 'CaricaVoti');
xhr.onload = function () {
    //TODO show the progress
};

xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
        //TODO success callback
    }
};

xhr.upload.onprogress = function (event) {
    //TODO show the progress
};

});
