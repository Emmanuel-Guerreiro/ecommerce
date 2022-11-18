function getToken() {
    return JSON.parse(window.sessionStorage.getItem('JwtResponse'));
}


    document.addEventListener("DOMContentLoaded", function () { 
        if (getToken()) { 
           document.getElementById("btnLogout").style.display = "inline";
           document.getElementById("btnLogin").style.display = "none";
           document.getElementById("btnCarrito").style.display = "inline";
        } 
     });
   


function cerrarSesion() {
    window.sessionStorage.removeItem('JwtResponse');
    document.cookie = "autenticacion =; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;"
    return window.location.href="http://localhost:8080/login";
}


function irCarrito() {
    user = JSON.parse(sessionStorage.getItem('JwtResponse'));
    location.href= "http://localhost:8080/carrito/"+ user.id;

   
    
}

