package com.example.demoorm.controller;

import com.example.demoorm.model.Product;
import com.example.demoorm.service.Crud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
@Autowired
    private Crud<Product> productService;
    @GetMapping
    public String displayAllProduct(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "listProduct";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Product p = new Product();
        model.addAttribute("productForm", p);
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("product") Product product) {
        productService.create(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/update")
    public String update(Model model, @PathVariable("id") int id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product) {
        productService.update(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        productService.delete(id);
        return "redirect:/products";
    }
}
