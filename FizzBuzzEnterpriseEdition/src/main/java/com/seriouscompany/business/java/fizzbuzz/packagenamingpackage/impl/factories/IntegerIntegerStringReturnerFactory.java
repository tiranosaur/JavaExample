package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.stringreturners.IntegerIntegerStringReturner;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.factories.IntegerStringReturnerFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.stringreturners.IntegerStringReturner;

/**
 * Factory for IntegerIntegerStringReturner
 */
@Service
public class IntegerIntegerStringReturnerFactory implements IntegerStringReturnerFactory {

    private final IntegerIntegerStringReturner integerIntegerStringReturner;

    /**
     * @param integerIntegerStringReturner IntegerIntegerStringReturner
     */
    @Autowired
    public IntegerIntegerStringReturnerFactory(final IntegerIntegerStringReturner integerIntegerStringReturner) {
        super();
        this.integerIntegerStringReturner = integerIntegerStringReturner;
    }

    /**
     * @return IntegerStringReturner
     */
    @Override
    public IntegerStringReturner createIntegerStringReturner() {
        return this.integerIntegerStringReturner;
    }

}
