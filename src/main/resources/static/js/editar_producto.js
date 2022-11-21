let url_base = "http://localhost:8080"

 function darBaja(id){

    if(confirm("¿Esta seguro que desea dar de baja este producto?")){

    fetch(url_base+'/producto/admin/darBaja/'+id, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },

    })
        .then(function (response) {
            console.log(response.status)
            if (response.status == 200) {
                    alert("El producto se ha dado de baja");
                    window.location.href= url_base+"/admin"

            }else{
                alert("Se ha producido un error, intente nuevamente")
            }
        })
}
 }

 class DTOUpdateProducto{
    id;
    nombre;
    precio;
    stock;
    categoria;
    imagen;

    constructor(id,nombre,precio,stock,categoria,imagen){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.imagen = imagen;
    }
 }

 function actualizar(id){
    let nombre = document.getElementById('name');
    let precio = document.getElementById('productPrice');
    let stock = document.getElementById('stock');
    let categoria = document.getElementById('categoria');


    fetch(url_base+'/producto/admin/actualizar', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(new DTOUpdateProducto(id,nombre.value,precio.value,stock.value,categoria.value))

    })
        .then(function (response) {
            console.log(response.status)
            if (response.status == 200) {
                    alert("El producto se ha actualizado correctamente");
                    window.location.href=url_base+"admin/producto/editar/"+id

            }else{
                alert("Se ha producido un error, intente nuevamente")
            }
        })
    
 }