package uk.co.keithsjohnson.katas.calcstats;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class CalcStatsImpl implements CalcStats {

	@Override
	public int minimumValue(Integer[] integers) {
		return Arrays.stream(integers).min(Integer::compare).get();
	}

	@Override
	public int maximumValue(Integer[] integers) {
		return Arrays.stream(integers).max(Integer::compare).get();
	}

	@Override
	public int count(Integer[] integers) {
		return integers.length;
	}

	@Override
	public double averageValue(double[] integers) {
		return Arrays.stream(integers).average().getAsDouble();
	}

}
