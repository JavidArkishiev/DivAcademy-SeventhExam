package com.example.newtasks.controller;

import com.example.newtasks.model.Product;
import com.example.newtasks.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id,@RequestBody Product product){
       Product updateProduct= productService.updateProducts(id, product);
       if (updateProduct==null){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
        return new ResponseEntity<>(productService.updateProducts(id,product),HttpStatus.OK);
    }

}
