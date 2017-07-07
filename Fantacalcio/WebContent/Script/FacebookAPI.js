window.fbAsyncInit = function() {
	FB.init({
		appId : '1397207707061702',
		cookie : true,
		xfbml : true,
		version : 'v2.8'
	});
	FB.AppEvents.logPageView();
};

(function(d, s, id) {
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id))
		return;
	js = d.createElement(s);
	js.id = id;
	js.src = "//connect.facebook.net/it_IT/sdk.js#xfbml=1&version=v2.9&appId=1397207707061702";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

function statusChangeCallback(response) {
	console.log('statusChangeCallback');
	console.log(response);
	// The response object is returned with a status field that lets the
	// app know the current login status of the person.
	// Full docs on the response object can be found in the documentation
	// for FB.getLoginStatus().
	if (response.status === 'connected') {
		// Logged into your app and Facebook.
		login();
	}
}

function checkLoginState() {
	FB.getLoginStatus(function(response) {
		statusChangeCallback(response);
	});
}

function LogoutFB() {
	FB.logout(function(response) {
	});	
}

function login() {
	console.log('Welcome!  Fetching your information.... ');
	FB.api('/me?fields=name,first_name,last_name,email', function(response) {
		console.log('Successful login for: ' + response.email + " "
				+ response.first_name + " " + response.last_name + " "
				+ response.id);
		
		var jsonCredenziali = {
				username : response.first_name,
				nome : response.first_name,
				cognome : response.last_name,
				facebook_id : response.id
		};
		console.log(JSON.stringify(jsonCredenziali));
		$.ajax({
			
			async : true,
			type : "POST",
			url : "Login",
			datatype : "json",
			data : {
				credenzialiUtente : JSON.stringify(jsonCredenziali)
			},
			success : function(data) {
				if(data == 0) {
					location.href = "Home";
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
	
}