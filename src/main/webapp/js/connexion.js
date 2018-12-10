/**
 * 
 */
var apiHost = "http://localhost:8080/"
var user = {

}


function setUser() {
    user.email = document.getElementById("email").value;
    user.password = document.getElementById("password").value;

    connectUser()
    	
    
    


}

function connectUser() {
    var error = true;

    fetch(apiHost+"FAB1/service/utilisateurs/connexion", {
        method: 'post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
        .then(function functionName (response) {
            if (response.ok) {
            	
            	 
                return;
            }
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
    	    sessionStorage.setItem("isconnected",true);
    		location.replace(apiHost+"FAB1/accueil.html");
    		sleep(1000);
    		Toastify({
        		  text: "Connecté",
        		  duration: 3000
        		}).showToast();
    		
    	}
    });
    return error;

}
function sleep(ms) {
	  return new Promise(resolve => setTimeout(resolve, ms));
	}