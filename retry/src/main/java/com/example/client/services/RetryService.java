package com.example.client.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
/*
    Все методы должны иметь одинаковую сигнатуру.
    maxAttempts - кол-во повторов
    delay - время в мс
    multiplier - множитель (время повтора = delay*multiplier)
 */
public class RetryService {
    private static int counter = 0;

    @Retryable(include = {Exception.class}, maxAttempts = 50, backoff = @Backoff(delay = 10, multiplier = 1))
    public void retry(boolean isSuccessful) throws Exception {
        if (counter == 45 && isSuccessful) return;

        log.info("run retry. counter = {}", counter++);
        throw new Exception();
    }

    @Recover
    public void recover(Exception e) throws Exception {
        log.error("error message is" + e.getMessage());
        log.info("recover....");
    }
}
