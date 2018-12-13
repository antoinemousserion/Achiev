var user = {
    }


function register(){
    


	if (checkPassword()) {
		user.username = document.getElementById('username').value;
		user.battleTag = document.getElementById('battletag').value;
		user.password = document.getElementById('password').value;

		fetch("services/users/signin", {
        method: 'post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }).then(function f(response){
        if(response.ok){
            alert("Your account has been created, Welcome "+document.getElementById('username').value);
            return null;
        }
        return response.json();
    }).then(function f(repJson){
        if (repJson != null) {
            alert(repJson);
        }
    })
	}
}

function checkPassword(){
    
	if (document.getElementById('password').value.length < 5) {
        alert("You must have more than 5 letters in your password");

		return false;
	}
	if(document.getElementById('passwordconfirm').value == document.getElementById('password').value){
		return true;
	}
    alert("You must confirm your password correctly");
	return false;
}

function connection(){
        user.battleTag = document.getElementById('battletag').value;
        user.password = document.getElementById('password').value;

        fetch("services/users/login", {
        method: 'post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }).then(function f(response){
        if(response.ok){
            alert("Welcome !");
            return null;
        }
        return response.json();
    }).then(function f(repJson){
        if (repJson != null) {
            alert(repJson);
        }
    })
}
