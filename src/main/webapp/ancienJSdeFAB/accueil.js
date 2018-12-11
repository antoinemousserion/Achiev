
	fetch("/FAB1/service/accueil"
	).then(function(reponse) {
		return reponse.json();
	}).then(function(plat) {

		var pdm = document.getElementById('platDuMoment');
		pdm.innerHTML = "";
		pdm.innerHTML = plat.description;
		
		
		
		var nomPlat = document.getElementById('nomPlat');
		nomPlat.innerHTML = "";
		nomPlat.innerHTML = plat.nom;
		
        document.getElementById('imgPlatAccueil').style.backgroundImage = "url(\""+plat.imageURL+"\")";
        document.getElementById('imgPlatAccueil').style.height = "400px";
        document.getElementById('imgPlatAccueil').style.backgroundSize = "cover";

        
	});
