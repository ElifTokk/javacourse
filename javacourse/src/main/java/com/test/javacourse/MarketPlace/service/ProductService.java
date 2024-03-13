package com.test.javacourse.MarketPlace.service;

import com.test.javacourse.MarketPlace.dto.ProductSaveRequestDto;
import com.test.javacourse.MarketPlace.entity.Product;
import com.test.javacourse.MarketPlace.repository.ProductRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final JdbcTemplate jdbcTemplate;

    private final ProductRepository productRepository;

    public ProductService(JdbcTemplate jdbcTemplate, ProductRepository productRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.productRepository = productRepository;
    }


    public void getProductByCategory(String categoryName) {

        // List<ProductInfoResponseDto> productList = jdbcTemplate.query("select * from PRODUCT pt where pt.category = ? ", new Object[]{categoryName}, new ProductMapper());
        // return productList;
    }


    public void save(ProductSaveRequestDto productSaveRequestDto) {
        Product product = new Product();
        product.setName(productSaveRequestDto.getName());
        product.setCategory(productSaveRequestDto.getCategory());
        product.setPrice(productSaveRequestDto.getPrice());
        product.setDescription(productSaveRequestDto.getDescription());
        product.setPhotoUrl(productSaveRequestDto.getPhotoUrl());

        productRepository.saveProduct(product);


        if(product.getId()>0){
            System.out.println("İşleminiz Gerçekleşmiştir.");
        }else {
            System.out.println("İşlem Başarısız.");
        }

    }
}
