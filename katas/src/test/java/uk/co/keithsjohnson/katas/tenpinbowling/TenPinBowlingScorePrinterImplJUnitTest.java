package uk.co.keithsjohnson.katas.tenpinbowling;

import org.junit.Before;
import org.junit.Test;

import uk.co.keithsjohnson.katas.tenpinbowling.model.LastRoundImpl;
import uk.co.keithsjohnson.katas.tenpinbowling.model.Round;
import uk.co.keithsjohnson.katas.tenpinbowling.model.RoundImpl;

public class TenPinBowlingScorePrinterImplJUnitTest {

	private TenPinBowlingScorePrinter testSubject;

	@Before
	public void setUp() {
		testSubject = new TenPinBowlingScorePrinterImpl();
	}

	@Test
	public void shouldPrintScoreFor10StrikeRounds() {
		System.out.println("shouldPrintScoreFor10StrikeRounds");

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

		int[] results = { 30, 60, 90, 120, 150, 180, 210, 240, 270, 300 };

		// When
		testSubject.printScore(rounds, results);

		// Then
	}

	@Test
	public void shouldPrintScoreFor10SpareRounds() {
		System.out.println("shouldPrintScoreFor10SpareRounds");

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

		int[] results = { 11, 22, 33, 44, 55, 66, 77, 88, 99, 110 };

		// When
		testSubject.printScore(rounds, results);

		// Then
	}

	@Test
	public void shouldPrintScoreFor10Rounds() {
		System.out.println("shouldPrintScoreFor10StrikeRounds");

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

		int[] results = { 0, 2, 6, 12, 20, 36, 53, 71, 90, 99 };

		// When
		testSubject.printScore(rounds, results);

		// Then
	}

	@Test
	public void shouldPrintScoreFor10RoundsWithLastRound() {
		System.out.println("shouldPrintScoreFor10RoundsWithLastRound");

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

		int[] results = { 0, 2, 6, 12, 20, 36, 53, 71, 90, 99 };

		// When
		testSubject.printScore(rounds, results);

		// Then
	}

}
