package org.example.transact.listener;

import lombok.extern.slf4j.Slf4j;
import org.example.transact.model.Author;
import org.example.transact.repository.AuthorRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class GlobalListener {
    public static final String name = "xxx";

    @Autowired
    private AuthorRepositoryImpl authorRepository;

    @EventListener(value = ApplicationReadyEvent.class)
    public void listen() {
        Author author1 = new Author(null, name + 1, "main" + 1);
        Author author2 = new Author(null, name, "main" + 2);

        log.info("    Authors.count - [{}]", authorRepository.count());

        try {
            authorRepository.save(author1);
            log.info(" +++++ result - [{}]", authorRepository.count());
            authorRepository.save(author2);
            log.info(" +++++ result - [{}]", authorRepository.count());
        } catch (Exception e) {
            log.info(" ----- result - [{}]", authorRepository.count());
        }

        authorRepository.findFirst()
                .ifPresent(x -> authorRepository.delete(x.getId()));
    }
}
