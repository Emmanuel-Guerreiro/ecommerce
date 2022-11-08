class DTOCliente {
    usuario;
    password;

    constructor(usuario, password) {
        this.usuario = usuario;
        this.password = password;
    }
}


function loginUsuario() {
    let usuario = document.getElementById("exampleInputEmail1");
    let pass = document.getElementById("exampleInputPassword1");
    let user = new DTOCliente(usuario.value, pass.value);
    console.log(user.password + " " + user.usuario);

    fetch('http://localhost:9000/api/v1/cliente/loguin', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)

    })
        .then(function (response) {
            console.log(response.status)
            if (response.status == 200) {
                response.json().then(json => {
                    console.log(json);
                    localStorage.setItem('AuthObj', JSON.stringify(json))
                    window.location.href = "http://localhost:9000/"
                  });
                
            }else{
                response.json().then(json => {
                    console.log(json);})
            }
        })



    //.then(window.location.href = "http://localhost:9000/");
}