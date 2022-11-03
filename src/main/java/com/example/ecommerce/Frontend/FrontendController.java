package com.example.ecommerce.Frontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.ecommerce.Frontend.DTO.DTOProductoUI;
import com.example.ecommerce.Producto.Producto;
import com.example.ecommerce.Producto.ProductoServiceImpl;

@Controller
public class FrontendController {

    ProductoServiceImpl productoService;
    FrontendService service;

    @Autowired
    public FrontendController(FrontendService service, ProductoServiceImpl productoService) {
        this.service = service;
        this.productoService = productoService;
    }

    @GetMapping("/")
    public String index(Model model) {
        try {
            List<Producto> productos = productoService.findAll();
            model.addAttribute("productos", productos);

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
            model.addAttribute("nombre", dto.getNombre());
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
}
