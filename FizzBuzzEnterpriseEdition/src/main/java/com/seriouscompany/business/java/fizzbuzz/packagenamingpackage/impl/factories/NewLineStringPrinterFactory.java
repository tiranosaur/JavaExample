package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.printers.NewLineStringPrinter;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.factories.StringPrinterFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.printers.StringPrinter;

/**
 * Factory for NewLineStringPrinter
 */
@Service
public class NewLineStringPrinterFactory implements StringPrinterFactory {

    private final NewLineStringPrinter newLineStringPrinter;

    /**
     * @param newLineStringPrinter NewLineStringPrinter
     */
    @Autowired
    public NewLineStringPrinterFactory(final NewLineStringPrinter newLineStringPrinter) {
        super();
        this.newLineStringPrinter = newLineStringPrinter;
    }

    /**
     * @return StringPrinter
     */
    @Override
    public StringPrinter createStringPrinter() {
        return this.newLineStringPrinter;
    }

}
