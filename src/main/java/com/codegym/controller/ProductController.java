package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ModelAndView showAllProducts(){
        List<Product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView("list","products",products);
        return modelAndView;
    }
    @GetMapping("/view/{id}")
    public ModelAndView findProductByID(@PathVariable Integer id){
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("detail","product",product);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createProduct(Product product){
        productService.create(product);
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit","product",product);
        return modelAndView;
    }
    @PostMapping("edit/{id}")
    public ModelAndView editProduct(Product product, @PathVariable Integer id){
        productService.update(id,product);
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        return modelAndView;
    }
    @GetMapping("delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id){
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("delete","product",product);
        return modelAndView;
    }
    @PostMapping("delete/{id}")
    public ModelAndView deleteProduct(@PathVariable Integer id){
        productService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        return modelAndView;
    }
}
