package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.stringreturners;

import org.springframework.stereotype.Service;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.stringreturners.StringStringReturner;

/**
 * Returner for FizzString
 */
@Service
public class FizzStringReturner implements StringStringReturner {

    /**
     * @return String
     */
    public String getReturnString() {
        final String myString = com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.Constants.FIZZ;
        final char[] myCharacters = myString.toCharArray();
        return new String(myCharacters, 0, myCharacters.length);
    }

}
