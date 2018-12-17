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
            //alert("Your account has been created, Welcome "+document.getElementById('username').value);
            createSuccess(document.getElementById('username').value);
            return null;
        }
        return response.json();
    }).then(function f(repJson){
        if (repJson != null) {
            //a rendre bo
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
            
             document.location.href="index.html";
             //setTimeout(alertify.success("Welcome !"),1500);
            return null;
        }
        return response.json();
    }).then(function f(repJson){
        if (repJson != null) {
            repJson.forEach(function f(truc){
                alertify.error(truc);
            });
            
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
        
        if (response.status == 204) {
            return null;
        }
        return response.json();
       
    }).then(function f(resJson){
        if (resJson != null){
            userCo.innerHTML = "Welcome <a class='lien' href='account.html'>"+resJson.username +"</a>"
        }else{
            userCo.innerHTML = "<a class='lien' href='login.html'>Log In</a>";
        }
        
    })
}
function createSuccess(username){
    document.getElementById("createSuccess").innerHTML = "<p>Your account has been successfuly created ! Welcome "+username+"</p><a href='index.html'><button type='button' class='buttonsubmit btn btn-success'>Back to Home page</button></a>";

}


document.onload(displayUserConnected());
