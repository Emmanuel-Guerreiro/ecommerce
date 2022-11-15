const confirmarButton = document.getElementById("confirmar-compra");

console.log("Loaded...");

confirmarButton.addEventListener("click", function () {
  console.log("Clicked");
  const carritoId = window.location.pathname.split("/")[2];
  const baseUrl = window.location.origin;
  const compraUrl = `${baseUrl}/compra/${carritoId}`;

  fetch(`http://localhost:9000/api/v1/facturas/pagar-carrito/${carritoId}`, {
    method: "POST",
  }).then(() => (window.location.href = compraUrl));
});
