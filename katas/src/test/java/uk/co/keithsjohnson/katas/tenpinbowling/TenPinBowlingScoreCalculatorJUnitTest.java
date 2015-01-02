package uk.co.keithsjohnson.katas.tenpinbowling;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TenPinBowlingScoreCalculatorJUnitTest {

	private TenPinBowlingScoreCalculator testSubject;

	@Before
	public void setUp() {
		testSubject = new TenPinBowlingScoreCalculator();
	}

	@Test
	public void shouldCalculateScore() {

		// Given

		// When
		int score = testSubject.score();

		// Then
		assertEquals(0, score);
	}
}
