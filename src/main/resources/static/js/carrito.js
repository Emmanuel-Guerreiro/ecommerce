

 function eliminarItem(id){

    if(confirm("¿Esta seguro que desea eliminar este item?")){

    fetch('http://localhost:8080/api/v1/carrito/detalle/eliminar/'+id, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },

    })
        .then(function (response) {
            console.log(response.status)
            if (response.status == 200) {

                    window.location.reload()

            }else{
                alert("Se ha producido un error, intente nuevamente")
            }
        })
}
 }