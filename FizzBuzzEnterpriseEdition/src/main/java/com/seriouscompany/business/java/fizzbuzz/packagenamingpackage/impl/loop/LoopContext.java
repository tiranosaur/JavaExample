package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.loop;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.Constants;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories.LoopComponentFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.loop.LoopContextStateManipulation;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.loop.LoopContextStateRetrieval;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * LoopContext
 */
public final class LoopContext implements LoopContextStateManipulation, LoopContextStateRetrieval {

    private final LoopInitializer myLoopInitializer;
    private final LoopFinalizer myLoopFinalizer;
    private final LoopCondition myLoopCondition;
    private final LoopStep myLoopStep;
    private int myCurrentControlParameterValue;

    /**
     * @param nLoopControlParameterFinalValue int
     */
    public LoopContext(final int nLoopControlParameterFinalValue) {
        super();
        final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(Constants.SPRING_XML);
        final LoopComponentFactory myLoopComponentFactory = context.getBean(Constants.LOOP_COMPONENT_FACTORY,
                LoopComponentFactory.class);
        this.myLoopInitializer = myLoopComponentFactory.createLoopInitializer();
        this.myLoopFinalizer = myLoopComponentFactory.createLoopFinalizer(nLoopControlParameterFinalValue);
        this.myLoopCondition = myLoopComponentFactory.createLoopCondition();
        this.myLoopStep = myLoopComponentFactory.createLoopStep();
        context.close();
    }

    /**
     * @return void
     */
    @Override
    public void start() {
        this.myCurrentControlParameterValue =
                this.myLoopInitializer.getLoopInitializationPoint();
    }

    /**
     * @return boolean
     */
    @Override
    public boolean shouldProceed() {
        return this.myLoopCondition.evaluateLoop(this.myCurrentControlParameterValue,
                this.myLoopFinalizer.getLoopFinalizationPoint());
    }

    /**
     * @return void
     */
    @Override
    public void proceed() {
        this.myCurrentControlParameterValue =
                this.myLoopStep.stepLoop(this.myCurrentControlParameterValue);
    }

    /**
     * @return int
     */
    @Override
    public int getControlParameter() {
        return this.myCurrentControlParameterValue;
    }

}
