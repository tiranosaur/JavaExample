package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.strategies.FizzStrategy;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.factories.IsEvenlyDivisibleStrategyFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.strategies.IsEvenlyDivisibleStrategy;

/**
 * Factory for FizzStrategy
 */
@Service
public class FizzStrategyFactory implements IsEvenlyDivisibleStrategyFactory {

    private final FizzStrategy fizzStrategy;

    /**
     * @param fizzStrategy FizzStrategy
     */
    @Autowired
    public FizzStrategyFactory(final FizzStrategy fizzStrategy) {
        super();
        this.fizzStrategy = fizzStrategy;
    }

    /**
     * @return IsEvenlyDivisibleStrategy
     */
    @Override
    public IsEvenlyDivisibleStrategy createIsEvenlyDivisibleStrategy() {
        return this.fizzStrategy;
    }

}
