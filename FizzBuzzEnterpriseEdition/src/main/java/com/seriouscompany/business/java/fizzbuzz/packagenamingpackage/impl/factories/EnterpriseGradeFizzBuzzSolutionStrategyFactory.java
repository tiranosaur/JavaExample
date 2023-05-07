package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.factories.FizzBuzzSolutionStrategyFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.strategies.FizzBuzzSolutionStrategy;

/**
 * Factory for EnterpriseGradeFizzBuzzSolutionStrategy
 */
@Service
public class EnterpriseGradeFizzBuzzSolutionStrategyFactory implements FizzBuzzSolutionStrategyFactory {

    private final FizzBuzzSolutionStrategy fizzBuzzSolutionStrategy;

    /**
     * @param fizzBuzzSolutionStrategy FizzBuzzSolutionStrategy
     */
    @Autowired
    public EnterpriseGradeFizzBuzzSolutionStrategyFactory(final FizzBuzzSolutionStrategy fizzBuzzSolutionStrategy) {
        super();
        this.fizzBuzzSolutionStrategy = fizzBuzzSolutionStrategy;
    }

    /**
     * @return FizzBuzzSolutionStrategy
     */
    @Override
    public FizzBuzzSolutionStrategy createFizzBuzzSolutionStrategy() {
        return this.fizzBuzzSolutionStrategy;
    }

}
