package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.strategies.SystemOutFizzBuzzOutputStrategy;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.factories.FizzBuzzOutputStrategyFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.strategies.FizzBuzzOutputStrategy;

/**
 * Factory for SystemOutFizzBuzzOutputStrategy
 */
@Service
public class SystemOutFizzBuzzOutputStrategyFactory implements FizzBuzzOutputStrategyFactory {

    private final SystemOutFizzBuzzOutputStrategy systemOutFizzBuzzOutputStrategy;

    /**
     * @param systemOutFizzBuzzOutputStrategy SystemOutFizzBuzzOutputStrategy
     */
    @Autowired
    public SystemOutFizzBuzzOutputStrategyFactory(final SystemOutFizzBuzzOutputStrategy systemOutFizzBuzzOutputStrategy) {
        super();
        this.systemOutFizzBuzzOutputStrategy = systemOutFizzBuzzOutputStrategy;
    }

    /**
     * @return FizzBuzzOutputStrategy
     */
    @Override
    public FizzBuzzOutputStrategy createOutputStrategy() {
        return this.systemOutFizzBuzzOutputStrategy;
    }
}
