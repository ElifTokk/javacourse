package com.test.javacourse.MarketPlace.controller;

import com.test.javacourse.MarketPlace.dto.ProductSaveRequestDto;
import com.test.javacourse.MarketPlace.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

/*
    @GetMapping("/getProductByCategoryct")
    public List<ProductInfoResponseDto> getProductByCategory(@RequestParam String category) {
       // return productService.getProductByCategory(category);
        return new ArrayList<ProductInfoResponseDto>();
    } */

    @PostMapping("/saveProduct")
    public void saveProduct(@RequestBody ProductSaveRequestDto productSaveRequestDto) {

        productService.save(productSaveRequestDto);
    }


}
