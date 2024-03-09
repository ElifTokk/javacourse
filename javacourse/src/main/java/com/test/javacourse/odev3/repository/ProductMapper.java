package com.test.javacourse.odev3.repository;

import com.test.javacourse.odev3.dto.ProductInfoResponseDto;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<ProductInfoResponseDto> {

    @Override
    public ProductInfoResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductInfoResponseDto productInfoResponseDto = new ProductInfoResponseDto();

        productInfoResponseDto.setId(rs.getInt("ID"));
        productInfoResponseDto.setName(rs.getString("NAME"));
        productInfoResponseDto.setCategory(rs.getString("CATEGORY"));
        productInfoResponseDto.setPhotoUrl(rs.getString("PHOTOURL"));
        productInfoResponseDto.setDescription(rs.getString("DESCRIPTION"));
        productInfoResponseDto.setPrice(rs.getDouble("PRICE"));


        return productInfoResponseDto;
    }
}
