package com.example.eva.controller;

import com.example.eva.repository.ProductDAO;
import com.example.eva.repository.ProductRepository;
import com.example.eva.repository.ProductRepositoryTest;
import com.example.eva.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application.yml",
        properties = {
                "spring.datasource.driverClassName=org.h2.Driver",
                "spring.datasource.url=jdbc:h2:mem:db;DB_CLOSE_DELAY=-1;init=create schema if not exists postgres",
                "spring.datasource.username=sa",
                "spring.datasource.password=sa",
                "spring.jpa.hibernate.ddl-auto=create-drop",
                "spring.jpa.show-sql=true"
        })
@EnableTransactionManagement
@WebMvcTest
public class ProductControllerTest {
    @Autowired
    private MockMvc mvc;

    @SpyBean
    private ProductService productService;

    @MockBean
    private ProductDAO productDAO;

    @MockBean
    private ProductRepository productRepository;


    @Before
    public void setup() {
        productRepository.saveAll(ProductRepositoryTest.getProductEntityList());
    }

    @Test
    public void getProductListByFilter_NoNameFilter() throws Exception {
        mvc.perform(get("/shop/product")).andExpect(status().is4xxClientError());
    }

    @Test
    public void getProductListByFilter_Ok() throws Exception {
        mvc.perform(get("/shop/product").param("nameFilter", "aaa"))
                .andExpect(status().isOk());
    }

    @Test
    public void getProductListByFilter_WithParams() throws Exception {
        when(productService.getProductListByFilter(any())).thenReturn(List.of());
        mvc.perform(get("/shop/product").param("nameFilter", "aaa"))
                .andExpect(status().isOk());
    }
}