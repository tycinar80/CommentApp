package com.tyc.commentapp.controller;

import com.tyc.commentapp.repository.entity.Product;
import com.tyc.commentapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/save")
    public ResponseEntity<Product> save(String name, double price, String expirationDate) {
        Product product = Product.builder()
                .name(name)
                .price(price)
                .expirationDate(LocalDate.parse(expirationDate))
                .build();
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }
}
