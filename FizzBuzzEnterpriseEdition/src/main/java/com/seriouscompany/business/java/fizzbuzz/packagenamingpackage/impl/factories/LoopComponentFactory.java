package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.loop.LoopCondition;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.loop.LoopFinalizer;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.loop.LoopInitializer;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.loop.LoopStep;

/**
 * Factory for LoopComponent
 */
@Service
public class LoopComponentFactory {

    private final LoopCondition loopCondition;

    private final LoopInitializer loopInitializer;

    private final LoopStep loopStep;

    /**
     * @param loopCondition   LoopCondition
     * @param loopInitializer LoopInitializer
     * @param loopStep        LoopStep
     */
    @Autowired
    public LoopComponentFactory(final LoopCondition loopCondition, final LoopInitializer loopInitializer, final LoopStep loopStep) {
        super();
        this.loopCondition = loopCondition;
        this.loopInitializer = loopInitializer;
        this.loopStep = loopStep;
    }

    /**
     * @return LoopCondition
     */
    public LoopCondition createLoopCondition() {
        return this.loopCondition;
    }

    /**
     * @return LoopInitializer
     */
    public LoopInitializer createLoopInitializer() {
        return this.loopInitializer;
    }

    /**
     * @param nLoopFinalValue int
     * @return LoopFinalizer
     */
    public LoopFinalizer createLoopFinalizer(final int nLoopFinalValue) {
        return new LoopFinalizer(nLoopFinalValue);
    }

    /**
     * @return LoopStep
     */
    public LoopStep createLoopStep() {
        return this.loopStep;
    }

}
