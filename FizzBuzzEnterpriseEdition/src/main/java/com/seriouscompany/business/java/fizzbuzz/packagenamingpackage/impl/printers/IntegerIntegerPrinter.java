package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.printers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories.IntegerIntegerStringReturnerFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories.SystemOutFizzBuzzOutputStrategyFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.strategies.adapters.FizzBuzzOutputStrategyToFizzBuzzExceptionSafeOutputStrategyAdapter;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.printers.IntegerPrinter;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.stringreturners.IntegerStringReturner;

/**
 * Printer for IntegerInteger
 */
@Service
public class IntegerIntegerPrinter implements IntegerPrinter {

    private final SystemOutFizzBuzzOutputStrategyFactory systemOutFizzBuzzOutputStrategyFactory;

    private final IntegerIntegerStringReturnerFactory integerIntegerStringReturnerFactory;

    /**
     * @param integerIntegerStringReturnerFactory    IntegerIntegerStringReturnerFactory
     * @param systemOutFizzBuzzOutputStrategyFactory SystemOutFizzBuzzOutputStrategyFactory
     */
    @Autowired
    public IntegerIntegerPrinter(final IntegerIntegerStringReturnerFactory integerIntegerStringReturnerFactory,
                                 final SystemOutFizzBuzzOutputStrategyFactory systemOutFizzBuzzOutputStrategyFactory) {
        super();
        this.integerIntegerStringReturnerFactory = integerIntegerStringReturnerFactory;
        this.systemOutFizzBuzzOutputStrategyFactory = systemOutFizzBuzzOutputStrategyFactory;
    }

    /**
     * @param theInteger
     */
    public void printInteger(final int theInteger) {
        final IntegerStringReturner myIntegerStringReturner =
                this.integerIntegerStringReturnerFactory.createIntegerStringReturner();
        final String myIntegerString = myIntegerStringReturner.getIntegerReturnString(theInteger);
        final FizzBuzzOutputStrategyToFizzBuzzExceptionSafeOutputStrategyAdapter myOutputAdapter =
                new FizzBuzzOutputStrategyToFizzBuzzExceptionSafeOutputStrategyAdapter(
                        this.systemOutFizzBuzzOutputStrategyFactory.createOutputStrategy());

        myOutputAdapter.output(myIntegerString);
    }

    /**
     * @return void
     */
    @Override
    public void print() {
        throw new UnsupportedOperationException(
                com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.Constants.COM_SERIOUSCOMPANY_BUSINESS_JAVA_FIZZBUZZ_PACKAGENAMINGPACKAGE_IMPL_PRINTERS_INTEGER_INTEGER_PRINTER_PRINT);
    }

    /**
     * @param value
     */
    @Override
    public void printValue(final Object value) {
        this.printInteger((Integer) value);
    }

}
