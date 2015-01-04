package uk.co.keithsjohnson.katas.tenpinbowling;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uk.co.keithsjohnson.katas.tenpinbowling.model.LastRoundImpl;
import uk.co.keithsjohnson.katas.tenpinbowling.model.Round;
import uk.co.keithsjohnson.katas.tenpinbowling.model.RoundImpl;

public class TenPinBowlingScoreCalculatorImplJUnitTest {

	private TenPinBowlingScoreCalculator testSubject;

	@Before
	public void setUp() {
		testSubject = new TenPinBowlingScoreCalculatorImpl();
	}

	@Test
	public void should01CalculateScoreWhenNoRounds() {
		System.out.println("should01CalculateScoreWhenNoRounds");

		Round[] rounds = new Round[0];

		// When
		int[] score = testSubject.score(rounds);

		// Then
		assertEquals(0, score.length);
	}

	@Test
	public void should02CalculateScoreForFirstRound() {
		System.out.println("should02CalculateScoreForFirstRound");

		Round[] rounds = new Round[1];
		rounds[0] = new RoundImpl(1, 1);

		// When
		int[] score = testSubject.score(rounds);

		// Then
		assertEquals(2, score[0]);
	}

	@Test
	public void should03CalculateScoreForTwoRounds() {
		System.out.println("should03CalculateScoreForTwoRounds");

		Round[] rounds = new Round[2];
		rounds[0] = new RoundImpl(1, 1);
		rounds[1] = new RoundImpl(1, 1);

		// When
		int[] score = testSubject.score(rounds);

		// Then
		assertEquals(4, score[1]);
	}

	@Test
	public void should04CalculateScoreForTenRounds() {
		System.out.println("should04CalculateScoreForTenRounds");

		Round[] rounds = new Round[10];
		rounds[0] = new RoundImpl(1, 1);
		rounds[1] = new RoundImpl(1, 1);
		rounds[2] = new RoundImpl(1, 1);
		rounds[3] = new RoundImpl(1, 1);
		rounds[4] = new RoundImpl(1, 1);
		rounds[5] = new RoundImpl(1, 1);
		rounds[6] = new RoundImpl(1, 1);
		rounds[7] = new RoundImpl(1, 1);
		rounds[8] = new RoundImpl(1, 1);
		rounds[9] = new RoundImpl(1, 1);

		// When
		int[] score = testSubject.score(rounds);

		// Then
		assertEquals(20, score[9]);
	}

	@Test
	public void should05CalculateScoreForFirstRoundWithSpare() {
		System.out.println("should05CalculateScoreForFirstRoundWithSpare");

		Round[] rounds = new Round[1];
		rounds[0] = new RoundImpl(1, 9);

		// When
		int[] score = testSubject.score(rounds);

		// Then
		assertEquals(0, score[0]);
	}

	@Test
	public void should06CalculateScoreForTwoRoundsWithFirstRoundSpare() {
		System.out.println("should06CalculateScoreForTwoRoundsWithFirstRoundSpare");

		Round[] rounds = new Round[2];
		rounds[0] = new RoundImpl(1, 9);
		rounds[1] = new RoundImpl(1, 1);

		// When
		int[] score = testSubject.score(rounds);

		// Then
		assertEquals(13, score[1]);
	}

	@Test
	public void should07CalculateScoreForThreeRoundsWithFirstRoundSpareAndThirdRoundStrike() {
		System.out.println("should07CalculateScoreForThreeRoundsWithFirstRoundSpareAndThirdRoundStrike");

		Round[] rounds = new Round[3];
		rounds[0] = new RoundImpl(1, 9);
		rounds[1] = new RoundImpl(1, 1);
		rounds[2] = new RoundImpl(10);

		// When
		int[] score = testSubject.score(rounds);

		// Then
		assertEquals(13, score[2]);
	}

	@Test
	public void should08CalculateScoreForFourRoundsWithThirdRoundStrike() {
		System.out.println("should08CalculateScoreForFourRoundsWithThirdRoundStrike");

		Round[] rounds = new Round[4];
		rounds[0] = new RoundImpl(1, 9);
		rounds[1] = new RoundImpl(1, 1);
		rounds[2] = new RoundImpl(10);
		rounds[3] = new RoundImpl(1, 1);

		// When
		int[] score = testSubject.score(rounds);

		// Then
		assertEquals(27, score[3]);
	}

