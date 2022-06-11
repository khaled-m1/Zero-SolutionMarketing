package com.example.zeroproject11.controller;

import com.example.zeroproject11.dto.ApiResponce;
import com.example.zeroproject11.model.Product;
import com.example.zeroproject11.service.ProductService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final Logger log = LoggerFactory.getLogger(ProductController.class);
    // get all users
    @GetMapping("/get-product")
    public List<Product> getProduct(){
        log.info("get All Product");
        return productService.getProduct();
    }
    // post product
    @PostMapping("/add-product")
    public ResponseEntity addProduct(@RequestBody @Valid Product product){
        productService.addProduct(product);
        log.info("add New product");
        return ResponseEntity.status(201).body(new ApiResponce("Accept request :)",201));
    }
    // edit users
    @PutMapping("/edit-product/{id}")
    public ResponseEntity editProduct(@PathVariable Long id,
                                    @RequestBody Product product){
        productService.editProduct(id,product);
        log.info("edit New product");
        return ResponseEntity.status(201).body(new ApiResponce("Accept request :)",201));
    }
    // remove product
    @DeleteMapping("/remove-product/{index}")
    public ResponseEntity removeProduct(@PathVariable Long index){
        log.info("delete request ");
        productService.removeProduct(index);
        return ResponseEntity.status(200).body("product removed :)");
    }
}
