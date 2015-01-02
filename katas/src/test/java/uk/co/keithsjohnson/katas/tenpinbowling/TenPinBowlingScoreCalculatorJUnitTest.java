package uk.co.keithsjohnson.katas.tenpinbowling;

import static org.junit.Assert.assertEquals;

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
	public void should01CalculateScoreWhenNoRounds() {
		System.out.println("should01CalculateScoreWhenNoRounds");

		Round[] rounds = new Round[10];

		// When
		int score = testSubject.score(rounds);

		// Then
		assertEquals(0, score);
	}

	@Test
	public void should02CalculateScoreForFirstRound() {
		System.out.println("should02CalculateScoreForFirstRound");

		Round[] rounds = new Round[10];
		rounds[0] = new Round(1, 1);

		// When
		int score = testSubject.score(rounds);

		// Then
		assertEquals(2, score);
	}

	@Test
	public void should03CalculateScoreForTwoRounds() {
		System.out.println("should03CalculateScoreForTwoRounds");

		Round[] rounds = new Round[10];
		rounds[0] = new Round(1, 1);
		rounds[1] = new Round(1, 1);

		// When
		int score = testSubject.score(rounds);

		// Then
		assertEquals(4, score);
	}

	@Test
	public void should04CalculateScoreForTenRounds() {
		System.out.println("should04CalculateScoreForTenRounds");

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
	public void should05CalculateScoreForFirstRoundWithSpare() {
		System.out.println("should05CalculateScoreForFirstRoundWithSpare");

		Round[] rounds = new Round[10];
		rounds[0] = new Round(1, 9);

		// When
		int score = testSubject.score(rounds);

		// Then
		assertEquals(0, score);
	}

	@Test
	public void should06CalculateScoreForTwoRoundsWithFirstRoundSpare() {
		System.out.println("should06CalculateScoreForTwoRoundsWithFirstRoundSpare");

		Round[] rounds = new Round[10];
		rounds[0] = new Round(1, 9);
		rounds[1] = new Round(1, 1);

		// When
		int score = testSubject.score(rounds);

		// Then
		assertEquals(13, score);
	}

	@Test
	public void should07CalculateScoreForThreeRoundsWithFirstRoundSpareAndThirdRoundStrike() {
		System.out.println("should07CalculateScoreForThreeRoundsWithFirstRoundSpareAndThirdRoundStrike");

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
	public void should08CalculateScoreForFourRoundsWithThirdRoundStrike() {
		System.out.println("should08CalculateScoreForFourRoundsWithThirdRoundStrike");

		Round[] rounds = new Round[10];
		rounds[0] = new Round(1, 9);
		rounds[1] = new Round(1, 1);
		rounds[2] = new Round(10);
		rounds[3] = new Round(1, 1);

		// When
		int score = testSubject.score(rounds);

		// Then
		assertEquals(27, score);
	}

	@Test
	public void should09CalculateScoreForFiveRoundsWithThirdAndFourthRoundStrikes() {
		System.out.println("should09CalculateScoreForFiveRoundsWithThirdAndFourthRoundStrikes");

		Round[] rounds = new Round[10];
		rounds[0] = new Round(1, 9);
		rounds[1] = new Round(1, 1);
		rounds[2] = new Round(10);
		rounds[3] = new Round(10);

		// When
		int score = testSubject.score(rounds);

		// Then
		assertEquals(13, score);
	}

	@Test
	public void should10CalculateScoreForSixRoundsWithThirdAndFourthRoundStrikes() {
		System.out.println("should10CalculateScoreForSixRoundsWithThirdAndFourthRoundStrikes");

		Round[] rounds = new Round[10];
		rounds[0] = new Round(1, 9);
		rounds[1] = new Round(1, 1);
		rounds[2] = new Round(10);
		rounds[3] = new Round(10);
		rounds[4] = new Round(1, 1);

		// When
		int score = testSubject.score(rounds);

		// Then
		assertEquals(48, score);
	}

}
