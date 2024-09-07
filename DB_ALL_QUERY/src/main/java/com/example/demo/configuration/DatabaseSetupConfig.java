package com.example.demo.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@Configuration
public class DatabaseSetupConfig {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @EventListener(ApplicationReadyEvent.class)
    public void initializeDatabase() {
        jdbcTemplate.execute("ALTER TABLE user_role DROP CONSTRAINT fk_user");
        jdbcTemplate.execute("ALTER TABLE user_role DROP CONSTRAINT fk_role");

        jdbcTemplate.execute("ALTER TABLE user_role ADD CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE");
        jdbcTemplate.execute("ALTER TABLE user_role ADD CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE");


        jdbcTemplate.execute("ALTER TABLE line_first_user DROP CONSTRAINT fk_line_first_user_id");
        jdbcTemplate.execute("ALTER TABLE line_first_user DROP CONSTRAINT fk_first_line_id_user");

        jdbcTemplate.execute("ALTER TABLE line_first_user ADD CONSTRAINT fk_line_first_user_id FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE");
        jdbcTemplate.execute("ALTER TABLE line_first_user ADD CONSTRAINT fk_first_line_id_user FOREIGN KEY (line_id) REFERENCES line_first(id) ON DELETE CASCADE");
    }
}
