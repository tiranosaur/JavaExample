package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.printers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories.NewLineStringReturnerFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories.SystemOutFizzBuzzOutputStrategyFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.strategies.adapters.FizzBuzzOutputStrategyToFizzBuzzExceptionSafeOutputStrategyAdapter;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.printers.StringPrinter;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.stringreturners.StringStringReturner;

/**
 * Printer for NewLineString
 */
@Service
public class NewLineStringPrinter implements StringPrinter {

    private final SystemOutFizzBuzzOutputStrategyFactory systemOutFizzBuzzOutputStrategyFactory;

    private final NewLineStringReturnerFactory newLineStringReturnerFactory;

    /**
     * @param newLineStringReturnerFactory           NewLineStringReturnerFactory
     * @param systemOutFizzBuzzOutputStrategyFactory SystemOutFizzBuzzOutputStrategyFactory
     */
    @Autowired
    public NewLineStringPrinter(final NewLineStringReturnerFactory newLineStringReturnerFactory,
                                final SystemOutFizzBuzzOutputStrategyFactory systemOutFizzBuzzOutputStrategyFactory) {
        super();
        this.newLineStringReturnerFactory = newLineStringReturnerFactory;
        this.systemOutFizzBuzzOutputStrategyFactory = systemOutFizzBuzzOutputStrategyFactory;
    }

    /**
     * @return void
     */
    public void print() {
        final StringStringReturner myNewLineStringReturner = this.newLineStringReturnerFactory
                .createStringStringReturner();
        final String myNewLineString = myNewLineStringReturner.getReturnString();
        final FizzBuzzOutputStrategyToFizzBuzzExceptionSafeOutputStrategyAdapter myOutputAdapter =
                new FizzBuzzOutputStrategyToFizzBuzzExceptionSafeOutputStrategyAdapter(
                        this.systemOutFizzBuzzOutputStrategyFactory.createOutputStrategy());

        myOutputAdapter.output(myNewLineString);
    }

    /**
     * @param value Object
     */
    @Override
    public void printValue(final Object value) {
        this.print();
    }

}
