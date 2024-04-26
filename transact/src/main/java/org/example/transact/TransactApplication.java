package org.example.transact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TransactApplication {
	public static void main(String[] args) {
		SpringApplication.run(TransactApplication.class, args);
	}
}
