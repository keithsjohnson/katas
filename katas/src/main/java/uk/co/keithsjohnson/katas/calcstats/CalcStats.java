package uk.co.keithsjohnson.katas.calcstats;

import java.util.Arrays;

public class CalcStats {

	public int minimumValue(Integer[] integers) {
		return Arrays.stream(integers).min(Integer::compare).get();
	}

	public int maximumValue(Integer[] integers) {
		return Arrays.stream(integers).max(Integer::compare).get();
	}

	public int count(Integer[] integers) {
		return integers.length;
	}

	public double averageValue(double[] integers) {
		return Arrays.stream(integers).average().getAsDouble();
	}

}
