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
             document.location.href="index.html";
            return null;
        }
        return response.json();
    }).then(function f(repJson){
        if (repJson != null) {
            alert(repJson);
        }
    })
}
function disconnect(){
        
        fetch("services/users/disconnect", {
        method: 'post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
       
    }).then(function f(){
        document.location.href="login.html";
    })
}

function displayUserConnected(){
    var userCo = document.getElementById("userConnected");
    fetch("services/users/usersession", {
        method: 'get',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    }).then(function f(response){
        console.log("test");
        if(!response.ok){
           return response.json();
        }
        return null;
       
    }).then(function f(resJson){
        if (resJson != null){
            userCo.innerHTML = "Welcome <a href='account.html'>"+resJson.username +"</a>"
        }else{
            userCo.innerHTML = "<a href='login.html'>Log In</a>";
        }
        
    })
}
