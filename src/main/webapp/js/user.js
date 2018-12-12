var user = {
}

var username = document.getElementById('username');
var battletag = document.getElementById('battletag');
var password = document.getElementById('password');
var passwordconfirm = document.getElementById('passwordconfirm');
function test(){
    fetch("services/users/userSession",{
        method: 'get',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json; charset=utf-8'
        }
    }).then(function f(response){
        console.log(response);
        return response.json();
    }).then(function f(repJson){
        console.log(repJson);
    });
}
function register(){
test();
return;

	if (checkPassword) {
		user.username = username;
		user.battleTag = battletag;
		user.password = password;

		fetch("services/users/signin", {
        method: 'post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }).then(function functionName (response) {
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
            location.replace(apiHost+"FAB1/connexion.html")
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
