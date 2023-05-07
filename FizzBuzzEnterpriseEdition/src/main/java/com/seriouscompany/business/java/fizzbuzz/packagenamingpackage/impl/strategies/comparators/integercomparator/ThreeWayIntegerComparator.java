package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.strategies.comparators.integercomparator;

import org.springframework.stereotype.Service;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.Constants;

/**
 * Comparator for ThreeWayInteger
 */
@Service
public final class ThreeWayIntegerComparator {

	private ThreeWayIntegerComparator() {}

	/**
	 * @param nFirstInteger int
	 * @param nSecondInteger int
	 * @return ThreeWayIntegerComparisonResult
	 */
	public static ThreeWayIntegerComparisonResult compare(final int nFirstInteger, final int nSecondInteger) {
		if (nFirstInteger == nSecondInteger) {
			return ThreeWayIntegerComparisonResult.FIRST_EQUALS_SECOND;
		} else if (nFirstInteger < nSecondInteger) {
			return ThreeWayIntegerComparisonResult.FIRST_IS_LESS_THAN_SECOND;
		} else if (nFirstInteger > nSecondInteger) {
			return ThreeWayIntegerComparisonResult.FIRST_IS_GREATER_THAN_SECOND;
		} else {
			// If the integers cannot be compared, then something is seriously wrong with the numbers.
			throw new UnsupportedOperationException(Constants.THE_INTEGERS_COULD_NOT_BE_COMPARED);
		}
	}

}