	@Test
	public void should09CalculateScoreForFiveRoundsWithThirdAndFourthRoundStrikes() {
		System.out.println("should09CalculateScoreForFiveRoundsWithThirdAndFourthRoundStrikes");

		Round[] rounds = new Round[4];
		rounds[0] = new RoundImpl(1, 9);
		rounds[1] = new RoundImpl(1, 1);
		rounds[2] = new RoundImpl(10);
		rounds[3] = new RoundImpl(10);

		// When
		int[] score = testSubject.score(rounds);

		// Then
		assertEquals(13, score[3]);
	}

	@Test
	public void should10CalculateScoreForfiveRoundsWithThirdAndFourthRoundStrikes() {
		System.out.println("should10CalculateScoreForSixRoundsWithThirdAndFourthRoundStrikes");

		Round[] rounds = new Round[5];
		rounds[0] = new RoundImpl(1, 9);
		rounds[1] = new RoundImpl(1, 1);
		rounds[2] = new RoundImpl(10);
		rounds[3] = new RoundImpl(10);
		rounds[4] = new RoundImpl(1, 1);

		// When
		int[] score = testSubject.score(rounds);

		// Then
		assertEquals(48, score[4]);
	}

	@Test
	public void should11CalculateScoreFor10Rounds() {
		System.out.println("should11CalculateScoreFor10Rounds");

		Round[] rounds = new Round[10];
		rounds[0] = new RoundImpl(1, 9);
		rounds[1] = new RoundImpl(1, 1);
		rounds[2] = new RoundImpl(10);
		rounds[3] = new RoundImpl(10);
		rounds[4] = new RoundImpl(1, 1);
		rounds[5] = new RoundImpl(1, 1);
		rounds[6] = new RoundImpl(1, 1);
		rounds[7] = new RoundImpl(1, 1);
		rounds[8] = new RoundImpl(1, 1);
		rounds[9] = new RoundImpl(1, 1);

		// When
		int[] score = testSubject.score(rounds);

		// Then
		assertEquals(58, score[9]);
	}

	@Test
	public void should12CalculateScoreFor9StrikeRoundsPlusSpare() {
		System.out.println("should12CalculateScoreFor9StrikeRoundsPlusSpare");

		Round[] rounds = new Round[10];
		rounds[0] = new RoundImpl(10);
		rounds[1] = new RoundImpl(10);
		rounds[2] = new RoundImpl(10);
		rounds[3] = new RoundImpl(10);
		rounds[4] = new RoundImpl(10);
		rounds[5] = new RoundImpl(10);
		rounds[6] = new RoundImpl(10);
		rounds[7] = new RoundImpl(10);
		rounds[8] = new RoundImpl(10);
		rounds[9] = new LastRoundImpl(1, 9, 10);

		// When
		int[] score = testSubject.score(rounds);

		// Then
		assertEquals(271, score[9]);
	}

	@Test
	public void should13CalculateScoreFor10StrikeRounds() {
		System.out.println("should13CalculateScoreFor10StrikeRounds");

		Round[] rounds = new Round[10];
		rounds[0] = new RoundImpl(10);
		rounds[1] = new RoundImpl(10);
		rounds[2] = new RoundImpl(10);
		rounds[3] = new RoundImpl(10);
		rounds[4] = new RoundImpl(10);
		rounds[5] = new RoundImpl(10);
		rounds[6] = new RoundImpl(10);
		rounds[7] = new RoundImpl(10);
		rounds[8] = new RoundImpl(10);
		rounds[9] = new LastRoundImpl(10, 10, 10);

		// When
		int[] score = testSubject.score(rounds);

		// Then
		assertEquals(300, score[9]);
	}

