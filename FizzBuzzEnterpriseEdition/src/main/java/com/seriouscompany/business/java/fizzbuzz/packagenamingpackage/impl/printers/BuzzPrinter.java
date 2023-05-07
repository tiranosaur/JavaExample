package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.printers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories.SystemOutFizzBuzzOutputStrategyFactory;

/**
 * Printer for Buzz
 */
@Service
public class BuzzPrinter {

    private final SystemOutFizzBuzzOutputStrategyFactory systemOutFizzBuzzOutputStrategyFactory;

    /**
     * @param systemOutFizzBuzzOutputStrategyFactory
     */
    @Autowired
    public BuzzPrinter(final SystemOutFizzBuzzOutputStrategyFactory systemOutFizzBuzzOutputStrategyFactory) {
        super();
        this.systemOutFizzBuzzOutputStrategyFactory = systemOutFizzBuzzOutputStrategyFactory;
    }

}
