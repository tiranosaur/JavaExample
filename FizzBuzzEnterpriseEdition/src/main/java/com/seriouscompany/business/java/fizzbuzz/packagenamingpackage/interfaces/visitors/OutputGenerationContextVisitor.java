package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.interfaces.visitors;

/**
 * Visitor for OutputGenerationContext
 */
public interface OutputGenerationContextVisitor {

    /**
     * @param context              OutputGenerationContext
     * @param nGenerationParameter nGenerationParameter
     */
    void visit(OutputGenerationContext context, int nGenerationParameter);

}