	@Test
	public void should14CalculateScoreFor9StrikeRoundsAndASpare() {
		System.out.println("should14CalculateScoreFor9StrikeRoundsAndASpare");

		Round[] rounds = new Round[10];
		rounds[0] = new RoundImpl(1, 9);
		rounds[1] = new RoundImpl(1, 9);
		rounds[2] = new RoundImpl(1, 9);
		rounds[3] = new RoundImpl(1, 9);
		rounds[4] = new RoundImpl(1, 9);
		rounds[5] = new RoundImpl(1, 9);
		rounds[6] = new RoundImpl(1, 9);
		rounds[7] = new RoundImpl(1, 9);
		rounds[8] = new RoundImpl(1, 9);
		rounds[9] = new LastRoundImpl(1, 9, 1);

		// When
		int[] score = testSubject.score(rounds);

		// Then
		assertEquals(110, score[9]);
	}

	@Test
	public void should14CalculateScoreFor10Rounds() {
		System.out.println("should14CalculateScoreFor10StrikeRounds");

		Round[] rounds = new Round[10];
		rounds[0] = new RoundImpl(1, 9);
		rounds[1] = new RoundImpl(1, 9);
		rounds[2] = new RoundImpl(1, 9);
		rounds[3] = new RoundImpl(1, 9);
		rounds[4] = new RoundImpl(1, 9);
		rounds[5] = new RoundImpl(1, 9);
		rounds[6] = new RoundImpl(1, 9);
		rounds[7] = new RoundImpl(1, 9);
		rounds[8] = new RoundImpl(1, 9);
		rounds[9] = new LastRoundImpl(1, 9, 1);

		// When
		int[] score = testSubject.score(rounds);

		// Then
		assertEquals(110, score[9]);
	}

	@Test
	public void should15CalculateScoreFor9StrikeRounds() {
		System.out.println("should15CalculateScoreFor9StrikeRounds");

		Round[] rounds = new Round[10];
		rounds[0] = new RoundImpl(10);
		rounds[1] = new RoundImpl(10);
		rounds[2] = new RoundImpl(10);
		rounds[3] = new RoundImpl(10);
		rounds[4] = new RoundImpl(10);
		rounds[5] = new RoundImpl(10);
		rounds[6] = new RoundImpl(10);
		rounds[7] = new RoundImpl(10);
		rounds[8] = new RoundImpl(10);
		rounds[9] = new RoundImpl(1, 8);

		// When
		int[] score = testSubject.score(rounds);

		// Then
		assertEquals(259, score[9]);
	}

	@Test
	public void should16CalculateScoreFor10Rounds() {
		System.out.println("should16CalculateScoreFor10Rounds");

		Round[] rounds = new Round[10];
		rounds[0] = new RoundImpl(0, 0);
		rounds[1] = new RoundImpl(1, 1);
		rounds[2] = new RoundImpl(2, 2);
		rounds[3] = new RoundImpl(3, 3);
		rounds[4] = new RoundImpl(4, 4);
		rounds[5] = new RoundImpl(5, 5);
		rounds[6] = new RoundImpl(6, 4);
		rounds[7] = new RoundImpl(7, 3);
		rounds[8] = new RoundImpl(8, 2);
		rounds[9] = new RoundImpl(9, 0);

		// When
		int[] score = testSubject.score(rounds);

		// Then
		assertEquals(99, score[9]);
	}

	@Test
	public void should17CalculateScoreFor10NormalRoundsWithLastRound() {
		System.out.println("should16CalculateScoreFor10Rounds");

		Round[] rounds = new Round[10];
		rounds[0] = new RoundImpl(0, 0);
		rounds[1] = new RoundImpl(1, 1);
		rounds[2] = new RoundImpl(2, 2);
		rounds[3] = new RoundImpl(3, 3);
		rounds[4] = new RoundImpl(4, 4);
		rounds[5] = new RoundImpl(5, 5);
		rounds[6] = new RoundImpl(6, 4);
		rounds[7] = new RoundImpl(7, 3);
		rounds[8] = new RoundImpl(8, 2);
		rounds[9] = new LastRoundImpl(9, 0);

		// When
		int[] score = testSubject.score(rounds);

		// Then
		assertEquals(99, score[9]);
	}
}
