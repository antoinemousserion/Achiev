/**
 * 
 */
function desinscription() {

	if(!confirm("Êtes vous vraiment sur de vouloir vous désinscrire ?")){
		return;
	}
    fetch(apiHost+"FAB1/service/utilisateurs/desinscription", {
        method: 'delete',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    }).then(function f(){
        sessionStorage.setItem("isconnected",false);
        location.replace(apiHost+"FAB1")

    })
}