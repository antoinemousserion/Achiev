

var apiHost = "http://localhost:8080/"

function isConnected(){
	if(sessionStorage.getItem("isconnected") == null){
		document.getElementById("form").setAttribute("hidden","hidden");
		document.getElementById("alert").removeAttribute("hidden");
	}else{
		document.getElementById("alert").setAttribute("hidden","");
		document.getElementById("form").removeAttribute("hidden");
	}
}

function ajouter() {
	var jour = document.getElementById("date").value;
	var nbPersonne = document.getElementById("nbrPersonnes").value;
	var idRestaurant = document.getElementById("restaurant").value;
	var idTrancheHoraire = document.getElementById("trancheHoraire").value;
	var idUtilisateur;
	var data = {
		jour: jour,
		nbPersonne : nbPersonne,
		utilisateur : {id: idUtilisateur},
		//choixResto: idRestaurant,
		horaireSelectionne: {id: idTrancheHoraire}
	}
	
	fetch("/FAB1/service/reservations", {
		method : "POST",
		headers : {
			"Content-Type" : "application/json; charset=utf-8"
		},
		body : JSON.stringify(data)
	}).then(function(reponse) {
		//return reponse.json();
		console.log("OK");
	}).then(function(donneesAuFormatJson) {
		location.replace(apiHost+"FAB1/accueil.html");
		//succes(JSON.stringify(donneesAuFormatJson));
	});

}

