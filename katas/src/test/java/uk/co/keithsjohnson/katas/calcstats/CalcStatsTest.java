package uk.co.keithsjohnson.katas.calcstats;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.stereotype.Component;

@Component
public class CalcStatsTest {

	private final CalcStats calcStats = new CalcStats();

	@Test
	public void minimumValue1() {

		int value = calcStats.minimumValue(new Integer[] { 6, 9, 15, -2, 92, 11 });

		assertEquals(value, -2);
	}

	@Test
	public void minimumValue2() {

		int value = calcStats.minimumValue(new Integer[] { 6, 9, 15, 1, 92, 11 });

		assertEquals(value, 1);
	}

	@Test
	public void maximumValue1() {
		int value = calcStats.maximumValue(new Integer[] { 6, 9, 15, -2, 92, 11 });
		assertEquals(value, 92);
	}

	@Test
	public void maximumValue2() {
		int value = calcStats.maximumValue(new Integer[] { 6, 9, 15, 1, 12, 11 });
		assertEquals(value, 15);
	}

	@Test
	public void numberOfElementsInTheSequence1() {
		int count = calcStats.count(new Integer[] { 6, 9, 15, -2, 92, 11 });
		assertEquals(count, 6);
	}

	@Test
	public void numberOfElementsInTheSequence2() {
		int count = calcStats.count(new Integer[] { 6, 9, 15 });
		assertEquals(count, 3);
	}

	@Test
	public void averageValue1() {
		double average = calcStats.averageValue(new double[] { 6D, 9D, 15D, -2D, 92D, 11D });
		assertEquals(average, 21.83, 0.01D);
	}

	@Test
	public void averageValue2() {
		double average = calcStats.averageValue(new double[] { 6, 9, 15 });
		assertEquals(average, 10, 0D);
	}
}