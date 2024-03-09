package com.test.javacourse.odev3.controller;

import com.test.javacourse.odev3.dto.ProductInfoResponseDto;
import com.test.javacourse.odev3.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/getProductByCategoryct")
    public List<ProductInfoResponseDto> getProductByCategory(@RequestParam String category) {
        return productService.getProductByCategory(category);
    }

}
