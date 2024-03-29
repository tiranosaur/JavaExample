package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.stringreturners;

import org.springframework.stereotype.Service;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.stringreturners.StringStringReturner;

/**
 * Returner for BuzzString
 */
@Service
public class BuzzStringReturner implements StringStringReturner {

    /**
     * @return String
     */
    public String getReturnString() {
        return com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.Constants.BUZZ;
    }

}
