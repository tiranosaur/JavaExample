package org.example.transact.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.transact.listener.GlobalListener;
import org.example.transact.model.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class AuthorRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Author author) {
        author.setId(null);
        entityManager.persist(author);
        if (author.getName().equals(GlobalListener.name)) {
            throw new RuntimeException();
        }
    }

    public void saveNative(Author author) {
        author.setId(null);
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
        if (author.getName().equals(GlobalListener.name)) {
            throw new RuntimeException();
        }
    }



    @Transactional
    public void delete(Long id) {
        entityManager.remove(entityManager.find(Author.class, id));
    }

    public long count() {
        return entityManager.createQuery("SELECT COUNT(*) FROM Author", Long.class).getSingleResult();
    }

    public Optional<Author> findFirst() {
        return entityManager.createQuery("SELECT e FROM Author e", Author.class)
                .setMaxResults(1)
                .getResultList()
                .stream()
                .findFirst();
    }
}
