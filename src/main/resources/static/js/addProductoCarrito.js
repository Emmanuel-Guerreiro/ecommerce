console.log("loaded");
const button = document.getElementById("add-producto-btn");
const cantidad = document.getElementById("cantidad");
const irCarrito = document.getElementById("ir-carrito");

cantidad.addEventListener("click", function (e) {
  console.log(e.target.value);
});

button.addEventListener("click", function () {
  console.log();
  console.log(cantidad.value);
  agregarACarrito();
});

function agregarACarrito() {
  const productoId = window.location.pathname.split("/")[2];
  const item = { cantidad: cantidad.value, producto: productoId };

  fetch("http://localhost:9000/api/v1/carrito/1/item", {
    method: "POST",
    body: JSON.stringify(item),
    headers: {
      "Content-Type": "application/json",
    },
  }).then((res) => {
    if (res.status == 201) {
      irCarrito.style.display = "inline";
    }
  });
}

irCarrito.addEventListener("click", function () {
  console.log("asjdnaskj");
  window.location.href = "/carrito/1";
});
