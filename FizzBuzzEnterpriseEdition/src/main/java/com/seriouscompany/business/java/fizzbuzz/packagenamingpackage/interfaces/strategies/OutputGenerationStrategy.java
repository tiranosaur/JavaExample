package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.strategies;

/**
 * Strategy for OutputGeneration
 */
public interface OutputGenerationStrategy {

    /**
     * @param generationParameter SingleStepOutputGenerationParameter
     */
    void performGenerationForCurrentStep(SingleStepOutputGenerationParameter generationParameter);

}
