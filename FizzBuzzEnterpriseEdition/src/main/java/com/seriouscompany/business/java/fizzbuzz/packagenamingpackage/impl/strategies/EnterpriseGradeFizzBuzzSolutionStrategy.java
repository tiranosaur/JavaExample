package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.strategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.loop.LoopContext;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.loop.LoopRunner;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.loop.LoopPayloadExecution;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.strategies.FizzBuzzSolutionStrategy;

/**
 * Strategy for EnterpriseGradeFizzBuzzSolution
 */
@Service
public class EnterpriseGradeFizzBuzzSolutionStrategy implements FizzBuzzSolutionStrategy {

    private final LoopPayloadExecution loopPayloadExecution;

    /**
     * @param loopPayloadExecution LoopPayloadExecution
     */
    @Autowired
    public EnterpriseGradeFizzBuzzSolutionStrategy(final LoopPayloadExecution loopPayloadExecution) {
        super();
        this.loopPayloadExecution = loopPayloadExecution;
    }

    /**
     * @param nFizzBuzzUpperLimit int
     * @return void
     */
    @Override
    public void runSolution(final int nFizzBuzzUpperLimit) {
        final LoopContext loopContext = new LoopContext(nFizzBuzzUpperLimit);
        final LoopRunner loopRunner = new LoopRunner(loopContext, loopContext, this.loopPayloadExecution);
        loopRunner.runLoop();
    }

}
