package com.example.criteriaapi.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleDaoImpl implements ArticleDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Article customFindMethod(long id) {
        return this.entityManager.find(Article.class, id);
    }

    @Override
    public Article customFindMethod2(long id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Article> criteriaQuery = criteriaBuilder.createQuery(Article.class);
        Root<Article> root = criteriaQuery.from(Article.class);

        Predicate predicateId = criteriaBuilder.equal(root.get("id"), id);
        criteriaQuery.where(predicateId);
        Article result = entityManager.createQuery(criteriaQuery).getSingleResult();
        return result;
    }

    @Override
    public List<Article> likeExample(String likeString) {
        if (likeString == null) {
            return null;
        }
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Article> criteriaQuery = criteriaBuilder.createQuery(Article.class);
        Root<Article> root = criteriaQuery.from(Article.class);


        Predicate predicateLike = criteriaBuilder.like(root.get("name"),"%"+likeString+"%");
        criteriaQuery.where(predicateLike);
        List<Article> result = entityManager.createQuery(criteriaQuery).getResultList();

        return result;
    }
}
