package com.example.ecommerce.Frontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ecommerce.Producto.Producto;
import com.example.ecommerce.Producto.ProductoServiceImpl;

@org.springframework.stereotype.Controller
public class Controller {

    ProductoServiceImpl productoService;

    @Autowired
    public Controller(ProductoServiceImpl productoService) {
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
