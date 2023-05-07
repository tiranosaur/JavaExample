package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.printers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories.SystemOutFizzBuzzOutputStrategyFactory;

/**
 * Printer for Integers
 */
@Service
public class IntegerPrinter {

    private final SystemOutFizzBuzzOutputStrategyFactory systemOutFizzBuzzOutputStrategyFactory;

    /**
     * @param systemOutFizzBuzzOutputStrategyFactory
     */
    @Autowired
    public IntegerPrinter(final SystemOutFizzBuzzOutputStrategyFactory systemOutFizzBuzzOutputStrategyFactory) {
        super();
        this.systemOutFizzBuzzOutputStrategyFactory = systemOutFizzBuzzOutputStrategyFactory;
    }

}
