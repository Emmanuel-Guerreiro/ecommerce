package com.example.ecommerce.Carrito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Base.BaseControllerImpl;
import com.example.ecommerce.Producto.ProductoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/carrito")
public class CarritoControllerImpl extends BaseControllerImpl<Carrito, Long, CarritoServiceImpl> implements
        CarritoController {

    @Autowired
    public CarritoControllerImpl(CarritoServiceImpl service, ProductoService productoService) {
        super(service);

    }

    // TODO: The params should be a DTO
    @PostMapping("/{id}/item")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public DetalleCarrito addItem(@PathVariable Long idCarrito,
            @RequestParam Long item,
            @RequestParam int cantidad) throws Exception {

        return this.service.addItem(idCarrito, item, cantidad);
    };

}
