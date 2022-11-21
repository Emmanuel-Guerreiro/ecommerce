const confirmarButton = document.getElementById("confirmar-compra");

console.log("Loaded...");

confirmarButton.addEventListener("click", function () {
  console.log("Clicked");
  const carritoId = window.location.pathname.split("/")[2];
  const baseUrl = window.location.origin;
  const compraUrl = `${baseUrl}/compra/${carritoId}`;
  
  fetch(`http://localhost:8080/api/v1/facturas/pagar-carrito/${carritoId}`, {
    method: "POST",
  }).then(function (response){
      if(response.status == 200 || response.status == 201){
         response.json().then(json => {
                 window.location.href = compraUrl
                 });
      }else{
        response.json().then(json => {
            console.log(json);
            alert(json);
          })
    } 
    }
  )
  })