package com.example.eva.util;

import com.example.eva.model.ProductEntity;
import model.ProductDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ProductUtilTest {

    @Test
    public void map_Test() {
        ProductEntity productEntity = new ProductEntity(1, "product name", "description");

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1);
        productDTO.setName("product name");
        productDTO.setDescription("description");

        assertEquals(productDTO, ProductUtil.map(productEntity));
    }

    @Test
    public void map_wrong_Test() {
        ProductEntity productEntity = new ProductEntity(11, "product name", "description");

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1);
        productDTO.setName("product name");
        productDTO.setDescription("description");

        assertNotEquals(productDTO, ProductUtil.map(productEntity));
    }
}