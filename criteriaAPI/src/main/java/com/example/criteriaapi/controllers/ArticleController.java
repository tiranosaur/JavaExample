package com.example.criteriaapi.controllers;

import com.example.criteriaapi.article.ArticleDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleDaoImpl articleDao;

    @GetMapping(value = { "index1"})
    @ResponseBody()
    public Object index1(){
        return articleDao.customFindMethod(777);
    }

    @GetMapping(value = { "index2"})
    @ResponseBody()
    public Object index2(){
        return articleDao.customFindMethod2(7777);
    }

    @GetMapping(value = { "index3"})
    @ResponseBody()
    public Object index3(){
        return articleDao.likeExample("aaa");
    }
}
