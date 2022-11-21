
const domain = 'http://localhost:8080'
class LoginRequest {
    username;
    password;

    constructor(username, password) {
        this.username = username;
        this.password = password;
    }
}

document.getElementById('btnSubmit').addEventListener('click',loginUsuario)

function loginUsuario(e) {
    e.preventDefault();
    let usuario = document.getElementById("exampleInputEmail1");
    let pass = document.getElementById("exampleInputPassword1");
    let user = new LoginRequest(usuario.value, pass.value);
    console.log(user.password + " " + user.username);

    fetch(domain+'/api/auth/signin', {
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
                    if(verificarRolAdmin(JSON.parse(JSON.stringify(json)).roles)){
                        window.location.href= domain+"/admin"
                    }else{
                    window.location.href = domain;
                    }
                    document.cookie = "autenticacion="+JSON.parse(sessionStorage.getItem('JwtResponse')).accessToken; + "Path=/; Expires=Sat, 18 Nov 2023 02:25:43 GMT;"
                  });
            }else{
                response.json().then(json => {
                    console.log(json);})
            }
        })



    //.then(window.location.href = "http://localhost:9000/"); 
}

function verificarRolAdmin(roles){
     for(var i=0;i<roles.length;i++){
        if(roles[i] == "ROLE_ADMIN"){
           return true;
        }
     }
     return false;
    }
