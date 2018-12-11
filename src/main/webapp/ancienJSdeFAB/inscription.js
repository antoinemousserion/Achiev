
/**
 * 
 */
var apiHost = "http://localhost:8080/"
var user = {

}


function setUser() {
    user.nom = document.getElementById("nom").value;
    user.prenom = document.getElementById("prenom").value;
    user.telephone = document.getElementById("telephone").value;
    user.email = document.getElementById("mail").value;
    if(checkPassword()){
        user.password = document.getElementById("password").value;
        inscrireUser();
    }else{
        afficheErreur("Veuillez confirmer votre mot de passe plz");
    }
}

function checkPassword() {
    if(document.getElementById("password").value == document.getElementById("passwordconfirm").value){
        return true;
    }else{
        return false;
    }

}
function afficheErreur(erreur) {
    alert(erreur);
}

function inscrireUser() {
    var error = false;
    fetch(apiHost+"FAB1/service/utilisateurs/inscription", {
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
            location.replace(apiHost+"FAB1/connexion.html")
        }
    })
}


























