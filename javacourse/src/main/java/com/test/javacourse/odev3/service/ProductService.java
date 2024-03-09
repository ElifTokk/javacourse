package com.test.javacourse.odev3.service;

import com.test.javacourse.odev3.dto.ProductInfoResponseDto;
import com.test.javacourse.odev3.repository.ProductMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final JdbcTemplate jdbcTemplate;

    public ProductService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<ProductInfoResponseDto> getProductByCategory(String categoryName) {

        List<ProductInfoResponseDto> productList = jdbcTemplate.query("select * from PRODUCTTB pt where pt.category = ? ", new Object[]{categoryName}, new ProductMapper());
        return productList;
    }
}
