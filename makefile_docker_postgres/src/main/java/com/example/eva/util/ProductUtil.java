package com.example.eva.util;

import com.example.eva.model.ProductEntity;
import model.ProductDTO;

public class ProductUtil {
    public static ProductDTO map(ProductEntity productEntity) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productEntity.getId());
        productDTO.setName(productEntity.getName());
        productDTO.setDescription(productEntity.getDescription());
        return productDTO;
    }
}
