const confirmarButton = document.getElementById("confirmar-compra");
let base = "https://ecommerce-production-5d12.up.railway.app";
console.log("Loaded...");

confirmarButton.addEventListener("click", function () {
  console.log("Clicked");
  const carritoId = window.location.pathname.split("/")[2];
  const baseUrl = window.location.origin;
  const compraUrl = `${baseUrl}/compra/`;

  fetch(
    base+`/api/v1/facturas/pagar-carrito/${carritoId}`,
    {
      method: "POST",
    }
  ).then(function (response) {
    if (response.status == 200 || response.status == 201) {
      response.json().then((json) => {
        console.log(json.id)
        window.location.href = compraUrl+json.id;
      });
    } else {
      response.json().then((json) => {
        console.log(json);
        alert(json);
      });
    }
  });
});
