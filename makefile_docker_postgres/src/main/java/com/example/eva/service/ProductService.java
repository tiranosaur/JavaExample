package com.example.eva.service;

import com.example.eva.exception.RegexErrorException;
import com.example.eva.exception.TooBigResponseData;
import com.example.eva.model.ProductEntity;
import com.example.eva.repository.ProductDAO;
import com.example.eva.util.ProductUtil;
import lombok.extern.slf4j.Slf4j;
import model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {
    @Value("${eva.regex}")
    private String regexString;

    @Value("${eva.minRegexSize:3}")
    private Integer minRegexSize;

    @Value("${eva.maxResponseList:100}")
    private Integer maxResponseList;

    @Autowired
    ProductDAO productDAO;

    public List<ProductDTO> getProductListByFilter(String nameFilter) throws RegexErrorException, TooBigResponseData {
        log.info("ProductService.getProductListByFilter try to get ProductDTOList by nameFilter - [{}]", nameFilter);
        List<ProductEntity> productEntityList = productDAO.getProductListByFilter(nameFilter, regexString, maxResponseList, minRegexSize);
        if (productEntityList.size() > maxResponseList) {
            log.info("Response data is too big");
            throw new TooBigResponseData("Response data is too big");
        }
        return productEntityList.parallelStream().map(ProductUtil::map).collect(Collectors.toList());
    }
}
