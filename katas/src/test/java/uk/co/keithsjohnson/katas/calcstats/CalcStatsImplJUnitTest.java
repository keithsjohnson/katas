package uk.co.keithsjohnson.katas.calcstats;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalcStatsImplJUnitTest {

	private CalcStats testSubject;

	@Before
	public void setUp() {
		testSubject = new CalcStatsImpl();
	}

	@Test
	public void shouldProvideMinimumValue1() {

		// When
		int value = testSubject.minimumValue(new Integer[] { 6, 9, 15, -2, 92, 11 });

		// Then
		assertEquals(value, -2);
	}

	@Test
	public void shouldProvideMinimumValue2() {

		// When
		int value = testSubject.minimumValue(new Integer[] { 6, 9, 15, 1, 92, 11 });

		// Then
		assertEquals(value, 1);
	}

	@Test
	public void shouldProvideMaximumValue1() {
		// When
		int value = testSubject.maximumValue(new Integer[] { 6, 9, 15, -2, 92, 11 });

		// Then
		assertEquals(value, 92);
	}

	@Test
	public void shouldProvideMaximumValue2() {
		// When
		int value = testSubject.maximumValue(new Integer[] { 6, 9, 15, 1, 12, 11 });

		// Then
		assertEquals(value, 15);
	}

	@Test
	public void shouldProvideNumberOfElementsInTheSequence1() {
		// When
		int count = testSubject.count(new Integer[] { 6, 9, 15, -2, 92, 11 });

		// Then
		assertEquals(count, 6);
	}

	@Test
	public void shouldProvideNumberOfElementsInTheSequence2() {
		// When
		int count = testSubject.count(new Integer[] { 6, 9, 15 });

		// Then
		assertEquals(count, 3);
	}

	@Test
	public void shouldProvideAverageValue1() {
		// When
		double average = testSubject.averageValue(new double[] { 6D, 9D, 15D, -2D, 92D, 11D });

		// Then
		assertEquals(average, 21.83, 0.01D);
	}

	@Test
	public void shouldProvideAverageValue2() {
		// When
		double average = testSubject.averageValue(new double[] { 6, 9, 15 });

		// Then
		assertEquals(average, 10, 0D);
	}
}