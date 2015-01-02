package uk.co.keithsjohnson.katas.tenpinbowling;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import uk.co.keithsjohnson.katas.tenpinbowling.model.Round;

public class TenPinBowlingScoreCalculatorJUnitTest {

	private TenPinBowlingScoreCalculator testSubject;

	@Before
	public void setUp() {
		testSubject = new TenPinBowlingScoreCalculator();
	}

	@Test
	public void shouldCalculateScoreWhenNoRounds() {

		Round[] rounds = new Round[10];

		// When
		int score = testSubject.score(rounds);

		// Then
		assertEquals(0, score);
	}

	@Test
	public void shouldCalculateScoreForFirstRound() {

		Round[] rounds = new Round[10];
		rounds[0] = new Round(1, 1);

		// When
		int score = testSubject.score(rounds);

		// Then
		assertEquals(2, score);
	}

	@Test
	public void shouldCalculateScoreForTwoRounds() {

		Round[] rounds = new Round[10];
		rounds[0] = new Round(1, 1);
		rounds[1] = new Round(1, 1);

		// When
		int score = testSubject.score(rounds);

		// Then
		assertEquals(4, score);
	}

	@Test
	public void shouldCalculateScoreForTenRounds() {

		Round[] rounds = new Round[10];
		rounds[0] = new Round(1, 1);
		rounds[1] = new Round(1, 1);
		rounds[2] = new Round(1, 1);
		rounds[3] = new Round(1, 1);
		rounds[4] = new Round(1, 1);
		rounds[5] = new Round(1, 1);
		rounds[6] = new Round(1, 1);
		rounds[7] = new Round(1, 1);
		rounds[8] = new Round(1, 1);
		rounds[9] = new Round(1, 1);

		// When
		int score = testSubject.score(rounds);

		// Then
		assertEquals(20, score);
	}

	@Test
	public void shouldCalculateScoreForFirstRoundWithSpare() {

		Round[] rounds = new Round[10];
		rounds[0] = new Round(1, 9);

		// When
		int score = testSubject.score(rounds);

		// Then
		assertEquals(0, score);
	}

	@Test
	public void shouldCalculateScoreForTwoRoundsWithFirstRoundSpare() {

		Round[] rounds = new Round[10];
		rounds[0] = new Round(1, 9);
		rounds[1] = new Round(1, 1);

		// When
		int score = testSubject.score(rounds);

		// Then
		assertEquals(13, score);
	}

	@Test
	public void shouldCalculateScoreForThreeRoundsWithFirstRoundSpareAndThirdRoundStrike() {

		Round[] rounds = new Round[10];
		rounds[0] = new Round(1, 9);
		rounds[1] = new Round(1, 1);
		rounds[2] = new Round(10);

		// When
		int score = testSubject.score(rounds);

		// Then
		assertEquals(13, score);
	}

	@Test
	@Ignore
	public void shouldCalculateScoreForFourRoundsWithThirdRoundStrike() {

		Round[] rounds = new Round[10];
		rounds[0] = new Round(1, 9);
		rounds[1] = new Round(1, 1);
		rounds[2] = new Round(10);
		rounds[2] = new Round(1, 1);

		// When
		int score = testSubject.score(rounds);

		// Then
		assertEquals(13, score);
	}

}
