package com.example.eva.service;


import com.example.eva.EvaApplication;
import com.example.eva.exception.RegexErrorException;
import com.example.eva.exception.TooBigResponseData;
import com.example.eva.model.ProductEntity;
import com.example.eva.repository.ProductRepository;
import com.example.eva.repository.ProductRepositoryTest;
import com.example.eva.util.ProductUtil;
import model.ProductDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EvaApplication.class)
@TestPropertySource(locations = "classpath:application.yml",
        properties = {
                "spring.datasource.driverClassName=org.h2.Driver",
                "spring.datasource.url=jdbc:h2:mem:db;DB_CLOSE_DELAY=-1;init=create schema if not exists postgres",
                "spring.datasource.username=sa",
                "spring.datasource.password=sa",
                "spring.jpa.hibernate.ddl-auto=create-drop",
                "spring.jpa.show-sql=true"
        })
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Before
    public void setup() {
        productRepository.saveAll(ProductRepositoryTest.getProductEntityList());
    }

    @Test
    public void repository_Test() {
        List<ProductEntity> productEntityListFromRepo = productRepository.findAll();
        List<ProductEntity> productEntityList = ProductRepositoryTest.getProductEntityList();
        assertEquals(productEntityListFromRepo, productEntityList);
    }

    @Test
    public void getProductListByFilter_Test() throws RegexErrorException, TooBigResponseData {
        ProductDTO productDTO2 = ProductUtil.map(ProductRepositoryTest.getProductEntityList().get(1));
        ProductDTO productDTO3 = ProductUtil.map(ProductRepositoryTest.getProductEntityList().get(2));
        ProductDTO productDTO4 = ProductUtil.map(ProductRepositoryTest.getProductEntityList().get(3));

        List<ProductDTO> expected = new ArrayList<>(List.of(productDTO2, productDTO3, productDTO4));
        List<ProductDTO> actual = productService.getProductListByFilter("^0[asdf]0$");
        assertEquals(expected, actual);
    }

    @Test
    public void getProductListByFilter_begin_Test() throws RegexErrorException, TooBigResponseData {
        ProductDTO productDTO1 = ProductUtil.map(ProductRepositoryTest.getProductEntityList().get(0));
        ProductDTO productDTO2 = ProductUtil.map(ProductRepositoryTest.getProductEntityList().get(1));
        ProductDTO productDTO3 = ProductUtil.map(ProductRepositoryTest.getProductEntityList().get(2));
        ProductDTO productDTO4 = ProductUtil.map(ProductRepositoryTest.getProductEntityList().get(3));

        List<ProductDTO> expected = new ArrayList<>(List.of(productDTO1, productDTO2, productDTO3, productDTO4));
        List<ProductDTO> actual = productService.getProductListByFilter("^asdf.*$");
        assertEquals(expected, actual);
    }

    @Test
    public void getProductListByFilter_middle_Test() throws RegexErrorException, TooBigResponseData {
        ProductDTO productDTO = ProductUtil.map(ProductRepositoryTest.getProductEntityList().get(4));
        List<ProductDTO> expected = new ArrayList<>(List.of(productDTO));
        List<ProductDTO> actual = productService.getProductListByFilter("^.*[12346].*$");
        assertEquals(expected, actual);
    }

    @Test
    public void getProductListByFilter_end_Test() throws RegexErrorException, TooBigResponseData {
        ProductDTO productDTO1 = ProductUtil.map(ProductRepositoryTest.getProductEntityList().get(0));
        ProductDTO productDTO2 = ProductUtil.map(ProductRepositoryTest.getProductEntityList().get(1));
        ProductDTO productDTO3 = ProductUtil.map(ProductRepositoryTest.getProductEntityList().get(2));
        ProductDTO productDTO4 = ProductUtil.map(ProductRepositoryTest.getProductEntityList().get(3));

        List<ProductDTO> expected = new ArrayList<>(List.of(productDTO1, productDTO2, productDTO3, productDTO4));
        List<ProductDTO> actual = productService.getProductListByFilter("^.*asdf$");
        assertEquals(expected, actual);
    }
}