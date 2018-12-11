var user = {
}

var username = document.getElementById('username');
var battletag = document.getElementById('battletag');
var password = document.getElementById('password');
var passwordconfirm = document.getElementById('passwordconfirm');

function register(){
	if (checkPassword) {
		user.username = username;
		user.battletag = battletag;
		user.password = password;

		fetch("service/users/signin", {
        method: 'post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
        .then(function functionName (response) {
            if(response.ok){
                alert("Votre compte a été créé avec succès GG");
                return;
            }
            error = true;
            return response.json();

        }).then( function functionName (repJson) {
        if (repJson == null){
            error = false;
            return;
        }
        // a rendre plus bo :
        alert(repJson);

    }).then(function f(){
        if(!error){
            //blabla
        }
    })
	}
}

function checkPassword(){
	if (password.value.length < 5) {

		return false;
	}
	if(passwordconfirm.value == password.value){
		return true;
	}
	return false;
}
