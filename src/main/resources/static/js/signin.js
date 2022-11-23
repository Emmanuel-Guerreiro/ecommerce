class SignUpRequest {
  username;
  email;
  role = [];
  password;

  constructor(email, username, password, roles) {
    this.email = email;
    this.username = username;
    this.password = password;
    this.role = roles;
  }
}

function registrarUsuario() {
  let email = document.getElementById("fieldEmail");
  let usuario = document.getElementById("fieldUsername");
  let pass = document.getElementById("exampleInputPassword1");
  let newUser = new SignUpRequest(email.value, usuario.value, pass.value, [
    "user",
  ]);

  fetch("https://ecommerce-production-5d12.up.railway.app/api/auth/signup", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(newUser),
  }).then(function (response) {
    console.log(response.status);
    if (response.status == 200) {
      response.json().then((json) => {
        console.log(json);
        alert("Se ha registrado exitosamente, por favor inicie sesión");
        window.location.href =
          "https://ecommerce-production-5d12.up.railway.app/login";
      });
    } else {
      response.json().then((json) => {
        console.log(json);
        alert(JSON.parse(JSON.stringify(json)).message);
      });
    }
  });
}
