recupererPanier();
var data = {};
var apiHost = "http://localhost:8080/"
	

function isConnected() {
	if (sessionStorage.getItem("isconnected") == null) {
		document.getElementById("alert").removeAttribute("hidden");
	} else {
		document.getElementById("alert").setAttribute("hidden", "");
	}
}

function recupererPanier() {

	fetch("/FAB1/service/commandes/panier")
			.then(function(reponse) {

				// si null ,ne rien faire
				return reponse.json();
			})
			.then(
					function(data) {
						var panierPlat = document.getElementById('tableau');
						panierPlat.innerHTML = "";

						var tr = document.createElement('tr');
						var titre = "<tr>";
						titre += "<th>Plats</th>";
						titre += "<th>Sous-total</th>";
						titre += "<th></th>";
						titre += "</tr>";

						tr.innerHTML = titre;
						panierPlat.appendChild(tr);

						var index = 0;

						var prixTotal = 0;
						data
								/* .plats */.forEach(function(plat) {
									var tr = document.createElement('tr');
									// td.setAttribute('class',"coucou c'est la
									// classe")

									tr.innerHTML = "<td>"
											+ plat.nom
											+ "</td><td>"
											+ plat.prix
											+ "</td><td><button class=\"buttonNote\" type=\"rsvBtn\" onclick=\"supprimerPanier("
											+ index
											+ ")\"><img src=\"icons/remove.png\" height=\"15\"/></button></td>"

									panierPlat.appendChild(tr);
									prixTotal += plat.prix;

									index++;
								})

						tr = document.createElement('tr');
						var total = "<tr>";
						total += "<th> </th>";
						total += "<th>Total : " + prixTotal + "</th>";
						total += "<th><button class=\"buttonCmd\" onclick=\"validerCommande()\">Commander</button></th>";
						total += "</tr>";
						tr.innerHTML = total;
						panierPlat.appendChild(tr);
					});

}

function supprimerPanier(id) {
	fetch("/FAB1/service/commandes/panier/remove/" + id)
			.then(function(reponse) {

				// si null ,ne rien faire
				return reponse.json();
			})
			.then(
					function(data) {
						var panierPlat = document.getElementById('tableau');
						panierPlat.innerHTML = "";

						var tr = document.createElement('tr');
						var titre = "<tr>";
						titre += "<th>Plats</th>";
						titre += "<th>Sous-total</th>";
						titre += "<th></th>";
						titre += "</tr>";

						tr.innerHTML = titre;
						panierPlat.appendChild(tr);

						var index = 0;

						data
								/* .plats */.forEach(function(plat) {
									var tr = document.createElement('tr');
									// td.setAttribute('class',"coucou c'est la
									// classe")

									tr.innerHTML = "<td>"
											+ plat.nom
											+ "</td><td>"
											+ plat.prix
											+ "</td><td><button class=\"buttonNote\" type=\"rsvBtn\" onclick=\"supprimerPanier("
											+ index
											+ ")\"><img src=\"icons/remove.png\" height=\"15\"/></button></td>"

									// <a
									// href=\"supprimerPanier("+index+")\"><img
									// src=\"icons/remove.png\"
									// height=\"20\"/></a>
									panierPlat.appendChild(tr);
									index++;
								})

						tr = document.createElement('tr');
						var total = "<tr>";
						total += "<th> </th>";
						total += "<th>Total</th>";
						total += "<th><button class=\"buttonCmd\" onclick=\"validerCommande()\">Commander</button></th>";
						total += "</tr>";
						tr.innerHTML = total;
						panierPlat.appendChild(tr);
					});
}

function validerCommande() {
	var body = document.getElementById("corps");
	body.innerHTML = '<form ><p>Choix du restaurant</p><div class="form-group"><select class="form-control" id="restaurant"><option value="1">Rennes</option><option value="2">Nantes</option><option value="3">Brest</option></select></div><div class="form-group"><label for="date">Choisissez une date de commande</label><input type="date" class="form-control" id="date"></div><p>Choisissez une heure</p><div class="form-group"><select class="form-control" id="heure"><option value="12">12h</option><option value="13">13h</option><option value="14">14h</option></select></div><button type="button" id="btnSubmit" onclick="finValidation()">Submit</button></form>';
	
}

function finValidation() {
//	data.heure = document.getElementById("restaurant").value;
//	data.jour = document.getElementById("date").value;
	data.choixRestaurant = document.getElementById("restaurant").value;
	
	
	fetch("/FAB1/service/commandes", {
		method : "POST",
		headers : {
			"Content-Type" : "application/json; charset=utf-8"
		},
		body : JSON.stringify(data)
	}).then(
	fetch("/FAB1/service/commandes/panier/vider", {
		method : "POST",
		headers : {
			"Content-Type" : "application/json; charset=utf-8"
		}		
	})).then(function f(){
		location.replace(apiHost+"FAB1/accueil.html")
	});
}

