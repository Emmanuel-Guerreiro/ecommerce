package com.bezkoder.springjwt.Frontend;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bezkoder.springjwt.Categoria.Categoria;
import com.bezkoder.springjwt.Categoria.CategoriaServiceImpl;
import com.bezkoder.springjwt.Factura.DetalleFactura;
import com.bezkoder.springjwt.Factura.Factura;
import com.bezkoder.springjwt.Factura.FacturaServiceImpl;
import com.bezkoder.springjwt.Frontend.DTO.DTOCarritoUI;
import com.bezkoder.springjwt.Frontend.DTO.DTOFactura;
import com.bezkoder.springjwt.Frontend.DTO.DTOProductoUI;
import com.bezkoder.springjwt.Producto.Producto;
import com.bezkoder.springjwt.Producto.ProductoServiceImpl;
import com.bezkoder.springjwt.Producto.DTO.DTOCreateProducto;
import org.springframework.web.bind.annotation.CookieValue;

@Controller
public class FrontendController {

    CategoriaServiceImpl categoriaService;
    ProductoServiceImpl productoService;
    FrontendService service;

    @Autowired
    public FrontendController(
            FrontendService service,
            ProductoServiceImpl productoService,
            CategoriaServiceImpl categoriaService) {
        this.service = service;
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/")
    public String index(Model model,
            @RequestParam(name = "categoria", required = false) Long categoria) {
        try {
            List<Producto> productos = productoService.findAllByCategory(categoria);
            List<Categoria> c = categoriaService.findAll();
            List<Categoria> categorias = c.stream().limit(5).collect(Collectors.toList());

            model.addAttribute("productos", productos);
            model.addAttribute("categorias", categorias);

            return "index";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/productos")
    public String getProductos(Model model,
            @RequestParam(name = "categoria", required = false) Long categoria,
            @RequestParam(name = "nombre", required = false) String nombre) {
        try {

            List<Producto> productos = productoService.findWithFilters(nombre, categoria);
            List<Categoria> c = categoriaService.findAll();
            List<Categoria> categorias = c.stream().limit(5).collect(Collectors.toList());

            model.addAttribute("productos", productos);
            model.addAttribute("categorias", categorias);
            return "productos";
        } catch (Exception e) {
            return "error";
        }
    }
    
    @GetMapping("/productos/sin_stock")
    public String getAllBySinStock(Model model) {
        try {
            List<Producto> productos = this.productoService.findAllBySinStock();
            model.addAttribute("productos", productos);
       
            return "productos";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/productos/{id}")
    public String getOne(Model model, @PathVariable Long id) {
        try {
            DTOProductoUI dto = service.buildProductData(id);
            model.addAttribute("data", dto);

            // Agrego categorias
            List<Categoria> c = categoriaService.findAll();
            List<Categoria> categorias = c.stream().limit(5).collect(Collectors.toList());

            model.addAttribute("categorias", categorias);

            return "producto";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/login")
    public String login(Model model) {
        try {
            return "login";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/registro")
    public String register(Model model) {
        try {
            return "registro";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/carrito/{id}")
    public String carrito(Model model, @PathVariable Long id,@CookieValue(name = "autenticacion")String token) { //CookieValue
        
        if(service.isAccessibleResourseForUser(id, token)){
        try {
            DTOCarritoUI dto = service.buildCarritoData(id);
            model.addAttribute("data", dto);
            model.addAttribute("items", dto.getDetalles());

            return "carrito";
            
        } catch (Exception e) {
            return "error";
        }
        }
        return "error";
    }

    @GetMapping("/compra/{id}")
    public String carrito(Model model, @PathVariable long id) {
        try {

            return "compra";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/nuevo")
    public String newProd(Model model) {
        try {
            List<Categoria> categorias = categoriaService.findAll();

            model.addAttribute("categorias", categorias);
            model.addAttribute("producto", new DTOCreateProducto());

            return "nuevo";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/compras/{id}")
    public String mostrarFacturas(Model model,@PathVariable("id") Long idUser) {
        try {
            List<DTOFactura> facturas = this.service.buildListDtoFactura(idUser);
            model.addAttribute("facturas", facturas);
            return "misCompras";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/factura/{id}")
    public String mostrarFactura(Model model,@PathVariable("id") Long idFactura) {
        try {
           DTOFactura dtoFactura = this.service.buildDtoFactura(idFactura);
           model.addAttribute("factura", dtoFactura);
           model.addAttribute("items", dtoFactura.getDetalles());
            return "factura";
        } catch (Exception e) {
            return "error";
        }
    }

    @PostMapping("/nuevo")
    public String saveProd(
            Model model,
            @ModelAttribute("producto") DTOCreateProducto producto) {
        try {

            System.out.println(producto.getImagen().getOriginalFilename());
            Producto nuevo = productoService.save(producto);

            List<Categoria> categorias = categoriaService.findAll();

            model.addAttribute("categorias", categorias);
            model.addAttribute("producto", new DTOCreateProducto());
            model.addAttribute("creado", nuevo);

            return "nuevo";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/admin")
    public String vistaDeAdministrador(Model model,
            @RequestParam(name = "categoria", required = false) Long categoria) {
        try {
            List<Producto> productos = productoService.findAllByCategory(categoria);
            List<Categoria> c = categoriaService.findAll();
            List<Categoria> categorias = c.stream().limit(5).collect(Collectors.toList());

            model.addAttribute("productos", productos);
            model.addAttribute("categorias", categorias);
            return "vista-admin";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/admin/producto/editar/{id}")
    public String editarProducto(Model model,@PathVariable Long id) {
        try {
            List<Categoria> categorias = categoriaService.findAll();
            Producto p = productoService.findById(id);
            model.addAttribute("categorias", categorias);
            model.addAttribute("producto", p);
            
            return "edicion_producto";
        } catch (Exception e) {
            return "error";
        }
    }

}
