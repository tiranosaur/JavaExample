package com.example.eva.controller;

import com.example.eva.api.ShopApi;
import com.example.eva.exception.RegexErrorException;
import com.example.eva.exception.TooBigResponseData;
import com.example.eva.service.ProductService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
public class ProductController implements ShopApi {
    @Autowired
    private ProductService productService;


    @Override
    public ResponseEntity getProductListByFilter(String nameFilter) {
        try {
            return ResponseEntity.ok(productService.getProductListByFilter(nameFilter));
        } catch (RegexErrorException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        } catch (TooBigResponseData e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }
}