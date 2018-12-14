
	fetch("services/users/isconnected", {
        method: 'get',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    }).then(function f(response){
    	console.log(response);
        if(!response.ok){
           document.location.href="error.html";
        }
       
    }).then(function f(resJson){
    	
    })

