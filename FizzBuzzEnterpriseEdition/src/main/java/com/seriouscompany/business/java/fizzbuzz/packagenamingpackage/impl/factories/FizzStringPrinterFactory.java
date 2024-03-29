package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.printers.FizzStringPrinter;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.factories.StringPrinterFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.printers.StringPrinter;

/**
 * Factory for FizzStringPrinter
 */
@Service
public class FizzStringPrinterFactory implements StringPrinterFactory {

    private final FizzStringPrinter fizzStringPrinter;

    /**
     * @param fizzStringPrinter FizzStringPrinter
     */
    @Autowired
    public FizzStringPrinterFactory(final FizzStringPrinter fizzStringPrinter) {
        super();
        this.fizzStringPrinter = fizzStringPrinter;
    }

    /**
     * @return StringPrinter
     */
    @Override
    public StringPrinter createStringPrinter() {
        return this.fizzStringPrinter;
    }

}
