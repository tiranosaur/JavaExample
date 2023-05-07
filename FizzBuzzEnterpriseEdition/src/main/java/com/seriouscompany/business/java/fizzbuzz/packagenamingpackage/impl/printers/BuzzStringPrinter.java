package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.printers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories.BuzzStringReturnerFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories.SystemOutFizzBuzzOutputStrategyFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.strategies.adapters.FizzBuzzOutputStrategyToFizzBuzzExceptionSafeOutputStrategyAdapter;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.printers.StringPrinter;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.stringreturners.StringStringReturner;

/**
 * Printer for BuzzString
 */
@Service
public class BuzzStringPrinter implements StringPrinter {

    private final SystemOutFizzBuzzOutputStrategyFactory outputStrategyFactory;

    private final BuzzStringReturnerFactory buzzStringReturnerFactory;

    /**
     * @param buzzStringReturnerFactory
     * @param outputStrategyFactory
     */
    @Autowired
    public BuzzStringPrinter(final BuzzStringReturnerFactory buzzStringReturnerFactory, final SystemOutFizzBuzzOutputStrategyFactory outputStrategyFactory) {
        super();
        this.buzzStringReturnerFactory = buzzStringReturnerFactory;
        this.outputStrategyFactory = outputStrategyFactory;
    }

    /**
     * @return void
     */
    public void print() {
        final StringStringReturner myBuzzStringReturner = this.buzzStringReturnerFactory.createStringStringReturner();
        final FizzBuzzOutputStrategyToFizzBuzzExceptionSafeOutputStrategyAdapter myOutputAdapter =
                new FizzBuzzOutputStrategyToFizzBuzzExceptionSafeOutputStrategyAdapter(this.outputStrategyFactory.createOutputStrategy());

        myOutputAdapter.output(myBuzzStringReturner.getReturnString());
    }

    /**
     * @param value
     * @return
     */
    @Override
    public void printValue(final Object value) {
        this.print();
    }

}
