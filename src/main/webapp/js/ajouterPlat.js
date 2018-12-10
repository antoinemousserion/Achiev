/**
 * 
 */
var apiHost = "http://localhost:8080/"
plat = {
		
}
function ajouter(){
	plat.description = document.getElementById("descriptionplat").value;
	plat.nom = document.getElementById("nomplat").value;
	plat.prix = document.getElementById("prix").value;
	plat.imageURL = document.getElementById("urlimg").value;
	fetch(apiHost+"FAB1/service/plats", {
        method: 'post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(plat)
    }).then(function f(response){
    	cleanChamps();
    	
    })
}

function cleanChamps(){
	document.getElementById("descriptionplat").value = "";
	document.getElementById("nomplat").value = "";
	document.getElementById("prix").value = "";
	document.getElementById("urlimg").value = "";
}
cleanChamps();
