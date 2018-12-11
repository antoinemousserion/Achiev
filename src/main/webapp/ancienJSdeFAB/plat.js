
var plat = new URLSearchParams(window.location.search).get('id');
console.log(plat);
afficherLePlat(plat);

function afficherLePlat(id){
	console.log("coucou c'est l'id : "+id);
	fetch("/FAB1/service/plats/" + id
    ).then(function (reponse) {
        return reponse.json();
    }).then(function (data) {
    	
    	
    	var photo = document.getElementById('photoPlatId');
    	photo.style.backgroundImage = "url(\""+data.imageURL+"\")";
    	photo.style.height = "400px";
    	photo.style.backgroundSize = "cover";
    	
        var titrePlat = document.getElementById('titrePlat');
        titrePlat.innerHTML = "";
        titrePlat.innerHTML = data.nom;
        
        var textPlat = document.getElementById('descrPlatPlat');
        textPlat.innerHTML = "";
        textPlat.innerHTML = data.description;
        
        var prixPlat = document.getElementById('prixPlat');
        prixPlat.innerHTML = "";
        prixPlat.innerHTML = data.prix+" €";
        
        var ajoutPlat = document.getElementById('ajoutPlat');
        ajoutPlat.innerHTML = "";
        ajoutPlat.innerHTML = "<button class=\"buttoncarte\" onclick=\"ajouterPanier("+data.id+")\"><img src=\"icons/AjouterNoir.png\" height=\"20\"/></button>";
        

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

}

function extractUrlParams(){	
	var t = location.search.substring(1).split('&');
	var f = [];
	for (var i=0; i<t.length; i++){
		var x = t[ i ].split('=');
		f[x[0]]=x[1];
	}
	return f;
}