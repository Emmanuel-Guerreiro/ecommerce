class Cliente {
    email;
    usuario;
    password;

    constructor(email,usuario,password){
        this.email = email;
        this.usuario = usuario;
        this.password = password;
    }

}


    function registrarUsuario(){
        let email = document.getElementById("exampleInputEmail1");
        let usuario = document.getElementById("usuario");
        let pass = document.getElementById("exampleInputPassword1");
        let user = new Cliente(email.value, usuario.value, pass.value);
        console.log(user.email+" "+ user.password+" "+user.usuario);

        fetch('http://localhost:9000/api/v1/cliente/save', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(user)
            
          })
          .then(res => res.json())
          .then(data => console.log(data))
          .then(alert("Se ha registrado correctamente, inicie sesión"))
          .then(window.location.href = "http://localhost:9000/login");
}