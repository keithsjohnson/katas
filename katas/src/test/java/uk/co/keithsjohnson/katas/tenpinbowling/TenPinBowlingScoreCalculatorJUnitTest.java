package uk.co.keithsjohnson.katas.tenpinbowling;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import uk.co.keithsjohnson.katas.tenpinbowling.model.Round;

public class TenPinBowlingScoreCalculatorJUnitTest {

	private TenPinBowlingScoreCalculator testSubject;

	@Before
	public void setUp() {
		testSubject = new TenPinBowlingScoreCalculator();
	}

	@Test
	public void shouldCalculateScore() {

		List<Round> rounds = new ArrayList<Round>();

		// When
		int score = testSubject.score(rounds);

		// Then
		assertEquals(0, score);
	}
}
