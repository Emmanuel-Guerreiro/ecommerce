console.log("loaded");
const button = document.getElementById("add-producto-btn");
const cantidad = document.getElementById("cantidad");
const ir_Carrito = document.getElementById("ir-carrito");

button.addEventListener("click", function () {
  agregarACarrito();
});

function agregarACarrito() {
  const productoId = window.location.pathname.split("/")[2];
  const item = { cantidad: cantidad.value, producto: productoId };
  const user = JSON.parse(sessionStorage.getItem("JwtResponse"));
  if (user == null) {
    if (confirm("Inicie sesion para continuar con la compra")) {
      window.location.href =
        "https://ecommerce-production-5d12.up.railway.app/login";
    }
  }

  fetch(
    "https://ecommerce-production-5d12.up.railway.app/api/v1/carrito/" +
      user.id +
      "/item",
    {
      method: "POST",
      body: JSON.stringify(item),
      headers: {
        "Content-Type": "application/json",
      },
    }
  ).then((res) => {
    if (res.status == 201) {
      ir_Carrito.style.display = "inline";
    }
  });
}

ir_Carrito.addEventListener("click", function () {
  const user = JSON.parse(sessionStorage.getItem("JwtResponse"));
  window.location.href = "/carrito/" + user.id;
});
