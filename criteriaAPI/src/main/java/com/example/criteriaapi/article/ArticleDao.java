package com.example.criteriaapi.article;

import java.util.List;

public interface ArticleDao {
    Article customFindMethod(long id);
    Article customFindMethod2(long id);
    List<Article> likeExample(String str) ;
}
