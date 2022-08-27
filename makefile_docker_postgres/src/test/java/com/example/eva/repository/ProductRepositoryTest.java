package com.example.eva.repository;

import com.example.eva.EvaApplication;
import com.example.eva.model.ProductEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Before
    public void setup() {
        productRepository.saveAll(getProductEntityList());
    }

    @Test
    public void repository_Test() {
        List<ProductEntity> productEntityListFromRepo = productRepository.findAll();
        List<ProductEntity> productEntityList = getProductEntityList();
        assertEquals(productEntityListFromRepo, productEntityList);
    }

    public static List<ProductEntity> getProductEntityList() {
        return List.of(
                new ProductEntity(1, "a1890", "desc"),
                new ProductEntity(2, "b28908", "desc"),
                new ProductEntity(3, "c3789", "desc"),
                new ProductEntity(4, "g4zzzz", "desc"),
                new ProductEntity(5, "asdf", "desc")
        );
    }
}