package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.strategies.NoFizzNoBuzzStrategy;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.factories.IsEvenlyDivisibleStrategyFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.strategies.IsEvenlyDivisibleStrategy;

/**
 * Factory for NoFizzNoBuzzStrategy
 */
@Service
public class NoFizzNoBuzzStrategyFactory implements IsEvenlyDivisibleStrategyFactory {

    private final NoFizzNoBuzzStrategy noFizzNoBuzzStrategy;

    /**
     * @param noFizzNoBuzzStrategy NoFizzNoBuzzStrategy
     */
    @Autowired
    public NoFizzNoBuzzStrategyFactory(final NoFizzNoBuzzStrategy noFizzNoBuzzStrategy) {
        super();
        this.noFizzNoBuzzStrategy = noFizzNoBuzzStrategy;
    }

    /**
     * @return IsEvenlyDivisibleStrategy
     */
    @Override
    public IsEvenlyDivisibleStrategy createIsEvenlyDivisibleStrategy() {
        return this.noFizzNoBuzzStrategy;
    }

}
