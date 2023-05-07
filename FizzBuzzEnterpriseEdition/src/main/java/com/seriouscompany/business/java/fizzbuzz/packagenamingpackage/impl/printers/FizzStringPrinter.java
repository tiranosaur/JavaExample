package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.printers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories.FizzStringReturnerFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories.SystemOutFizzBuzzOutputStrategyFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.strategies.adapters.FizzBuzzOutputStrategyToFizzBuzzExceptionSafeOutputStrategyAdapter;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.printers.StringPrinter;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.stringreturners.StringStringReturner;

/**
 * Printer for FizzString
 */
@Service
public class FizzStringPrinter implements StringPrinter {

    private final SystemOutFizzBuzzOutputStrategyFactory systemOutFizzBuzzOutputStrategyFactory;

    private final FizzStringReturnerFactory fizzStringReturnerFactory;

    /**
     * @param fizzStringReturnerFactory              FizzStringReturnerFactory
     * @param systemOutFizzBuzzOutputStrategyFactory SystemOutFizzBuzzOutputStrategyFactory
     */
    @Autowired
    public FizzStringPrinter(final FizzStringReturnerFactory fizzStringReturnerFactory,
                             final SystemOutFizzBuzzOutputStrategyFactory systemOutFizzBuzzOutputStrategyFactory) {
        super();
        this.fizzStringReturnerFactory = fizzStringReturnerFactory;
        this.systemOutFizzBuzzOutputStrategyFactory = systemOutFizzBuzzOutputStrategyFactory;
    }

    /**
     * @return void
     */
    public void print() {
        final StringStringReturner myFizzStringReturner = this.fizzStringReturnerFactory
                .createStringStringReturner();
        final FizzBuzzOutputStrategyToFizzBuzzExceptionSafeOutputStrategyAdapter myOutputAdapter =
                new FizzBuzzOutputStrategyToFizzBuzzExceptionSafeOutputStrategyAdapter(
                        this.systemOutFizzBuzzOutputStrategyFactory.createOutputStrategy());

        myOutputAdapter.output(myFizzStringReturner.getReturnString());
    }

    /**
     * @param value
     */
    @Override
    public void printValue(final Object value) {
        this.print();
    }

}
