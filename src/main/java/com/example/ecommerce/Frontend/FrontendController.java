package com.example.ecommerce.Frontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.Categoria.Categoria;
import com.example.ecommerce.Categoria.CategoriaServiceImpl;
import com.example.ecommerce.Frontend.DTO.DTOProductoUI;
import com.example.ecommerce.ImageStorage.IndireccionImageStorage;
import com.example.ecommerce.Producto.Producto;
import com.example.ecommerce.Producto.ProductoServiceImpl;
import com.example.ecommerce.Producto.DTO.DTOCreateProducto;

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
            List<Categoria> categorias = categoriaService.findAll();

            model.addAttribute("productos", productos);
            model.addAttribute("categorias", categorias);

            return "index";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/productos/{id}")
    public String getOne(Model model, @PathVariable Long id) {
        try {
            DTOProductoUI dto = service.buildProductData(id);

            model.addAttribute("data", dto);

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

    @PostMapping("/nuevo")
    public String saveProd(
            Model model,
            @RequestParam("archivo") MultipartFile archivo,
            @ModelAttribute("producto") DTOCreateProducto producto) {
        try {

            System.out.println(producto);
            System.out.println("************************************");
            System.out.println("************************************");
            System.out.println("************************************");
            System.out.println("************************************");
            System.out.println(producto.toString());
            System.out.println("************************************");
            System.out.println("************************************");
            System.out.println("************************************");
            System.out.println(new IndireccionImageStorage().uploadImage(archivo));
            System.out.println("************************************");
            System.out.println("************************************");
            System.out.println("************************************");

            List<Categoria> categorias = categoriaService.findAll();

            model.addAttribute("categorias", categorias);
            model.addAttribute("producto", new DTOCreateProducto());

            return "nuevo";
        } catch (Exception e) {
            return "error";
        }
    }
}