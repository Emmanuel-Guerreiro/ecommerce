class LoginRequest {
    username;
    password;

    constructor(username, password) {
        this.username = username;
        this.password = password;
    }
}


function loginUsuario() {

    let usuario = document.getElementById("exampleInputEmail1");
    let pass = document.getElementById("exampleInputPassword1");
    let user = new LoginRequest(usuario.value, pass.value);
    console.log(user.password + " " + user.username);

    fetch('http://localhost:8080/api/auth/signin', {
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
                    sessionStorage.setItem('JwtResponse', JSON.stringify(json))
                    window.location.href = "http://localhost:8080/"
                    document.cookie = "autenticacion="+JSON.parse(sessionStorage.getItem('JwtResponse')).accessToken; + "Path=/; Expires=Sat, 18 Nov 2023 02:25:43 GMT;"
                  });
                
            }else{
                response.json().then(json => {
                    console.log(json);})
            }
        })



    //.then(window.location.href = "http://localhost:9000/"); 
}