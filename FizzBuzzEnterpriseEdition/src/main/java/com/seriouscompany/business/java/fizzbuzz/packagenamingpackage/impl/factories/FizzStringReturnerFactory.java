package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.stringreturners.FizzStringReturner;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.factories.StringStringReturnerFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.stringreturners.StringStringReturner;

/**
 * Factory for FizzStringReturner
 */
@Service
public class FizzStringReturnerFactory implements StringStringReturnerFactory {

    private final FizzStringReturner fizzStringReturner;

    /**
     * @param fizzStringReturner FizzStringReturner
     */
    @Autowired
    public FizzStringReturnerFactory(final FizzStringReturner fizzStringReturner) {
        super();
        this.fizzStringReturner = fizzStringReturner;
    }

    /**
     * @return StringStringReturner
     */
    @Override
    public StringStringReturner createStringStringReturner() {
        return this.fizzStringReturner;
    }

}
