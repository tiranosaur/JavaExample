package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.strategies.converters.primitivetypesconverters;

import org.springframework.stereotype.Service;

/**
 * Converter for DoubleToInt
 */
@Service
public final class DoubleToIntConverter {

    private DoubleToIntConverter() {
    }

    /**
     * @param dbDoubleToConvert double
     * @return int
     */
    public static int convert(final double dbDoubleToConvert) {
        return (int) dbDoubleToConvert;
    }

}
