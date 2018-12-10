afficherListe();

function accessOrder(){
	var buttons = document.getElementsByClassName("buttoncarte");
	console.log(buttons)
	if(sessionStorage.getItem("isconnected") == null){
		console.log("notConnected")
		Array.prototype.filter.call(buttons, function(button){
		    button.setAttribute("hidden", "hidden");
		}); 
	}else{
		Array.prototype.filter.call(buttons, function(button){
			console.log("Connected")
		    button.removeAttribute("hidden");
		});
	}
}

function afficherListe() {
    var choix = document.getElementById("restaurant").value;
    fetch("/FAB1/service/restaurants/" + choix
    ).then(function (reponse) {
        return reponse.json();
    }).then(function (data) {
        var listePlat = document.getElementById('liste_plat');
        listePlat.innerHTML = "";
        

        data.plats.forEach(function (plat) {
            var div = document.createElement('div');
            div.setAttribute('class', "col-12 col-sm-6 col-md-4 touslesplats")
            
            var plat_design = "<div class=\"container-fluid div_plat\">";
            plat_design += "<div class=\"row\" id=\"blackrow\">";
            plat_design += "<div class=\"col-6\">";
            plat_design += "<a style=\"text-decoration: none\" href=\"plats.html/?id="+plat.id+"\"><h3 class=\"cartetoplat\">"+ plat.nom +"</h3></a>";
            plat_design += "</div>";
            plat_design += "<div class=\"col-3\">";
            plat_design += "<button class=\"buttoncarte\" hidden>Noter</button>";
            plat_design += "</div>";
            plat_design += "<div class=\"col-3\">";
            plat_design += "<button class=\"buttoncarte\" hidden onclick=\"ajouterPanier("+plat.id+")\"><img src=\"icons/AjouterNoir.png\" height=\"20\"/></button>";
            plat_design += "</div>";
            plat_design += "</div>";
            plat_design += "</div>";
            
            div.innerHTML = plat_design;
            
            div.style.backgroundImage = "url(\""+plat.imageURL+"\")";
            div.style.height = "400px";
            div.style.backgroundSize = "cover";
            listePlat.appendChild(div);
            accessOrder();
            
        })

    }).then(function functionName(response) {
        choisirLeRestaurant();
      });
}

function choisirLeRestaurant(){
	var choix = document.getElementById("restaurant").value;
	var data = {};

    fetch("/FAB1/service/commandes/choixResto/" + choix, {
        method: "POST",
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        },
        body: JSON.stringify(data)
    });
}

function ajouterPanier(id) {

    var data = {};

    fetch("/FAB1/service/commandes/panier/" + id, {
        method: "POST",
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        },
        body: JSON.stringify(data)
    }).then(function functionName(response) {
        Toastify({
        	text: "Le plat a été ajouté au panier",
    	  duration: 3000
    	}).showToast();
      });
//    Toastify({
//  	  text: "Le plat a été ajouté au panier",
//  	  duration: 3000
//  	}).showToast();

}


