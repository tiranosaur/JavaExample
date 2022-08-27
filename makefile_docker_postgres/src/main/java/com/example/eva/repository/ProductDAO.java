package com.example.eva.repository;

import com.example.eva.exception.RegexErrorException;
import com.example.eva.model.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
public class ProductDAO {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public List<ProductEntity> getProductListByFilter(String nameFilter, String regexString, Integer maxResponseList, Integer minRegexSize) throws RegexErrorException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductEntity> cq = cb.createQuery(ProductEntity.class);
        Root<ProductEntity> root = cq.from(ProductEntity.class);

        List<Predicate> predicates = getPredicateListFromNameFilter(nameFilter, regexString, minRegexSize, cb, root);
        Predicate finalPredicate = cb.and(predicates.toArray(new Predicate[0]));
        cq.where(finalPredicate);

        return entityManager.createQuery(cq).getResultList();
    }

    protected List<Predicate> getPredicateListFromNameFilter(String nameFilter, String regexString, Integer minRegexSize, CriteriaBuilder cb, Root<ProductEntity> root) throws RegexErrorException {
        //early exit
        if (nameFilter.equals("^.*.*$")) {
            throw new RegexErrorException("pattern is empty. Too big data");
        }

        Pattern pattern = Pattern.compile(regexString);
        Matcher matcher = pattern.matcher(nameFilter);
        List<Predicate> predicateList = new ArrayList<>();
        while (matcher.find()) {
            String begin = matcher.group(2);
            String middle = matcher.group(3);
            String end = matcher.group(4);

            //begin
            if (begin != null && begin.length() >= minRegexSize) {
                predicateList.add(cb.notLike(root.get("name"), begin + "%"));
            }

            //middle
            if (middle != null && middle.length() >= minRegexSize) {
                char[] chars = nameFilter.replaceAll(".*(\\[)(.*)(\\]).*", "$2").toCharArray();
                for (char ch : chars) {
                    predicateList.add(cb.notLike(root.get("name"), "%" + ch + "%"));
                }
            }

            //end
            if (end != null && end.length() >=minRegexSize) {
                predicateList.add(cb.notLike(root.get("name"), "%" + end));
            }
        }

        if (predicateList.isEmpty()) {
            throw new RegexErrorException("patter is incorrect");
        }
        return predicateList;
    }
}
