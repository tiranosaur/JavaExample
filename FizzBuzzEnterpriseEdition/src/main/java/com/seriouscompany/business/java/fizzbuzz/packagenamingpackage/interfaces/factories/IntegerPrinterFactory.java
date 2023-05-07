package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.factories;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.printers.IntegerPrinter;

/**
 * Factory for IntegerPrinter
 */
public interface IntegerPrinterFactory {

    /**
     * @return IntegerPrinter
     */
    IntegerPrinter createPrinter();

}
