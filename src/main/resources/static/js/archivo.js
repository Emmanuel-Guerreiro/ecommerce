let url_base = "https://ecommerce-production-5d12.up.railway.app";
function getToken() {
  return JSON.parse(window.sessionStorage.getItem("JwtResponse"));
}

function verificarRolAdmin(roles) {
  for (var i = 0; i < roles.length; i++) {
    if (roles[i] == "ROLE_ADMIN") {
      return true;
    }
  }
  return false;
}

document.addEventListener("DOMContentLoaded", function () {
  if (getToken()) {
    document.getElementById("btnLogout").style.display = "inline";
    document.getElementById("btnLogin").style.display = "none";
    document.getElementById("btnCarrito").style.display = "inline";
    document.getElementById("btnFacturas").style.display = "inline";
    if (verificarRolAdmin(getToken().roles)) {
      document.getElementById("btnCarrito").style.display = "none";
      document.getElementById("btnFacturas").style.display = "none";
    }
  }
});

function cerrarSesion() {
  window.sessionStorage.removeItem("JwtResponse");
  document.cookie =
    "autenticacion =; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;";
  return (window.location.href =
    url_base+"/login");
}

function irCarrito() {
  user = JSON.parse(sessionStorage.getItem("JwtResponse"));
  location.href =
    url_base+"/carrito/" + user.id;
}


function irHacia(id) {
  if (getToken() != null && verificarRolAdmin(getToken().roles)) {
    window.location.href = url_base + "/admin/producto/editar/" + id;
  } else {
    window.location.href = url_base + "/productos/" + id;
  }
}

function irA(){
  if(getToken() != null && verificarRolAdmin(getToken().roles)){
    window.location.href = url_base + "/admin";
  }else {
    window.location.href = url_base;
  }
}

function verMisCompras(){
  let user = JSON.parse(sessionStorage.getItem('JwtResponse'));
  window.location.href = url_base+"/compras/"+user.id;
}